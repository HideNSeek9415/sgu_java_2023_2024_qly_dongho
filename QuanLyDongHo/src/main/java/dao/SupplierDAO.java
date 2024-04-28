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
		String sql = "INSERT INTO suppliers (supplier_name, email, phone_number) VALUES (?, ?, ?)";
		int affectedRowCount = runUpdate(sql,
			Obj.getSupplierName(),
			Obj.getEmail(),
			Obj.getPhoneNumber()
		);
		closeConnection();
		return affectedRowCount > 0;
	}

	@Override
	public Supplier readByID(int ID) {
		Supplier supplier = null;
		String sql = "SELECT * FROM suppliers WHERE supplier_id = ?";
		try {
			rs = runQuery2(sql, ID);
			if (rs.next()) {
				supplier = new Supplier(
					rs.getInt("supplier_id"),
					rs.getString("supplier_name"),
					rs.getString("email"),
                    rs.getString("supplier_status"),
					rs.getString("phone_number")
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
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
		ArrayList<Product> products = new ArrayList<>();
		String query = "SELECT * FROM products as p join product_supplier as ps on ps.product_id = p.id where ps.supplier_id = ?";
		try {
			ResultSet rs = runQuery2(query, id);
			while (rs.next()) {
	        	Product product = new Product(
					rs.getInt("id"),
					rs.getString("product_name"),
					rs.getString("category"),
					rs.getString("brand"),
					rs.getDouble("sell_price"),
					rs.getBoolean("discount"),
					rs.getDouble("discount_price"),
					rs.getInt("quantity"),
					rs.getString("product_status"),
					rs.getString("image_url")
	        	);
	        	products.add(product);
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public Boolean addNewProvidablePrd(int SupplierId, int PrdId) {
		int affectedRowCount = 0;
		try {
			String sql = "INSERT INTO product_supplier (product_id, supplier_id) VALUES (?, ?)";
			affectedRowCount = runUpdate(sql, PrdId, SupplierId); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRowCount > 0;
	}
	
	public Boolean removeProvidablePrd(int SupplierId, int PrdId) {
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
