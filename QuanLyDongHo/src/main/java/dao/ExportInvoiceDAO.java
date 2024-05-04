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


    public ArrayList<ExportInvoice> searchByDateAndStatusAndName(Date startDate, Date endDate, int status, String employeeName) {
        ArrayList<ExportInvoice> result = new ArrayList<>();
        try (Connection conn = DataConnection.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(
                     "SELECT * FROM export_invoices " +
                     "INNER JOIN employees ON employees.id = export_invoices.employee_id " +
                     "WHERE invoice_date BETWEEN ? AND ? " +
                     "AND export_invoice_status = ? AND employees.full_name LIKE ?")) {

            preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            preparedStatement.setInt(3, status);
            preparedStatement.setString(4, "%" + employeeName + "%"); 
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
