package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImple.RestaurantDAOImple;
import com.tap.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/home1")
public class RestaurantServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			

		RestaurantDAOImple restaurantDAOImple = new RestaurantDAOImple();
		
		List<Restaurant> allRestaurant = restaurantDAOImple.getAllRestaurant();
		
		
		for(Restaurant restaurant: allRestaurant)
		{
			System.out.println(restaurant);
		}
		
		req.setAttribute("allRestaurant", allRestaurant);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
		
		rd.forward(req, resp);
		
	
	}
	
}
