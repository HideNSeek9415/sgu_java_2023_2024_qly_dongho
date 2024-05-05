package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.ExportInvoice;
import dto.ExportInvoiceDetail;
import dto.ExportInvoice;

public class ExportInvoiceDAO extends ObjectDAO implements ICrud<ExportInvoice> {
    private Connection conn = null;
    private PreparedStatement prest = null;
    private Statement stmt = null;
    private ResultSet rs = null;

	
    public static ExportInvoiceDAO getInstance() {
        return new ExportInvoiceDAO();
    }

    @Override
    public boolean create(ExportInvoice Obj) {
    	boolean flag = true;
		try {
	    	String sql = "INSERT INTO export_invoices (export_invoice_id, employee_id, customer_id"
	    			+ ", invoice_date, export_invoice_status) VALUES (?, ?, ?, ?, ?)";
			int affectedRowCount = runUpdate(sql,
				Obj.getExportInvoiceId(),
				null,
				Obj.getCustomerId(),
				Obj.getInvoiceDate(),
				0
			);
			closeConnection();
			if(affectedRowCount > 0) return true;
		}
	    catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
		return false;
	}

    @Override
    public ExportInvoice readByID(int ID) {
        String sql = "SELECT * FROM export_invoices WHERE export_invoice_id = ?";
        ExportInvoice exinv = null;
        try {
            rs = runQuery2(sql, ID);
            if (rs.next()) {
                exinv = new ExportInvoice(rs.getInt("export_invoice_id"), rs.getInt("employee_id"),
                        rs.getInt("customer_id"), rs.getDate("invoice_date"), rs.getInt("export_invoice_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return exinv;
    }

    @Override
    public ArrayList<ExportInvoice> readAllData() {
        ArrayList<ExportInvoice> exportInvoices = new ArrayList<>();
        try {
            String sql = "SELECT * FROM export_invoices";
            ResultSet rs = runQuery(sql);

            while (rs.next()) {
                int exportInvoiceId = rs.getInt("export_invoice_id");
                int employeeId = rs.getInt("employee_id");
                int customerId = rs.getInt("customer_id");
                Date invoiceDate = rs.getDate("invoice_date");
                int exportinvoiceStatus = rs.getInt("export_invoice_status");

                ExportInvoice exportInvoice = new ExportInvoice(exportInvoiceId, employeeId, customerId,
                        (java.sql.Date) invoiceDate, exportinvoiceStatus);

                exportInvoices.add(exportInvoice);
            }

            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exportInvoices;
    }
    
    public ArrayList<ExportInvoice> readAllDataByCustomerId(int customerId) {
        ArrayList<ExportInvoice> exportInvoices = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
            conn = DataConnection.connect();
            String sql = "SELECT * FROM export_invoices WHERE customer_id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int exportInvoiceId = rs.getInt("export_invoice_id");
                int employeeId = rs.getInt("employee_id");
                int invoiceCustomerId = rs.getInt("customer_id");
                Date invoiceDate = rs.getDate("invoice_date");
                int exportInvoiceStatus = rs.getInt("export_invoice_status");

                ExportInvoice exportInvoice = new ExportInvoice(exportInvoiceId, employeeId, invoiceCustomerId,
                        (java.sql.Date) invoiceDate, exportInvoiceStatus);

                exportInvoices.add(exportInvoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo kết nối, preparedStatement và resultSet được đóng ngay sau khi sử dụng xong
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exportInvoices;
    }




    public ArrayList<ExportInvoice> searchByDateAndStatusAndName(Date startDate, Date endDate, int status, String employeeName, int employeeID) {
        ArrayList<ExportInvoice> result = new ArrayList<>();
        try (Connection conn = DataConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "SELECT * FROM export_invoices " +
                     "INNER JOIN employees ON employees.id = export_invoices.employee_id " +
                     "WHERE invoice_date BETWEEN ? AND ? " +
                     "AND export_invoice_status = ? AND employees.full_name LIKE ? AND customer_id = ?")) {

            preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            preparedStatement.setInt(3, status);
            preparedStatement.setString(4, "%" + employeeName + "%"); 
            preparedStatement.setInt(5, employeeID);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    ExportInvoice exportInvoice = new ExportInvoice(
                            rs.getInt("export_invoice_id"),
                            rs.getInt("employee_id"),
                            rs.getInt("customer_id"),
                            rs.getDate("invoice_date"),
                            rs.getInt("export_invoice_status")
                    );
                    result.add(exportInvoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ExportInvoice> searchByDateAndStatusAndNameCus(Date startDate, Date endDate, int status, String customerName) {
        ArrayList<ExportInvoice> result = new ArrayList<>();
        try (Connection conn = DataConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "SELECT * FROM export_invoices " +
                     "INNER JOIN customers ON customers.id = export_invoices.customer_id " +
                     "WHERE invoice_date BETWEEN ? AND ? " +
                     "AND export_invoice_status = ? AND customers.full_name LIKE ?")) {

            preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            preparedStatement.setInt(3, status);
            preparedStatement.setString(4, "%" + customerName + "%"); 
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    ExportInvoice exportInvoice = new ExportInvoice(
                            rs.getInt("export_invoice_id"),
                            rs.getInt("employee_id"),
                            rs.getInt("customer_id"),
                            rs.getDate("invoice_date"),
                            rs.getInt("export_invoice_status")
                    );
                    result.add(exportInvoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    

    public boolean updateStatusForEmployee(int exportInvoiceId, int employeeId) {
        try (Connection conn = DataConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "UPDATE export_invoices SET export_invoice_status = 1, employee_id = ? WHERE export_invoice_id = ?")) {

            preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, exportInvoiceId);
            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int ID, ExportInvoice Obj) {
        // TODO Auto-generated method stub
        return false;
    }

    public ArrayList<ExportInvoiceDetail> getDetails(int id) {
        return null;
    }

    public Boolean setDetails(int id, List<ExportInvoiceDetail> details) {
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

    public int getNextId() {
		String query = "select max(export_invoice_id) as max_id from mywatchstore.export_invoices";
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
    
    public int getNextIdDetail() {
		String query = "select max(details_id) as max_id from mywatchstore.export_invoice_details";
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
    
    public boolean createDetail(ExportInvoiceDetail Obj) {
    	boolean flag = true;
		try {
	    	String sql = "INSERT INTO export_invoice_details (details_id, export_invoice_id"
	    			+ ", product_id, sell_price) VALUES (?, ?, ?, ?)";
			int affectedRowCount = runUpdate(sql,
				Obj.getDetailsId(),
				Obj.getExportInvoiceId(),
				Obj.getProductId(),
				Obj.getSellPrice()
			);
			closeConnection();
			if(affectedRowCount > 0) return true;
		}
	    catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
		return false;
	}
}
