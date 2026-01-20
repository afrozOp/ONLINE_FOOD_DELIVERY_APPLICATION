package com.tap.utilty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Afroz@786";
	

	public static Connection getConnection() {
		
	  Connection connection=null;
		
	//1. Load the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	return connection;
		
	
	

}




}
