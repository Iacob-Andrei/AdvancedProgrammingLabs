package com.lab11.laborator11;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://ip-database.ccrihfbatmnt.eu-central-1.rds.amazonaws.com:3306/javaDatabase";
    private static final String username = "admin";
    private static final String password = "6kT4Yi1S7AtqErWTxZyD";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {
        return connection;
    }

    public static void createConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Could not close the database connection!", e);
        }
    }
}
