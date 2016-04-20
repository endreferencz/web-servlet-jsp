package com.epam.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/login"})
public class LoginPageServlet extends HttpServlet {
    private static final String ADMIN_ROLE_NAME = "admin";
    private static final long serialVersionUID = 1L;

    public LoginPageServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.isUserInRole(ADMIN_ROLE_NAME)) {
            response.sendRedirect(request.getContextPath() + "/admin/index");
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

}
