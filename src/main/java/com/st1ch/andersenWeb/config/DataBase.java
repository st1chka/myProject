package com.st1ch.andersenWeb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String username = "postgres";
    static String password = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
    }
}
