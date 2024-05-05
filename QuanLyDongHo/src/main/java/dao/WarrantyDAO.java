package dao;

import java.util.ArrayList;

import dto.Warranty;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

	@Override
	public Warranty readByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Warranty> readAllData() {
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
