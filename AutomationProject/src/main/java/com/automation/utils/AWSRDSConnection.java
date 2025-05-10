package com.automation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AWSRDSConnection {
    public static void main(String[] args) {
        // AWS RDS connection details
    	String url = "jdbc:mysql://database-automation.cxw4asaa4fwp.eu-north-1.rds.amazonaws.com:3306/database-automation";

        String username = "dineshreddy";
        String password = "IloveTechStuff";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to AWS RDS!");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                System.out.println("Column1: " + resultSet.getString("column1"));
                System.out.println("Column2: " + resultSet.getString("column2"));
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

