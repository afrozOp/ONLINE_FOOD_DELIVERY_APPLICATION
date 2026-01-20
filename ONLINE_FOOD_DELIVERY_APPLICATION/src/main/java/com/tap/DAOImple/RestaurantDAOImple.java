package com.tap.DAOImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.Model.Restaurant;

import com.tap.utilty.DBConnection;

public class RestaurantDAOImple implements RestaurantDAO {

	private static final String INSERT_RESTAURANT = "INSERT INTO `RESTAURANT` (restaurantId,name,adminId,address,"
			+ "cuisineType,rating,ETA,imageURL,isAvailable)"
			+ "values(?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_RESTAURANT = "SELECT * from `RESTAURANT` Where `restaurantId` =? ";
	private static final String DELETE_RESTAURANT = "DELETE From `RESTAURANT` Where `restaurantId` =? ";
	private static final String SELECT_ALL_RESTAURANT = "SELECT * FROM RESTAURANT";
	private static final String UPDATE_RESTAURANT = "UPDATE `RESTAURANT` SET name= ?, address= ? "
			+ "Where restaurantId= ? ";
	


	@Override
	public int addRestaurant(Restaurant restaurant) 
	{
		int res=0;

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(INSERT_RESTAURANT);

			pptmt.setInt	(1,restaurant.getRestaurantId());
			pptmt.setString(2, restaurant.getName());
			pptmt.setInt(3,restaurant.getAdminId());
			pptmt.setString(4, restaurant.getAddress());
			pptmt.setString(5, restaurant.getCuisineType());
			pptmt.setDouble(6, restaurant.getRating());
			pptmt.setInt(7,restaurant.getETA());
			pptmt.setString(8, restaurant.getImageURL());
			pptmt.setString(9, restaurant.isAvailable());

			res = pptmt.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();
		}



		return res;
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Connection connection = DBConnection.getConnection();

		Restaurant restaurant=null;

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_RESTAURANT);

			pptmt.setInt(1, restaurantId);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{

				int restaurantID = res.getInt("restaurantId");
				String name = res.getString("name");
				int adminId = res.getInt("adminId");
				String address = res.getString("address");
				String cuisineType = res.getString("cuisineType");
				double rating = res.getDouble("rating");
				int eta = res.getInt("ETA");
				String imageURL = res.getString("imageURL");
				String isAvailable = res.getString("isAvailable");

				restaurant = new Restaurant(restaurantID,name,adminId,address,cuisineType,rating,eta,imageURL,isAvailable);

			}




		} catch (SQLException e) {

			e.printStackTrace();
		}





		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		
	
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement pptmt = connection.prepareStatement(UPDATE_RESTAURANT);
			
			pptmt.setString(1, restaurant.getName());
			
			pptmt.setString(2, restaurant.getAddress());
			
			pptmt.setInt(3, restaurant.getRestaurantId());
			
			int res = pptmt.executeUpdate();
			
			System.out.println(res);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		
	Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement pptmt = connection.prepareStatement(DELETE_RESTAURANT);
			
			
			pptmt.setInt(1, restaurantId);
			
			int res = pptmt.executeUpdate();
			
			System.out.println(res);
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		
		List<Restaurant> ar2 = new ArrayList<Restaurant>();
		
		
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_RESTAURANT);
				ResultSet res = pptmt.executeQuery();) {
			
			
		
			while(res.next())
			{
				int restaurantID = res.getInt("restaurantId");
				String name = res.getString("name");
				int adminId = res.getInt("adminId");
				String address = res.getString("address");
				String cuisineType = res.getString("cuisineType");
				double rating = res.getDouble("rating");
				int eta = res.getInt("ETA");
				String imageURL = res.getString("imageURL");
				String isAvailable = res.getString("isAvailable");
				

			
				Restaurant	restaurant = new Restaurant(restaurantID,name,adminId,address,cuisineType,rating,eta,imageURL,isAvailable);

				
				ar2.add(restaurant);
			
			
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		

	
	
		return ar2;
	}


}

