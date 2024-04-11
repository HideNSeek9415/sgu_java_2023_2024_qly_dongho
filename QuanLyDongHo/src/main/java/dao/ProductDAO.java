package dao;


import java.sql.*;
import java.util.ArrayList;
import dto.Product;

public class ProductDAO extends ObjectDAO implements ICrud<Product> {
	
	public static ProductDAO getInstance() {
		return new ProductDAO();
	}
	
    public ProductDAO() {}

	@Override
	public String create(Product Obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product readByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> readAllData() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<>();
		String query = "SELECT * FROM products";
		try {
			ResultSet rs = runQuery(query);
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

	@Override
	public boolean update(String ID, Product Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product Obj) {
		// TODO Auto-generated method stub
		return false;
	}
}
