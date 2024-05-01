package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ImportInvoiceDetail;
import dto.ImportInvoice;
import java.sql.ResultSet;
import java.util.Date;

public class ImportInvoiceDAO extends ObjectDAO implements ICrud<ImportInvoice> {
	
	public static ImportInvoiceDAO getInstance() {
		return new ImportInvoiceDAO();
	}

	@Override
	public boolean create(ImportInvoice Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImportInvoice readByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
        public ArrayList<ImportInvoice> readAllData() {
        ArrayList<ImportInvoice> importInvoices = new ArrayList<>();
        try {
            String sql = "SELECT * FROM import_invoices";
            ResultSet rs = runQuery(sql);
            
            while (rs.next()) {
                int importInvoiceId = rs.getInt("import_invoice_id");
                int employeeId = rs.getInt("employee_id");
                int supplierId = rs.getInt("supplier_id");
                Date invoiceDate = rs.getDate("invoice_date");
                
                ImportInvoice importInvoice = new ImportInvoice(importInvoiceId, employeeId, supplierId, (java.sql.Date) invoiceDate);
                
                
                importInvoices.add(importInvoice);
            }
            
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return importInvoices;
    }
	
        @Override
	public boolean update(int ID, ImportInvoice Obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<ImportInvoiceDetail> getDetails(int id) {
		return null;
	}
	
	public Boolean setDetails(int id, List<ImportInvoiceDetail> details) {
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
