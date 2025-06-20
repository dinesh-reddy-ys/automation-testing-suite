package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class AWSRDSConnection {

    public static void main(String[] args) {
        Properties properties = new Properties();

        // Load properties from the configuration file
        try (FileInputStream fis = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Retrieve database connection details
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        // Insert a user into the database
        String user = "dineshreddy123";
        String email = "dineshreddy@example.com";
        String pass = "12345"; // Note: hash this in a real-world scenario

        String insertQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            stmt.setString(1, user);
            stmt.setString(2, email);
            stmt.setString(3, pass);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
