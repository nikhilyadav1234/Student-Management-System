//import java.io.*;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//@WebServlet("/AdminLoginServlet")
//public class AdminLoginServlet extends HttpServlet {
//
//    private static final String ADMIN_USERNAME = "admin";
//    private static final String ADMIN_PASSWORD = "admin123";
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
//            HttpSession session = request.getSession();
//            session.setAttribute("admin", username);
//            response.sendRedirect("admin-dashboard.jsp");
//        } else {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Invalid Admin Credentials');");
//            out.println("location='index.html';");
//            out.println("</script>");
//        }
//    }
//}



package com.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@college.com") && password.equals("admin123")) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "true");

            // 🔄 Redirect after successful login
            response.sendRedirect("ViewStudents");
        } else {
            response.sendRedirect("ViewStudents?error=1");
        }
    }
}

