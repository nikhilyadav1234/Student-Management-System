/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikhil
 */
package com.student.servlet;

import com.student.util.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student List</title>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");

        // JS for live search
        out.println("<script>");
        out.println("function searchTable() {");
        out.println("  var input = document.getElementById('searchInput').value.toLowerCase();");
        out.println("  var rows = document.querySelectorAll('#studentsTable tbody tr');");
        out.println("  rows.forEach(function(row) {");
        out.println("    var text = row.innerText.toLowerCase();");
        out.println("    row.style.display = text.includes(input) ? '' : 'none';");
        out.println("  });");
        out.println("}");
//        out.println("</script>");
        
        // ✅ Proper Logout Function
        out.println("function logout() {");
        out.println("  alert('Logging out...');");
        out.println("  window.location.href = 'index.html';");  // Adjust if your login page is named differently
        out.println("}");
        out.println("</script>");
        
        

        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(to right, #1d2b64, #f8cdda); padding: 40px; display: flex; justify-content: center; }");
        out.println(".container {height:fit-content; background: rgba(255, 255, 255, 0.08); padding: 30px; border-radius: 16px; backdrop-filter: blur(10px); box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2); width: 100%; max-width: 1200px; color: #fff; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { padding: 12px; text-align: left; border-bottom: 1px solid rgba(255, 255, 255, 0.2); }");
        out.println("th { background-color: rgba(255,255,255,0.1); color: #00ffe0; }");
        out.println("td { color: #f1f1f1; }");
        out.println(".btn { font-weight: bold; border-radius: 8px; padding: 8px 14px; transition: 0.3s; }");
        out.println(".btn-primary { background: #00b894; color: white; } .btn-primary:hover { background: #019874; }");
        out.println(".btn-danger { background: #d63031; color: white; } .btn-danger:hover { background: #b71c1c; }");
        out.println(".btn-secondary { background: #636e72; color: white; } .btn-secondary:hover { background: #2d3436; }");
        out.println("#searchInput { width: 100%; padding: 10px; border-radius: 8px; border: none; margin-bottom: 15px; font-size: 16px; }");
        out.println("</style></head><body>");

        out.println("<div class='container'>");
        out.println("<h2 class='text-center mb-4'>🎓 Registered Students</h2>");
        out.println("<input type='text' id='searchInput' onkeyup='searchTable()' placeholder='🔍 Search by any field...'/>");
        out.println("<button onclick='logout()' class='btn btn-danger float-end mb-3'>🚪 Logout</button>");
        out.println("<table class='table' id='studentsTable'>");
        out.println("<thead><tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Address</th><th>Branch</th><th>Course</th><th>Password</th><th>Actions</th></tr></thead>");
        out.println("<tbody>");

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("branch") + "</td>");
                out.println("<td>" + rs.getString("course") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>");
                out.println("<a href='edit_student.jsp?id=" + rs.getInt("id") + "' class='btn btn-primary btn-sm me-1'>Edit</a>");
                out.println("<a href='DeleteStudentServlet?id=" + rs.getInt("id") + "' class='btn btn-danger btn-sm'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='9' class='text-center text-warning'>No students found.</td></tr>");
            }

            conn.close();
        } catch (Exception e) {
            out.println("<p class='text-danger'>❌ Error fetching data: " + e.getMessage() + "</p>");
        }

        out.println("</tbody></table>");
        out.println("<div class='mt-4 text-center'>");
        out.println("<a href='admin-dashboard.html' class='btn btn-secondary'>🏠 Back to Dashboard</a>");
        out.println("<a href='index.html' class='btn btn-secondary me-2'>← Back</a>");

        out.println("</div></div></body></html>");
    }
}

