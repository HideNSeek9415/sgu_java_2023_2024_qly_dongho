	package bll;
	
	import dao.DetailExportInvoiceDAO;
	import dao.ExportInvoiceDAO;
	import dao.ProductDAO;
import dao.SupplierDAO;
import dto.ExportInvoice;
	import dto.ExportInvoiceDetail;
import dto.Supplier;

import java.sql.Date;
	import java.util.ArrayList;
	
	public class ExportInvoiceBLL {
	    
	    public static ExportInvoice getByID(int id) {
			dto.ExportInvoice supplier = ExportInvoiceDAO.getInstance().readByID(id);
			return supplier;
		}
	    public static ArrayList<ExportInvoiceDetail> getProvidedList(int id) {
			return DetailExportInvoiceDAO.getInstance().readAllData(id);
		}
	    
	    
	    public ArrayList<ExportInvoice> search(Date startDate, Date endDate, int status, String employeeName) {
	        return ExportInvoiceDAO.getInstance().searchByDateAndStatusAndName(startDate, endDate, status, employeeName);
	    }

	    
	    public static ExportInvoiceBLL getInstance() {
			return new ExportInvoiceBLL();
		}
	    
	    
	    public boolean createExportInvoice(ExportInvoice object) {
			return ExportInvoiceDAO.getInstance().create(object);
		}
	    
	    public boolean createExportInvoiceDetail(ExportInvoiceDetail object) {
	    	return ExportInvoiceDAO.getInstance().createDetail(object);
	    }
	    
	    public int getNextId() {
			return ExportInvoiceDAO.getInstance().getNextId();
		}
	    
	    public int getNextIdDetail() {
	    	return ExportInvoiceDAO.getInstance().getNextIdDetail();
	    }
	}
