package com.mvc.airlines.TickerManagementSystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FlightRowMapper implements RowMapper<FlightModel>{
	@Override
	public FlightModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		FlightModel e = new FlightModel();
		e.setFlight_id(rs.getInt(1));
		e.setAirline_id(rs.getInt(2));
		e.setAirline_name(rs.getString(3));
		e.setFrom_location(rs.getString(4));
		e.setTo_location(rs.getString(5));
		e.setDeparture_time(rs.getString(6));
		e.setArrival_time(rs.getString(7));
		e.setDuration(rs.getString(8));
		e.setTotal_seats(rs.getInt(9));
		
		return e;
	}


}
