package com.student.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.json.JSONObject;

@WebServlet("/GetUsernameServlet")
public class GetUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        JSONObject jsonResponse = new JSONObject();

        if (session != null && session.getAttribute("username") != null) {
            jsonResponse.put("loggedIn", true);
            jsonResponse.put("username", session.getAttribute("username").toString()); // ✅ Show Name in Dashboard
        } else {
            jsonResponse.put("loggedIn", false);
        }

        response.getWriter().write(jsonResponse.toString());
    }
}

