package com.tap.Servlets;


import java.io.IOException;

import com.tap.DAOImple.UserDAOImple;
import com.tap.Model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);

        UserDAOImple dao = new UserDAOImple();

        int result = dao.addUser(user);  

        if (result > 0) {

            //  LOGIN USER AFTER REGISTER
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("home1");

        } else {
            req.setAttribute("error", "Registration failed");
            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req, resp);
        }
    }



	}



