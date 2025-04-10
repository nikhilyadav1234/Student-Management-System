/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
     private static final String URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";  // 🔹 Apna MySQL username yaha daalo
    private static final String PASSWORD = "Nikhil@123";  // 🔹 Apna MySQL password yaha daalo (agar hai toh)

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");  // 🔹 Ensure karo ki MySQL driver load ho raha hai
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
