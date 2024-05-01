package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ExportInvoice;
import dto.ExportInvoiceDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ExportInvoiceDAO extends ObjectDAO implements ICrud<ExportInvoice> {
	
	public static ExportInvoiceDAO getInstance() {
		return new ExportInvoiceDAO();
	}

	@Override
	public boolean create(ExportInvoice Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExportInvoice readByID(int ID) {
	String sql = "select * from export_invoices where export_invoice_id = ?";
		ExportInvoice exinv = null;
		try {
			rs = runQuery2(sql,ID);
			if (rs.next()) {				
				exinv = new ExportInvoice(
					rs.getInt("export_invoice_id"),
                                        rs.getInt("employee_id"),
                                        rs.getInt("customer_id"),
                                        rs.getDate("invoice_date")
				);
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
                
                ExportInvoice exportInvoice = new ExportInvoice(exportInvoiceId, employeeId, customerId, (java.sql.Date) invoiceDate);
                
                
                exportInvoices.add(exportInvoice);
            }
            
            closeConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return exportInvoices;
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

}
