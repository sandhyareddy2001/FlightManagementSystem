package com.mvc.airlines.TickerManagementSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.airlines.TickerManagementSystem.model.FlightModel;
import com.mvc.airlines.TickerManagementSystem.model.FlightRowMapper;
import com.mvc.airlines.TickerManagementSystem.model1.PassengerModel;
import com.mvc.airlines.TickerManagementSystem.model1.PassengerRowMapper;
import com.mvc.airlines.TickerManagementSystem.model2.UserModel;
import com.mvc.airlines.TickerManagementSystem.model2.UserRowMapper;

@Controller
public class HomeController {
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value="/flightDetailsFT")
	public ModelAndView notAllFlights(HttpServletResponse response) throws IOException{
		return new ModelAndView("notAllFlights");
	}
	@RequestMapping(value="/TFSearch")
	public ModelAndView TFallFlights(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		String sql="select * from flightDetails";
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		List<FlightModel>eu= template.query(sql, new FlightRowMapper());
		List<FlightModel>r= new ArrayList();
		for (FlightModel f : eu) {
			if (f.getFrom_location().equals(from) && f.getTo_location().equals(to)){
				r.add(f);
			}
		}
		
		
		return new ModelAndView("/flight","flightDetails",r);
		
	}
	
	@RequestMapping(value="/flightDetails")
	public ModelAndView allFlights(HttpServletResponse response) throws IOException{
		
		String sql="select * from flightDetails";
		List<FlightModel> f= template.query(sql,new FlightRowMapper());
		return new ModelAndView("/flight","flightDetails",f);
		
	}
	
	@RequestMapping(value="/userDetails")
	public ModelAndView allUsers(HttpServletResponse response) throws IOException{
		
		String sql="select * from userTable";
		List<UserModel> p= template.query(sql,new UserRowMapper());
		return new ModelAndView("/show","users",p);
		
	}
	
	@RequestMapping(value="/passengerDetails")
	public ModelAndView allPassengers(HttpServletResponse response) throws IOException{
		
		String sql="select * from passengerTable";
		List<PassengerModel> p= template.query(sql,new PassengerRowMapper());
		return new ModelAndView("/showPassengers","passengers",p);
		
	}
	
	
	@RequestMapping(value="/validate")
	public ModelAndView validate(HttpServletResponse response, HttpServletRequest request) throws IOException{

	boolean isFound= false;
	boolean isAdmin= false;
	
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	
	String sql="select * from userTable";
	List<UserModel>eu= template.query(sql, new UserRowMapper());
	
	for (UserModel u : eu) {
		if (fname.equals(u.getFirst_name()) && lname.equals(u.getLast_name())) {
			isFound = true;
			if (u.getRole().equals("admin"))
				isAdmin=true;
			
			break;
		}
	}
	if (isFound) {
		if (isAdmin)
			return new ModelAndView("admin");
		else
			return new ModelAndView("passenger");
	}
	else
		return new ModelAndView("register");
	}
	
	@RequestMapping(value="/passengerReg")
	public ModelAndView regPass(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		String uid = request.getParameter("uid");
		int id= Integer.parseInt(uid);
		String fname = request.getParameter("fname");
		String lname= request.getParameter("lname");
		String addr = request.getParameter("addr");
		String mobnum = request.getParameter("mobnum");
		String emailID = request.getParameter("emailID");
		String sql="insert into userTable value(?,?,?,?)";
		template.update(sql,id,fname,lname,"passenger");

		String sql1="insert into passengerTable value(?,?,?,?,?,?)";
		template.update(sql1,id,fname,lname,addr,mobnum,emailID);
		return new ModelAndView("home");
		
	}
	@RequestMapping(value="/adminReg")
	public ModelAndView regAdmin(HttpServletResponse response, HttpServletRequest request) throws IOException{
		String uid= request.getParameter("uid");
		int id= Integer.parseInt(uid);
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String sql="insert into userTable value(?,?,?,?)";
		template.update(sql,id,fname,lname,"admin");
		return new ModelAndView("home");
		
	}
	

	@RequestMapping(value="/PF")
	public ModelAndView delStu(HttpServletResponse response) throws IOException{
	return new ModelAndView("/delPass");
	
	}
	
	@RequestMapping(value="/AF")
	public ModelAndView delStuffu(HttpServletResponse response) throws IOException{
	return new ModelAndView("/delAirline");
	
	}
	
	
	
	@RequestMapping(value="/delStuff")
	public ModelAndView delStuff(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		String key = request.getParameter("key");
		String tOra = request.getParameter("Keyword");
		List<FlightModel>p;
		if (tOra.equals("flight_id")) {
			String sql=" select * from flightDetails where flight_id=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where flight_id=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
		}
		else if (tOra.equals("airline_id")) {
			String sql=" select * from flightDetails where airline_id=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where airline_id=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("airline_name")) {
			String sql=" select * from flightDetails where airline_name=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where airline_name=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("from_location")) {
			String sql=" select * from flightDetails where from_location=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where from_location=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("to_location")) {
			String sql=" select * from flightDetails where to_location=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where to_location=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("departure_time")) {
			String sql=" select * from flightDetails where departure_time=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where departure_time=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("arrival_time")) {
			String sql=" select * from flightDetails where arrival_time=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where arrival_time=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("duration")) {
			String sql=" select * from flightDetails where duration=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where duration=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		else if (tOra.equals("total_seats")) {
			String sql=" select * from flightDetails where total_seats=?";
			p= template.query(sql,new FlightRowMapper(),key);
			String s="delete from flightDetails where total_seats=?";
			template.update(s,key);
			return new ModelAndView("flight","flightDetails",p);
	
		}
		
		return null;
	}
	
	
	
	
	@RequestMapping(value="/delPass")
	public ModelAndView delPass(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		String key = request.getParameter("key");
		String tOra = request.getParameter("Keyword");
		List<PassengerModel>p;
		
		
		if (tOra.equals("pid")) {
			String sql=" select * from passengerTable where pid=?";
			p= template.query(sql,new PassengerRowMapper(),key);
			String s="delete from passengerTable where pid=?";
			template.update(s,key);
			String s1="delete from userTable where uid=?";
			template.update(s1,key);
			return new ModelAndView("showPassengers","passengers",p);
		}
		else if (tOra.equals("first_name")) {
			String sql=" select * from passengerTable where first_name=?";
			p= template.query(sql,new PassengerRowMapper(),key);
			String s="delete from passengerTable where first_name=?";
			template.update(s,key);
			String s1="delete from userTable where first_name=?";
			template.update(s1,key);
			return new ModelAndView("showPassengers","passengers",p);
		}
		else if (tOra.equals("address")) {

			String sql=" select * from passengerTable where address=?";
			p= template.query(sql,new PassengerRowMapper(),key);
			String s="delete from passengerTable where address=?";
			template.update(s,key);
			return new ModelAndView("showPassengers","passengers",p);
		}
		else if (tOra.equals("email_id")) {

			String sql=" select * from passengerTable where email_id=?";
			p= template.query(sql,new PassengerRowMapper(),key);
			String s="delete from passengerTable where email_id=?";
			template.update(s,key);
			return new ModelAndView("showPassengers","passengers",p);
		}
		else if (tOra.equals("mobile_number")) {

			String sql=" select * from passengerTable where mobile_number=?";
			p= template.query(sql,new PassengerRowMapper(),key);
			String s="delete from passengerTable where mobile_number=?";
			template.update(s,key);
			return new ModelAndView("showPassengers","passengers",p);
		}	
		return null;
	}
	
	
	
	
	

}
