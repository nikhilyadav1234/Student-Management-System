package com.student.servlet;

import com.student.util.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/RegisterStudentServlet")
public class RegisterStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String password = request.getParameter("password");
        
        // 🌟 New Fields
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String branch = request.getParameter("branch");

        try (Connection conn = DatabaseConnection.getConnection()) {
            // ✅ Updated SQL Query with new fields
            String sql = "INSERT INTO students (name, email, course, password, address, phone, branch) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, course);
            stmt.setString(4, password);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, branch);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                // ✅ Reset AUTO_INCREMENT if needed
                Statement resetStmt = conn.createStatement();
                resetStmt.execute("SET @max_id = 0;");
                resetStmt.execute("SELECT MAX(id) + 1 INTO @max_id FROM students;");
                resetStmt.execute("SET @sql = CONCAT('ALTER TABLE students AUTO_INCREMENT = ', @max_id);");
                resetStmt.execute("PREPARE stmt FROM @sql;");
                resetStmt.execute("EXECUTE stmt;");
                resetStmt.execute("DEALLOCATE PREPARE stmt;");

                response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("<h3 style='color:red;'>Error: Registration failed!</h3>");
            }
        } catch (SQLException e) {
            response.getWriter().println("<h3 style='color:red;'>SQL Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
