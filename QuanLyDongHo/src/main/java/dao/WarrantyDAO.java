package dao;

import java.util.ArrayList;

import dto.Warranty;

public class WarrantyDAO extends ObjectDAO implements ICrud<Warranty> {
	
	public static WarrantyDAO getInstance() {
		return new WarrantyDAO();
	}

	@Override
	public boolean create(Warranty Obj) {
		// TODO Auto-generated method stub
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
