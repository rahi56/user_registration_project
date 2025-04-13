package com.example.registration;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");

        User user = new User(username, email, password, fullName);
        UserDAO userDAO = new UserDAO();

        try {
            if (userDAO.registerUser(user)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Registration failed - User might already exist");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Registration error: " + e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
}