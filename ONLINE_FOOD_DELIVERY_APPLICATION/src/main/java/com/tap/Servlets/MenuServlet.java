package com.tap.Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImple.MenuDAOImple;
import com.tap.Model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MenuDAOImple menuDAOImple = new MenuDAOImple();
		
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));

		List<Menu> allMenuByRestaurantId = menuDAOImple.getAllMenuByRestaurantId(restaurantId);


		for(Menu menu:allMenuByRestaurantId)
		{ 
			System.out.println(menu);
		}
		
		req.setAttribute("allMenuByRestaurantId", allMenuByRestaurantId);
			
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("menu.jsp");
		
		requestDispatcher.forward(req, resp);


	}

}
