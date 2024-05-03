package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ImportInvoiceDetail;
import dto.ImportInvoice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ImportInvoiceDAO extends ObjectDAO implements ICrud<ImportInvoice> {
	
	public static ImportInvoiceDAO getInstance() {
		return new ImportInvoiceDAO();
	}

	@Override
	public boolean create(ImportInvoice Obj) {
		String sql = "insert into import_invoices (employee_id, supplier_id, invoice_date) values (?, ?, ?)";		
		int affectedRow = runUpdate(sql,
			Obj.getEmployeeId(),
			Obj.getSupplierId(),
			Obj.getInvoiceDate()
		);
		return affectedRow > 0;
	}

	@Override
	public ImportInvoice readByID(int ID) {
        ImportInvoice ii = null;
        try {
            String sql = "SELECT * FROM import_invoices where import_invoice_id = ?";
            ResultSet rs = runQuery2(sql, ID);
            
            while (rs.next()) {
                int importInvoiceId = rs.getInt("import_invoice_id");
                int employeeId = rs.getInt("employee_id");
                int supplierId = rs.getInt("supplier_id");
                Date invoiceDate = 	new java.util.Date(rs.getDate("invoice_date").getTime());
                
                ii = new ImportInvoice(importInvoiceId, employeeId, supplierId, invoiceDate);
                ii.setDetails(getDetails(importInvoiceId));
            }
            
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return ii;
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
                Date invoiceDate = 	new java.util.Date(rs.getDate("invoice_date").getTime());
                
                ImportInvoice importInvoice = new ImportInvoice(importInvoiceId, employeeId, supplierId, invoiceDate);
                importInvoice.setDetails(getDetails(importInvoiceId));
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
    	ArrayList<ImportInvoiceDetail> details = new ArrayList<>();
    	String sql = "select * from import_invoice_details where import_invoice_id = ?";
    	rs = runQuery2(sql, id);
    	try {
			while (rs.next()) {
				ImportInvoiceDetail d = new ImportInvoiceDetail(
					rs.getInt("details_id"),
					rs.getInt("import_invoice_id"),
					rs.getInt("product_id"),
					rs.getInt("quantity"),
					rs.getInt("import_price")
				);
				details.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return details;
    }
	
	public Boolean setDetails(ImportInvoice ii) {
		String sql1 = "insert into import_invoice_details (import_invoice_id, product_id, quantity, import_price) values (?, ?, ?, ?)";		
		String sql2 = "update products set quantity = quantity + ? where id = ?";
		for (ImportInvoiceDetail iid : ii.getDetails()) {
			runUpdate(sql1,
				iid.getImportInvoiceId(),
				iid.getProductId(),
				iid.getQuantity(),
				iid.getImportPrice()
			);
			runUpdate(sql2, iid.getQuantity(), iid.getProductId());
		}
		return true;
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
		String sql = "Select count(1) from import_invoices";
		rs = runQuery(sql);
		try {
			if (rs.next()) {
				size = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

}
