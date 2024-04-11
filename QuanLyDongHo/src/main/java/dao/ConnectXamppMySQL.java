package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectXamppMySQL {
    public static Connection conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/cuahangdongho";
            String username = "admin";
            String password ="1234";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }catch(ClassNotFoundException|SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
}