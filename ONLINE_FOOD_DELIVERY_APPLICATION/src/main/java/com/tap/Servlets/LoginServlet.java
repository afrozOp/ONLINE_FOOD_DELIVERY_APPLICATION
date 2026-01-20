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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAOImple userDAO = new UserDAOImple();
        User user = userDAO.login(email, password);

        if (user != null) {
            //  USER EXISTS → LOGIN SUCCESS
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("home1"); // servlet, NOT jsp

        } else {
            //  USER NOT FOUND → SHOW MESSAGE
            req.setAttribute("error",
                "You don’t have an account. Please register.");

            RequestDispatcher rd =
                req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }



}



