package dao;


import java.sql.*;
import java.util.ArrayList;
import dto.Product;
import dto.Supplier;

public class ProductDAO extends ObjectDAO implements ICrud<Product> {
    private Connection conn = null;
    private PreparedStatement prest = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
	
	public static ProductDAO getInstance() {
		return new ProductDAO();
	}
	
    public ProductDAO() {}

	@Override
	public boolean create(Product Obj) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO products (product_name, category, brand, sell_price, discount, discount_price, quantity, product_status, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int affectedRowCount = runUpdate(sql,
			Obj.getProductName(),
			Obj.getCategory(),
			Obj.getBrand(),
			Obj.getSellPrice(),
			Obj.isDiscount(),
			Obj.getDiscountPrice(),
			Obj.getQuantity(),
			Obj.getProductStatus(),
			Obj.getImageUrl()
		);
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
					rs.getInt("sell_price"),
					rs.getBoolean("discount"),
					rs.getInt("discount_price"),
					rs.getInt("quantity"),
					rs.getBoolean("product_status"),
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
					rs.getInt("sell_price"),
					rs.getBoolean("discount"),
					rs.getInt("discount_price"),
					rs.getInt("quantity"),
					rs.getBoolean("product_status"),
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
		String sql = "UPDATE products SET product_name = ?, category = ?, brand = ?, sell_price = ?, discount = ?, discount_price = ?, quantity = ?, product_status = ?, image_url = ? WHERE id = ?";
		int affectedRowCount = runUpdate(sql,
			Obj.getProductName(),
			Obj.getCategory(),
			Obj.getBrand(),
			Obj.getSellPrice(),
			Obj.isDiscount(),
			Obj.getDiscountPrice(),
			Obj.getQuantity(),
			Obj.getProductStatus(),
			Obj.getImageUrl(),
			Obj.getId()
		);
		return affectedRowCount > 0;
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
	
	public int size() {
		int size = -1;
		rs = runQuery("Select count(1) from products");
		try {
			if (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public boolean decreaseQuantity(int ID) {
	    String query = "UPDATE products SET quantity = quantity - 1 WHERE id = ?";
	    try {
	        conn = DataConnection.connect();
	        prest = conn.prepareStatement(query);
	        prest.setInt(1, ID);
	        int rowsAffected = prest.executeUpdate();
	        if (rowsAffected <= 0) {
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (prest != null) {
	                prest.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return true;    
	}
	
	public int getQuantityNumber(int ID) {
		// TODO Auto-generated method stub
		String sql = "select quantity from mywatchstore.products where id = ?";
		try {
			int quantity = -1;
			rs = runQuery2(sql, ID);
			if (rs.next()) {
				quantity = rs.getInt("quantity");
			}
			return quantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
