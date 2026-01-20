package com.tap.DAOImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.Model.Order;
import com.tap.utilty.DBConnection;

public class OrderDAOImple implements OrderDAO{

	private static final String INSERT_ORDER = "INSERT into `ORDER` (userId,restaurantId,totalAmount,orderDate,address,paymentMethod,status)"+	
			"values(?,?,?,?,?,?,?)";
	private static final String SELECT_ORDER = "SELECT * from `ORDER` Where `orderId` =? ";
	private static final String DELETE_ORDER = "DELETE From `ORDER` Where `orderId` =? ";
	private static final String SELECT_ALL_ORDER = "SELECT * FROM ORDER";

	private static final String UPDATE_ORDER = "UPDATE `ORDER` SET address= ?, status= ? "
			+ "Where orderId= ? ";



	@Override
	public int addOrder(Order order) {

		Connection connection = DBConnection.getConnection();

		int res = 0;
		int orderId=0;


		try {
			PreparedStatement pptmt = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
				

			pptmt.setInt(1,order.getUserId());
			pptmt.setInt(2,order.getRestaurantId());
			pptmt.setDouble(3,order.getTotalAmount());
			pptmt.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
			pptmt.setString(5, order.getAddress());
			pptmt.setString(6,order.getPaymentMethod());
			pptmt.setString(7,order.getStatus());


			res = pptmt.executeUpdate();
			
			ResultSet generatedKeys = pptmt.getGeneratedKeys();
			if(generatedKeys.next())
			{
				orderId =generatedKeys.getInt(1);
			}
			else
			{
				 throw new SQLException("Creating order failed");
			}


		} catch (SQLException e) {

			e.printStackTrace();

		}


		return orderId;

	}

	@Override
	public Order getOrder(int orderId) {

		Connection connection = DBConnection.getConnection();

		Order order=null;

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ORDER);

			pptmt.setInt(1, orderId);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int orderID = res.getInt("orderId");
				int userId = res.getInt("userId");
				int restaurantId = res.getInt("restaurantId");
				double totalAmount = res.getDouble("totalAmount");
				Timestamp orderDate = res.getTimestamp("orderDate");
				String address=res.getString("address");
				String paymentMethod=res.getString("paymentMethod");
				String status=res.getString("status");



				order= new Order(orderID,userId,restaurantId,totalAmount,orderDate,address,paymentMethod, status);


			}




		} catch (SQLException e) {

			e.printStackTrace();
		}




		return order;

	}


	@Override
	public void updateOrder(Order order) {

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(UPDATE_ORDER);

			pptmt.setString(1, order.getAddress());
			pptmt.setString(2, order.getStatus());

			pptmt.setInt(3, order.getOrderId());

			int res = pptmt.executeUpdate();

			System.out.println(res);






		} catch (SQLException e) {
			e.printStackTrace();
		}


	}






	@Override
	public void deleteOrder(int orderId) {
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(DELETE_ORDER);


			pptmt.setInt(1, orderId);

			int res = pptmt.executeUpdate();

			System.out.println(res);


		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

	@Override
	public List<Order> getAllOrders() {



		List<Order> arl = new ArrayList<Order>();

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_ORDER);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{

				int orderID = res.getInt("orderId");
				int userId = res.getInt("userId");
				int restaurantId = res.getInt("restaurantId");
				double totalAmount = res.getDouble("totalAmount");
				Timestamp orderDate = res.getTimestamp("orderDate");
				String address=res.getString("address");
				String paymentMethod=res.getString("paymentMethod");
				String status=res.getString("status");



				Order order= new Order(orderID,userId,restaurantId,totalAmount,orderDate,address,paymentMethod, status);



				arl.add(order);



			}



		} catch (SQLException e) {

			e.printStackTrace();
		}


		return arl;
	}



}
