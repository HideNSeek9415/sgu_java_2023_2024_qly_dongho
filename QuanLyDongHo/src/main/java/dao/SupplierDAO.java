package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Product;
import dto.Supplier;


public class SupplierDAO extends ObjectDAO implements ICrud<Supplier> {
	
	public static SupplierDAO getInstance() {
		return new SupplierDAO();
	}

	@Override
	public boolean create(Supplier Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier readByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Supplier> readAllData() {
		ArrayList<Supplier> suppliers = new ArrayList<>();
		String query = "SELECT * FROM suppliers";
		try {
			ResultSet rs = runQuery(query);
			while (rs.next()) {
	        	Supplier supplier = new Supplier(
					rs.getInt("supplier_id"),
					rs.getString("supplier_name"),
					rs.getString("email"),
                    rs.getString("supplier_status"),
					rs.getString("phone_number")
	        	);
	        	suppliers.add(supplier);
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suppliers;
	}

	@Override
	public boolean update(int ID, Supplier Obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<Product> getProvidablePrds(int id) {
		return null;
	}
	
	public Boolean addNewProvidablePrd(int PrdId, int SupplierId) {
		return false;
	}
	
	public Boolean removeProvidablePrd(int PrdId, int SupplierId) {
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
