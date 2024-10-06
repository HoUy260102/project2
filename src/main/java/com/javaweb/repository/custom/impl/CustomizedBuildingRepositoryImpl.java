package com.javaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.Utils.NumberUtil;
import com.javaweb.Utils.StringUtil;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.custom.CustomizedBuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class CustomizedBuildingRepositoryImpl implements CustomizedBuildingRepository{
	public void joinQuery(BuildingSearchBuilder param, StringBuilder joinSql) {
		if (param.getDistrictId()!=null) {
			joinSql.append(" join district d on b.districtid=d.id\r\n");
		}
		if (param.getStaffId()!=null) {
			joinSql.append(" join assignmentbuilding ab on ab.buildingid=b.id\r\n"
					+ " join user u on ab.staffid=u.id\r\n");
		}
		if (param.getRentAreaFrom()!=null||param.getRentAreaTo()!=null) {
			joinSql.append(" join rentarea r on r.buildingid=b.id\r\n");
		}
		if (param.getRentType()!=null&&param.getRentType().size()!=0){
			joinSql.append(" join buildingrenttype br on br.buildingid=b.id\r\n"
			 		+ " join renttype rt on rt.id=br.renttypeid\r\n");
		}
	}
	public void queryNormal(BuildingSearchBuilder param, StringBuilder conditionQuery) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if (!fieldName.equals("staffId")&&!fieldName.equals("rentType")&&!fieldName.startsWith("rentArea")&&!fieldName.startsWith("rentPrice")) {
					String value = item.get(param).toString();
					if (StringUtil.checkString(value)) {
						if (NumberUtil.checkNumber(value)) {
							conditionQuery.append(" and b."+fieldName+"="+value);
						}
						else {
							conditionQuery.append(" and b."+fieldName+" like '%"+value+"%'");
						}
					}
				} 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		for (Map.Entry<String, Object> it : param.entrySet()) {
//			if (!it.getKey().equals("staffId")&&!it.getKey().equals("rentType")&&!it.getKey().startsWith("rentArea")&&!it.getKey().startsWith("rentPrice")) {
//				String value = it.getValue().toString();
//				if (StringUtil.checkString(value)) {
//					if (NumberUtil.checkNumber(value)) {
//						conditionQuery.append(" and b."+it.getKey()+"="+value);
//					}
//					else {
//						conditionQuery.append(" and b."+it.getKey()+" like '%"+value+"%'");
//					}
//				}
//			}
//		}
	}
	public void querySpecial(BuildingSearchBuilder param, StringBuilder conditionQuery) {
		String staffId = param.getStaffId()==null?null:param.getStaffId().toString();
		if (StringUtil.checkString(staffId)) {
			conditionQuery.append(" and u.id = "+staffId); 
		}
		String rentAreaFrom = param.getRentAreaFrom()==null?null:param.getRentAreaFrom().toString();
		String rentAreaTo = param.getRentAreaTo()==null?null:param.getRentAreaTo().toString();
		String rentPriceFrom = param.getRentPriceFrom()==null?null:param.getRentPriceFrom().toString();
		String rentPriceTo = param.getRentPriceTo()==null?null:param.getRentPriceTo().toString();
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
		List<String> rentType = param.getRentType();		
		if (rentType!=null&&rentType.size()!=0) {
			rentTypes = rentType.stream().map(item -> "'"+item+"'").collect(Collectors.joining(","));
			conditionQuery.append(" and rt.code in ("+rentTypes+")");
		}
	}
//	@Override
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
				building.setNumberOfBasement(rs.getLong("numberofbasement"));
				list.add(building);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return list;
	}
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> find(BuildingSearchBuilder buildingSearchBuilder) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("select b.name, b.floorarea, b.districtid, b.ward, b.street, b.numberofbasement, b.rentprice, b.managername, b.managerphonenumber, b.servicefee, b.brokeragefee, b.id from building b\r\n"); 
		StringBuilder joinSql = new StringBuilder();
		joinQuery(buildingSearchBuilder, joinSql);
		StringBuilder conditionQuery = new StringBuilder();
		queryNormal(buildingSearchBuilder, conditionQuery);
		querySpecial(buildingSearchBuilder, conditionQuery);
		sql.append(joinSql);
		sql.append(" where 1=1");
		sql.append(conditionQuery);
		sql.append(" Group by b.id");
//		List<BuildingEntity> listBuldings = new ArrayList<BuildingEntity>();
		System.out.println(sql.toString());
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
//		try(Connection conn = ConnectionJDBCUtil.getConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql.toString());
//					) {
//				while (rs.next()) {
//					BuildingEntity building = new BuildingEntity();
//					building.setName(rs.getString(1));
//					building.setFloorArea(rs.getLong(2));
//					building.setWard(rs.getString(4));
//					building.setStreet(rs.getString(5));
//					building.setNumberOfBasement(rs.getLong(6));
//					building.setRentPrice(rs.getLong(7));
//					building.setManagerName(rs.getString(8));
//					building.setManagerPhoneNumber(rs.getString(9));
//					building.setServiceFee(rs.getString(10));
//					building.setBrokerAgeFee(rs.getDouble(11));
//					building.setId(rs.getLong(12));
//					listBuldings.add(building);
//				}
//			} catch (SQLException e) {
//				// TODO: handle exception
//				e.getStackTrace();
//			}
//		return listBuldings;
	}
	
}
