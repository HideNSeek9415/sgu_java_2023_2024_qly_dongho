package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Product;
import dto.Supplier;


public class SupplierDAO extends ObjectDAO implements ICrud<Supplier> {
    private Connection conn = null;
    private PreparedStatement prest = null;
    private Statement stmt = null;
    private ResultSet rs = null;
	
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
		String query = "UPDATE mywatchstore.suppliers "
                + "SET supplier_name = ?, email = ?, phone_number = ? "
                + "WHERE supplier_id = ?";
	    try {
	    	conn = DataConnection.connect();
	    	prest = conn.prepareStatement(query);
	    	prest.setString(1, Obj.getSupplierName());
	    	prest.setString(2, Obj.getEmail());
	    	prest.setString(3, Obj.getPhoneNumber());
	    	prest.setInt(4, ID);
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
		int affectedRowCount = 0;
		try {
			String sql = "DELETE FROM product_supplier WHERE product_id = ? AND supplier_id = ?";
			affectedRowCount = runUpdate(sql, PrdId, SupplierId); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectedRowCount > 0;
	}

	@Override
	public boolean delete(int id) {
		String query = "Update mywatchstore.suppliers"
				+ "	set supplier_status = 'inactive'"
				+ "where supplier_id = " + id;
		try {
	        conn = DataConnection.connect();
	        prest = conn.prepareStatement(query);
	        int rowsAffected = prest.executeUpdate(query);
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

	@Override
	public boolean recovery(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isDuplicate(String property, String value) {
		String query = "select " + property + " from suppliers where " + property + " = ?";
	    boolean flag = false;
	    try {
	        conn = DataConnection.connect();
	        prest = conn.prepareStatement(query);
	        prest.setString(1, value);
	        rs = prest.executeQuery();
	        if (rs.next()) {
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return true;
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
	    return flag;	
	}
	
	public boolean isDuplicate(int id, String property, String value) {
		String query = "select " + property + " from suppliers where " + property + " = ? and supplier_id != " + id;
		boolean flag = false;
	    try {
	        conn = DataConnection.connect();
	        prest = conn.prepareStatement(query);
	        prest.setString(1, value);
	        rs = prest.executeQuery();
	        if (rs.next()) {
	            flag = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return true;
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
	    return flag;	
	}
	
	public int getNextId() {
		String query = "select max(supplier_id) as max_id from mywatchstore.suppliers";
	    try {
	        conn = DataConnection.connect();
	        prest = conn.prepareStatement(query);
	        rs = prest.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("max_id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
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
	    return 0;	
	}
}
