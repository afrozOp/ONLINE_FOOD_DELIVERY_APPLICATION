package com.tap.Servlets;

import java.io.IOException;

import com.tap.DAOImple.MenuDAOImple;
import com.tap.Model.Cart;
import com.tap.Model.CartItem;
import com.tap.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet
{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		Cart cart = (Cart)session.getAttribute("cart");
		Integer oldRestaurantId =(Integer) session.getAttribute("oldRestaurantId");

		int restaurantId =Integer.parseInt(req.getParameter("restaurantId")); 

		if (cart == null || oldRestaurantId!=restaurantId) {
		    cart = new Cart();
		    session.setAttribute("cart", cart);
		    session.setAttribute("oldRestaurantId", restaurantId);
		}

		
		String action = req.getParameter("action");

		
		if (action.equals("add")) {
		    addItemToCart(req, cart);
		}
		else if (action.equals("update")) {
		    updateItemOfCart(req, cart);
		}
		else if (action.equals("remove")) {
		    deleteItemFromCart(req, cart);
		}



		
		resp.sendRedirect("cart.jsp");
		
	

	}
	
	




	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		cart.removeItem(itemId);

	}

	private void updateItemOfCart(HttpServletRequest req, Cart cart) {
		
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		
		cart.updateItem(itemId, quantity);

	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {

		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		MenuDAOImple menuDAOImple = new MenuDAOImple();

		Menu menu = menuDAOImple.getMenu(itemId);

		String itemName = menu.getItemName();
		double itemPrice =menu.getPrice();


		CartItem cartItem = new CartItem(itemId,itemName,quantity,itemPrice);

		cart.addItem(cartItem);



	}




}
