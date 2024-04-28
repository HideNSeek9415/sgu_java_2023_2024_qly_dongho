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
	public boolean create(Product Obj) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO products (product_name, category, brand, sell_price, discount, discount_price, quantity, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		int affectedRowCount = runUpdate(sql,
			Obj.getProductName(),
			Obj.getCategory(),
			Obj.getBrand(),
			Obj.getSellPrice(),
			Obj.isDiscount(),
			Obj.getDiscountPrice(),
			Obj.getQuantity(),
			Obj.getImageUrl()
		);
		closeConnection();
		return affectedRowCount > 0;
	}

	@Override
	public Product readByID(int ID) {
		Product product = null;
		String query = "SELECT * FROM products where id = ?";
		try {
			ResultSet rs = runQuery2(query, ID);
			if (rs.next()) {
	        	product = new Product(
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
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
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
	public boolean update(int ID, Product Obj) {
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
