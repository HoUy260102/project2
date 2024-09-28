package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.Utils.NumberUtil;
import com.javaweb.Utils.StringUtil;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	public void joinQuery(Map<String, Object> param, StringBuilder joinSql) {
		if (param.containsKey("districtId")) {
			joinSql.append(" join district d on b.districtid=d.id\r\n");
		}
		if (param.containsKey("staffId")) {
			joinSql.append(" join assignmentbuilding ab on ab.buildingid=b.id\r\n"
					+ " join user u on ab.staffid=u.id\r\n");
		}
		if (param.containsKey("rentAreaFrom")||param.containsKey("rentAreaTo")) {
			joinSql.append(" join rentarea r on r.buildingid=b.id\r\n");
		}
		if (param.containsKey("rentType")) {
			joinSql.append(" join buildingrenttype br on br.buildingid=b.id\r\n"
					+ " join renttype rt on rt.id=br.renttypeid\r\n");
		}
	}
	public void queryNormal(Map<String, Object> param, StringBuilder conditionQuery) {
		for (Map.Entry<String, Object> it : param.entrySet()) {
			if (!it.getKey().equals("staffId")&&!it.getKey().equals("rentType")&&!it.getKey().startsWith("rentArea")&&!it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if (StringUtil.checkString(value)) {
					if (NumberUtil.checkNumber(value)) {
						conditionQuery.append(" and b."+it.getKey()+"="+value);
					}
					else {
						conditionQuery.append(" and b."+it.getKey()+" like '%"+value+"%'");
					}
				}
			}
		}
	}
	public void querySpecial(Map<String, Object> param, List<String> rentType, StringBuilder conditionQuery) {
		String staffId = param.get("staffId").toString();
		if (StringUtil.checkString(staffId)) {
			conditionQuery.append(" and u.id = "+staffId);
		}
		String rentAreaFrom = (String)param.get("rentAreaFrom");
		String rentAreaTo = (String)param.get("rentAreaTo");
		String rentPriceFrom = (String)param.get("rentPriceFrom");
		String rentPriceTo = (String)param.get("rentPriceTo");
		String rentTypes;
		if (StringUtil.checkString(rentAreaFrom)) {
			conditionQuery.append(" and r.value >= "+rentAreaFrom);
		}
		if (StringUtil.checkString(rentAreaTo)) {
			conditionQuery.append(" and r.value <= "+rentAreaTo);
		}
		if (StringUtil.checkString(rentPriceFrom)) {
			conditionQuery.append(" and b.rentprice >= "+rentPriceFrom);
		}
		if (StringUtil.checkString(rentAreaTo)) {
			conditionQuery.append(" and b.rentprice <=  "+rentPriceTo);
		}
		if (rentType.size()!=0&&rentType!=null) {
			rentTypes = rentType.stream().map(item -> "'"+item+"'").collect(Collectors.joining(","));
			conditionQuery.append(" and rt.code in ("+rentTypes+")");
		}
	}
	@Override
	public List<BuildingEntity> findAll(String name) {
		String sql = "select * from building where name like '%"+name+"%'";
		List<BuildingEntity> list = new ArrayList<>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setWard(rs.getString("ward"));
				building.setStreet(rs.getString("street"));
				building.setNumberOfBasement(rs.getInt("numberofbasement"));
				list.add(building);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return list;
	}
	@Override
	public List<BuildingEntity> find(Map<String, Object> param, List<String> rentType) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select b.name, b.floorarea, b.districtid, b.ward, b.street, b.numberofbasement, b.rentprice, b.managername, b.managerphonenumber, b.servicefee, b.brokeragefee, b.id from building b\r\n"); 
		StringBuilder joinSql = new StringBuilder();
		joinQuery(param, joinSql);
		StringBuilder conditionQuery = new StringBuilder();
		queryNormal(param, conditionQuery);
		querySpecial(param, rentType, conditionQuery);
		sql.append(joinSql);
		sql.append(" where 1=1");
		sql.append(conditionQuery);
		sql.append(" Group by b.id");
		System.out.println(sql);
		List<BuildingEntity> listBuldings = new ArrayList<BuildingEntity>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
					) {
				while (rs.next()) {
					BuildingEntity building = new BuildingEntity();
					building.setName(rs.getString(1));
					building.setFloorArea(rs.getInt(2));
					building.setDistrictId(rs.getInt(3));
					building.setWard(rs.getString(4));
					building.setStreet(rs.getString(5));
					building.setNumberOfBasement(rs.getInt(6));
					building.setRentPrice(rs.getInt(7));
					building.setManagerName(rs.getString(8));
					building.setManagerPhoneNumber(rs.getString(9));
					building.setServiceFee(rs.getString(10));
					building.setBrokerAgeFee(rs.getDouble(11));
					building.setId(rs.getInt(12));
					listBuldings.add(building);
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.getStackTrace();
			}
		return listBuldings;
	}
	
}
