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
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.BuildingEntity;
@Repository
public class DistrictRepositoryImpl implements DistrictRepository{
	@Override
	public String getNameById(Integer id) {
		String sql = "select name from district where id = "+id;
		String result = null;
		try(Connection conn = ConnectionJDBCUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				) {
			while (rs.next()) {
				result = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return result;
	}
	
}
