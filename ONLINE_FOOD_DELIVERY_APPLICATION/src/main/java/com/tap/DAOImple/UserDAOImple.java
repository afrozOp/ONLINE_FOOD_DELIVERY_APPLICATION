package com.tap.DAOImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.Model.User;
import com.tap.utilty.DBConnection;

public class UserDAOImple implements UserDAO{
	
	private static final String INSERT_USER = "INSERT into `USER` (username,password,email,address,phoneNumber,role,lastLoginDate,createdDate)"+	
			"values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER = "SELECT * from `USER` Where `userId` =? ";
	private static final String DELETE_USER = "DELETE From `USER` Where `userId` =? ";
	private static final String SELECT_ALL_USER = "SELECT * FROM USER";
	private static final String UPDATE_USER = "UPDATE `USER` SET username= ?, password= ?, email= ?, address= ?, phoneNumber= ? "
			+ "Where userId= ? ";
	



	@Override
	public int addUser(User user) {

		Connection connection = DBConnection.getConnection();

		int res = 0;


		try {
			PreparedStatement pptmt = connection.prepareStatement(INSERT_USER);
			

			pptmt.setString(1,user.getUserName());
			pptmt.setString(2,user.getPassword());
			pptmt.setString(3,user.getEmail());
			pptmt.setString(4,user.getAddress());
			pptmt.setString(5, user.getPhoneNumber());
			pptmt.setString(6,user.getRole());
			pptmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			pptmt.setTimestamp(8,new Timestamp(System.currentTimeMillis()));


			res = pptmt.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();

		}


		return res;
	}
	@Override
	public User getUser(int userId) {

		Connection connection = DBConnection.getConnection();

		User user=null;

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_USER);
			
			pptmt.setInt(1, userId);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int userID = res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phoneNumber=res.getString("phoneNumber");
				String role=res.getString("role");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");

				user= new User(userID,userName,password,email,address,phoneNumber,role, createdDate,lastLoginDate);


			}

			


		} catch (SQLException e) {

			e.printStackTrace();
		}




		return user;
	}

	@Override
	public void updateUser(User user) {
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement pptmt = connection.prepareStatement(UPDATE_USER);
			
			pptmt.setString(1, user.getUserName());
			pptmt.setString(2, user.getPassword());
			pptmt.setString(3,user.getEmail());
			pptmt.setString(4, user.getAddress());
			pptmt.setString(5, user.getPhoneNumber());
			pptmt.setInt(6, user.getUserId());
			
			int res = pptmt.executeUpdate();
			
			System.out.println(res);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void deleteUser(int userId) {
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement pptmt = connection.prepareStatement(DELETE_USER);
			
			
			pptmt.setInt(1, userId);
			
			int res = pptmt.executeUpdate();
			
			System.out.println(res);
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> arl = new ArrayList<User>();
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_USER);
			
			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int userID = res.getInt("userId");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String phoneNumber=res.getString("phoneNumber");
				String role=res.getString("role");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");

				User user= new User(userID,userName,password,email,address,phoneNumber,role, createdDate,lastLoginDate);

				
				arl.add(user);
			
			
			
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		

		return arl;
	}
	
	
	public User login(String email, String password) {

	    User user = null;
	    String sql = "SELECT * FROM user WHERE email=? AND password=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setUserId(rs.getInt("userId"));
	            user.setUserName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user; // null OR valid user
	}

	
	
	public boolean registerUser(User user) {

	    boolean status = false;

	    try {
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "INSERT INTO user(name,email,password,phone) VALUES(?,?,?,?)"
	        );

	        ps.setString(1, user.getUserName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassword());
	        ps.setString(4, user.getPhoneNumber());

	        status = ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}


}
