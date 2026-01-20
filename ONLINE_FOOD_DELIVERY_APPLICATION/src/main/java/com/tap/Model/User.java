package com.tap.Model;

import java.sql.Timestamp;

public class User {
	
	
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String address;
	private String phoneNumber;
	private String role;
	private Timestamp lastLoginDate;
	private Timestamp createdDate;
	
	public User() {
		
	}

	
	public User( int userId,String userName, String password, String email, String address, String phoneNumber,
			String role, Timestamp lastLoginDate, Timestamp createdDate) {
		
		this.userId=userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.lastLoginDate = lastLoginDate;
		this.createdDate = createdDate;
	}
	
	


	public User(String userName, String password, String email, String address, String phoneNumber, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}




	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", role=" + role + ", lastLoginDate="
				+ lastLoginDate + ", createdDate=" + createdDate + "]";
	}
	
	
	
	
	
	
	

}



