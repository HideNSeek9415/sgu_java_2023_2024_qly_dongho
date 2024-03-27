package dao;

import java.sql.*;


public class DataConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/cuahangdongho";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static Connection connectDatabase(String url, String username, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection connect() {
        return connectDatabase(URL, USERNAME, PASSWORD);
    }
}
