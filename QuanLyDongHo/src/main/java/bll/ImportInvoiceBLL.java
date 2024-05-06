package bll;

import java.util.ArrayList;

import dao.ImportInvoiceDAO;
import dto.ImportInvoice;

public class ImportInvoiceBLL {
	public static int getNextId() {
		return ImportInvoiceDAO.getInstance().size() + 1;
	} 
	
	public static void addImportInvoice(ImportInvoice ii) {
		ImportInvoiceDAO.getInstance().create(ii);
		ImportInvoiceDAO.getInstance().setDetails(ii);
	}
	
	public static ImportInvoice getImportInvoiceById(int id) {
		return ImportInvoiceDAO.getInstance().readByID(id);
	}
	
	public static ArrayList<ImportInvoice> readAllData() {
		return ImportInvoiceDAO.getInstance().readAllData();
	}
	
	public static ArrayList<ImportInvoice> getAllSuppliers() {
		return ImportInvoiceDAO.getInstance().getAllSuppliers();
	}
	
	public static ArrayList<ImportInvoice> getAllStaffs() {
		return ImportInvoiceDAO.getInstance().getAllStaffs();
	}
}
