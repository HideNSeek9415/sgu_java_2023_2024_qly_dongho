package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ExportInvoice;
import dto.ExportInvoiceDetail;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExportInvoice> readAllData() {
		// TODO Auto-generated method stub
		return null;
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
