package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectDatabase {
    
    static Connection conn;
    static PreparedStatement pst;
    
    public static void main(String[] args) {
        conn = ConnectXamppMySQL.conn();
       
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Connected to database successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to connect to database.");
            return; 
        }
        
    
    }
}
