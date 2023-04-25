package org.example;

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager instance = null;
    private Connection conn = null;

    private DatabaseManager() {
        try {
            String url = "jdbc:mysql://localhost:/music_library";
            String user = "root";
            String password = null;
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
