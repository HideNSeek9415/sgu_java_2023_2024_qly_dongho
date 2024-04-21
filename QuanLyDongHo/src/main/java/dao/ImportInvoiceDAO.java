package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ImportInvoiceDetail;
import dto.ImportInvoice;

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
		// TODO Auto-generated method stub
		return null;
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
