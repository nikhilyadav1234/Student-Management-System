package com.student.servlet;

import com.student.util.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import org.json.JSONObject;

@WebServlet("/GetLoggedInStudentServlet")
public class GetLoggedInStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");

        if (email == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.print("{\"error\": \"User not logged in\"}");
            return;
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JSONObject studentJson = new JSONObject();
                studentJson.put("id", rs.getInt("id"));
                studentJson.put("name", rs.getString("name"));
                studentJson.put("email", rs.getString("email"));
                studentJson.put("course", rs.getString("course"));
                studentJson.put("branch", rs.getString("branch"));

                out.print(studentJson.toString());
            } else {
                out.print("{\"error\": \"Student not found\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"error\": \"Database error\"}");
        }
    }
}
