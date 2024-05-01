package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ObjectDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    protected void closeConnection() {
    	try {
            if (conn != null) conn.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    protected ResultSet runQuery(String sql) {
    	ResultSet rs = null;
    	try {
    		conn = DataConnection.connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
    
    protected ResultSet runQuery2(String sql, Object...objects) {
    	ResultSet rs = null;
    	try {
    		conn = DataConnection.connect();
			pstmt = conn.prepareStatement(sql);
			int index = 1;
    	    for (Object object : objects) {
    	    	 if (object instanceof java.util.Date) {
    	    		 pstmt.setDate(index, new java.sql.Date(((java.util.Date) object).getTime()));
    	    	 } else {
    	    		 pstmt.setObject(index, object);
    	    	 }
    	    	 index++;
    	    }
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return rs;
    }
    
    protected int runUpdate(String sql, Object...objects) {
    	int numOfEffectedRow = -1;
    	try {
    		conn = DataConnection.connect();
    		pstmt = conn.prepareStatement(sql);
    		int index = 1;
    	    for (Object object : objects) {
    	    	 if (object instanceof java.util.Date) {
    	    		 pstmt.setDate(index, new java.sql.Date(((java.util.Date) object).getTime()));
    	    	 } else {
    	    		 pstmt.setObject(index, object);
    	    	 }
    	    	 index++;
    	    }
    	    numOfEffectedRow = pstmt.executeUpdate();
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return numOfEffectedRow;
    }
    
    public static int getLastIndex() {
    	int lastId = -1;
    	try {
    		Connection c = DataConnection.connect();
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT LAST_INSERT_ID()");
			r.next();
			lastId = r.getInt(1);
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return lastId;
    } 
    
}
