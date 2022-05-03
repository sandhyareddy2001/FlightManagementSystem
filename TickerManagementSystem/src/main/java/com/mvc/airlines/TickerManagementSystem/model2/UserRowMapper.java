package com.mvc.airlines.TickerManagementSystem.model2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel e = new UserModel();
		
		e.setUid(rs.getInt(1));
		e.setFirst_name(rs.getString(2));
		e.setLast_name(rs.getString(3));
		e.setRole(rs.getString(4));
		return e;
	}

}
