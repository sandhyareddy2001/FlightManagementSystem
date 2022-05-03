package com.mvc.airlines.TickerManagementSystem.model2;

public class UserModel {
	
	int uid;
	String first_name;
	String last_name;
	String role;
	public UserModel() {}
	public UserModel(int uid, String first_name, String last_name, String role) {
		super();
		this.uid = uid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
