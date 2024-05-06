package dao;

import java.util.ArrayList;

import dto.Employee;
import dto.Warranty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WarrantyDAO extends ObjectDAO implements ICrud<Warranty> {
	private PreparedStatement prest = null;
        private Connection conn = null;
        
	public static WarrantyDAO getInstance() {
		return new WarrantyDAO();
	}

	@Override
	public boolean create(Warranty Obj) {
            boolean flag = true;
                try{
		String sql = "insert into warranty (detail_id, reason) values (?, ?)";		
		int affectedRow = runUpdate(sql,
			Obj.getDetailId(),
			Obj.getReason()
		);
                closeConnection();
		if(affectedRow > 0) return true;
	}
              catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
                return false;
	}
	
	public ArrayList<Warranty> readAllData() {
		// TODO Auto-generated method stub
		ArrayList<Warranty> warranties = new ArrayList<>();
		try {
			String sql = String.format("select * from warranty");
			ResultSet rs = runQuery(sql);
			while (rs.next()) {
				Warranty warranty = new Warranty(
					rs.getInt("warranty_id"),
					rs.getInt("detail_id"),
					rs.getString("reason"),
					rs.getString("status")					
				);
				warranties.add(warranty);
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return warranties;
	}
	
	public boolean updateStatus(int id) {
        try (Connection conn = DataConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "UPDATE warranty SET status = ? WHERE detail_id = ?")) {

            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, "accepted");
            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public Warranty readByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(int ID, Warranty Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recovery(int id) {
		// TODO Auto-generated method stub
		return false;
	}
        
}
