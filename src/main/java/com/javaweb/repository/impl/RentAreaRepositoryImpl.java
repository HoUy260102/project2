package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.Utils.ConnectionJDBCUtil;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.RentAreaEntity;
@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{
	@Override
	public List<RentAreaEntity> getValueById(Long id) {
		String sql = "select value from rentarea where buildingid = "+id;
		List<RentAreaEntity> listRentArea = new ArrayList<RentAreaEntity>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) {
			while (rs.next()) {
				RentAreaEntity rentArea = new RentAreaEntity(rs.getLong("value"));
				listRentArea.add(rentArea);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return listRentArea;
	}
}
