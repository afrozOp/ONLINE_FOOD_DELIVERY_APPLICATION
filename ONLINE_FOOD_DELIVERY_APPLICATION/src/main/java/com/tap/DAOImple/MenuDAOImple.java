package com.tap.DAOImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.Model.Menu;
import com.tap.utilty.DBConnection;
 

public class MenuDAOImple implements MenuDAO
{


	private static final String INSERT_MENU = "INSERT into `MENU` (restaurantId,itemName,description,price,rating,imagepath,type)"+	
			"values(?,?,?,?,?,?,?)";
	private static final String SELECT_MENU = "SELECT * from `MENU` Where `menuId` =? ";
	private static final String DELETE_MENU = "DELETE From `MENU` Where `menuId` =? ";
	private static final String SELECT_ALL_MENU = "SELECT * FROM MENU";
	private static final String UPDATE_MENU = "UPDATE `MENU` SET restaurantId= ?, itemName= ?, description= ?, price= ?, rating= ?, type=? "
			+ "Where menuId= ? ";
	
	private static final String SELECT_ALL_MENU_BY_RESTAURANTID = "SELECT * FROM MENU Where restaurantId= ?";



	@Override
	public int addMenu(Menu menu) {

		Connection connection = DBConnection.getConnection();

		int res = 0;


		try {
			PreparedStatement pptmt = connection.prepareStatement(INSERT_MENU);


			pptmt.setInt(1,menu.getRestaurantId());
			pptmt.setString(2,menu.getItemName());
			pptmt.setString(3,menu.getDescription());
			pptmt.setDouble(4,menu.getPrice());
			pptmt.setString(5, menu.getRating());
			pptmt.setString(6,menu.getImagepath());
			pptmt.setString(7,menu.getType());




			res = pptmt.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();

		}


		return res;


	}




	@Override
	public Menu getMenu(int menuId) {


		Connection connection = DBConnection.getConnection();

		Menu menu=null;

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_MENU);

			pptmt.setInt(1, menuId);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int menuID = res.getInt("menuId");
				int restaurantId = res.getInt("restaurantId");

				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				String rating = res.getString("rating");
				String imagepath = res.getString("imagepath");
				String type=res.getString("type");

				menu= new Menu(menuID,restaurantId,itemName,description,price,rating,imagepath,type);


			}




		} catch (SQLException e) {

			e.printStackTrace();
		}




		return menu;

	}

	@Override
	public void updateMenu(Menu menu) {

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(UPDATE_MENU);

			pptmt.setInt(1, menu.getRestaurantId());
			pptmt.setString(2, menu.getItemName());
			pptmt.setString(3,menu.getDescription());
			pptmt.setDouble(4, menu.getPrice());
			pptmt.setString(5, menu.getRating());
			pptmt.setString(6, menu.getType());
			pptmt.setInt(7, menu.getMenuId());

			int res = pptmt.executeUpdate();

			System.out.println(res);






		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void deleteMenu(int menuId) {


		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(DELETE_MENU);


			pptmt.setInt(1, menuId);

			int res = pptmt.executeUpdate();

			System.out.println(res);


		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Menu> getAllMenu() {

		List<Menu> arl = new ArrayList<Menu>();

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_MENU);
			
			
			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int menuID = res.getInt("menuId");
				int restaurantId = res.getInt("restaurantId");

				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				String rating = res.getString("rating");
				String imagepath = res.getString("imagepath");
				String type=res.getString("type");

				Menu menu= new Menu(menuID,restaurantId,itemName,description,price,rating,imagepath,type);



				arl.add(menu);



			}



		} catch (SQLException e) {

			e.printStackTrace();
		}


		return arl;

	}
	
	
	
	@Override
	public List<Menu> getAllMenuByRestaurantId(int restaurantId) {
		
		List<Menu> arl = new ArrayList<Menu>();

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_MENU_BY_RESTAURANTID);
			
			pptmt.setInt(1, restaurantId);
			

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int menuID = res.getInt("menuId");
				int restaurantIdd = res.getInt("restaurantId");

				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				String rating = res.getString("rating");
				String imagepath = res.getString("imagepath");
				String type=res.getString("type");

				Menu menu= new Menu(menuID,restaurantIdd,itemName,description,price,rating,imagepath,type);



				arl.add(menu);



			}



		} catch (SQLException e) {

			e.printStackTrace();
		}


		return arl;
		
	}

}
