package com.example.registration;

import java.sql.*;

public class UserDAO {
    // Updated connection URL with security parameters
    private static final String URL = "jdbc:mysql://localhost:3306/user_registration?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, email, password, full_name) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getFullName());

            return stmt.executeUpdate() > 0;
        }
    }
}