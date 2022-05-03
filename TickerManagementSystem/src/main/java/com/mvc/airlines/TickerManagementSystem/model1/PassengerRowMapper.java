package com.mvc.airlines.TickerManagementSystem.model1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PassengerRowMapper  implements RowMapper<PassengerModel>{
	@Override
	public PassengerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PassengerModel e = new PassengerModel();
		e.setPid(rs.getInt(1));
		e.setFirst_name(rs.getString(2));
		e.setLast_name(rs.getString(3));
		e.setAddress(rs.getString(4));
		e.setMobile_number(rs.getString(5));
		e.setEmail_id(rs.getString(6));
		
		return e;
	}

}
