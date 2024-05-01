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
	public boolean create(Supplier obj) {
		try {
            String query = "insert into mywatchstore.suppliers values (?, ?, ?, ?, ?)";
            conn = DataConnection.connect();
            prest = conn.prepareStatement(query);
            prest.setInt(1, obj.getSupplierId());
            prest.setString(2, obj.getSupplierName());
            prest.setString(3, obj.getEmail());
            prest.setString(4, obj.getSupplierStatus());
            prest.setString(5, obj.getPhoneNumber());
            int rowAffected = prest.executeUpdate();
            if(rowAffected > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prest != null) {
                	prest.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
