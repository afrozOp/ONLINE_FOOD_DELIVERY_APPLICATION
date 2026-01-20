package com.tap.DAOImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.Model.OrderItem;

import com.tap.utilty.DBConnection;

public class OrderItemDAOImple implements OrderItemDAO {


	private static final String INSERT_ORDERITEM = "INSERT into `ORDERITEM` (orderId,itemName,quantity,totalAmount)"+	
			"values(?,?,?,?)";
	private static final String SELECT_ORDERITEM = "SELECT * from `ORDERITEM` Where `orderItemId` =? ";
	private static final String DELETE_ORDERITEM = "DELETE From `ORDERITEM` Where `orderItemId` =? ";
	private static final String SELECT_ALL_ORDERITEM = "SELECT * FROM ORDERITEM";

	private static final String UPDATE_ORDERITEM = "UPDATE `ORDERITEM` SET itemName= ?, quatity= ?, totalAmount= ? "
			+ "Where orderItemId= ? ";










	@Override
	public int addOrderItem(OrderItem orderItem) {

		Connection connection = DBConnection.getConnection();

		int res = 0;


		try {
			PreparedStatement pptmt = connection.prepareStatement(INSERT_ORDERITEM);


			pptmt.setInt(1,orderItem.getOrderId());
			pptmt.setString(2,orderItem.getItemName());
			pptmt.setInt(3,orderItem.getQuantity());
			pptmt.setDouble(4,orderItem.getTotalAmount());

			res = pptmt.executeUpdate();


		} catch (SQLException e) {

			e.printStackTrace();

		}


		return res;
	}





	@Override
	public OrderItem getOrderItem(int orderItemId) {
		Connection connection = DBConnection.getConnection();

		OrderItem orderItem=null;

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ORDERITEM);

			pptmt.setInt(1, orderItemId);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int orderItemID = res.getInt("orderItemId");
				int orderId = res.getInt("orderId");
				String itemName = res.getString("itemName");
				int quantity = res.getInt("quantity");
				double totalAmount = res.getDouble("totalAmount");


				orderItem= new OrderItem(orderItemID,orderId,itemName,quantity,totalAmount);


			}




		} catch (SQLException e) {

			e.printStackTrace();
		}




		return orderItem;



	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(UPDATE_ORDERITEM);

			pptmt.setString(1, orderItem.getItemName());
			pptmt.setInt(2, orderItem.getQuantity());
			pptmt.setDouble(3,orderItem.getTotalAmount());
			
			pptmt.setInt(4, orderItem.getOrderItemId());

			int res = pptmt.executeUpdate();

			System.out.println(res);






		} catch (SQLException e) {
			e.printStackTrace();
		}



	}





	@Override
	public void deleteOrderItem(int orderItemId) {


		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(DELETE_ORDERITEM);


			pptmt.setInt(1, orderItemId);

			int res = pptmt.executeUpdate();

			System.out.println(res);


		} catch (SQLException e) {

			e.printStackTrace();
		}



	}

	@Override
	public List<OrderItem> getAllOrderItems() {

		List<OrderItem> arl = new ArrayList<OrderItem>();

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement pptmt = connection.prepareStatement(SELECT_ALL_ORDERITEM);

			ResultSet res = pptmt.executeQuery();

			while(res.next())
			{
				int orderItemID = res.getInt("orderItemId");
				int orderId = res.getInt("orderId");
				String itemName = res.getString("itemName");
				int quantity = res.getInt("quantity");
				double totalAmount = res.getDouble("totalAmount");


				OrderItem orderItem= new OrderItem(orderItemID,orderId,itemName,quantity,totalAmount);



				arl.add(orderItem);



			}



		} catch (SQLException e) {

			e.printStackTrace();
		}


		return arl;

	}

}
