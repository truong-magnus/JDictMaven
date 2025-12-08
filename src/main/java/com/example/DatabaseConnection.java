package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 1. Database Configuration
    // Format: "jdbc:mysql://hostname:port/database_name"
    private static final String URL = "jdbc:mysql://localhost:3306/jdict_db";
    private static final String USER = "root";

    // IMPORTANT: If you set a password for MySQL, enter it inside the quotes below.
    // If you didn't set a password (default), leave it empty "".
    private static final String PASSWORD = "";

    // 2. Method to get a connection object
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Attempt to establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("=> SUCCESS: Connection established to MySQL database!");
        } catch (SQLException e) {
            System.err.println("=> ERROR: Failed to connect to database!");
            System.err.println("   Reason: " + e.getMessage());
            // e.printStackTrace(); // Uncomment this if you need detailed error logs
        }
        return conn;
    }

    // 3. com.example.Main method for quick testing (Unit Test)
    public static void main(String[] args) {
        // Run this file directly to check if the connection works
        getConnection();
    }
}