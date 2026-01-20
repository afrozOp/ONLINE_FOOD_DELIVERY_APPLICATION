package com.tap.Servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DAOImple.OrderDAOImple;
import com.tap.DAOImple.OrderItemDAOImple;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Order;
import com.tap.Model.OrderItem;
import com.tap.Model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		Cart cart =(Cart) session.getAttribute("cart");
		User user=(User)session.getAttribute("user");
		
		 int restaurantId =(Integer) session.getAttribute("oldRestaurantId");
		 
		 String address = req.getParameter("address");
		 String paymentMethod = req.getParameter("paymentMethod");
		 
		
		if(user == null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
			return ;
			
		}
		
		
		if(cart !=null && user !=null && !cart.getItems().isEmpty())
		{
			Order order = new Order();
			
			order.setUserId(user.getUserId());
			order.setRestaurantId(restaurantId);	
			order.setOrderDate(new Timestamp(System.currentTimeMillis()));
			order.setAddress(address);
			order.setPaymentMethod(paymentMethod);
			order.setStatus("pending");
			
			double totalAmount =0.0;
			
			for(CartItem item:cart.getItems().values())
			{
			totalAmount =totalAmount + item.getQuantity() * item.getPrice();
			}
			
			
			order.setTotalAmount(totalAmount);
			
			OrderDAOImple orderDAOImple = new OrderDAOImple();
			
			int orderId = orderDAOImple.addOrder(order);
			
			for(CartItem item:cart.getItems().values())
			{
				
				String itemName = item.getName();
				int quantity = item.getQuantity();
				double totalPrice = item.getPrice();
				
				OrderItem orderItem = new OrderItem();
				
				orderItem.setOrderId(orderId);
				orderItem.setItemName(itemName);
				orderItem.setQuantity(quantity);
				orderItem.setTotalAmount(totalAmount);
				
				OrderItemDAOImple orderItemDAOImple = new OrderItemDAOImple();
				
				orderItemDAOImple.addOrderItem(orderItem);
				
			}
			
			session.setAttribute("lastOrderId", orderId);
			
			session.removeAttribute("cart");
			session.removeAttribute("oldRestaurantId");
			
			resp.sendRedirect("orderConfirmation.jsp");
			
			
			
		}
		else
		{
			resp.sendRedirect("cart.jsp");
		}
		
		
		
		
		
	}

}
