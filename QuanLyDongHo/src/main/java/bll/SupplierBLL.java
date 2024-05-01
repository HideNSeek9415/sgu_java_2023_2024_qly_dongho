package bll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.DataConnection;
import dao.SupplierDAO;
import dto.Supplier;

public class SupplierBLL {
	public static SupplierBLL getInstance() {
		return new SupplierBLL();
	}
	
	public boolean deleteSupplier(int idSupplier) {
		return (SupplierDAO.getInstance().delete(idSupplier) == false) ? false : true;
	}
	
	public ArrayList<Supplier> readAllData() {
		return SupplierDAO.getInstance().readAllData();
	}
	
	public int getNextId() {
		return SupplierDAO.getInstance().getNextId();
	}
	
	
	public boolean isDuplicate(String property, String value) {
		return SupplierDAO.getInstance().isDuplicate(property, value);
	}
	
	public boolean isDuplicate(int id, String property, String value) {
		return SupplierDAO.getInstance().isDuplicate(id, property, value);
	}
	public boolean addSupplier(Supplier object) {
		return SupplierDAO.getInstance().create(object);
	}
	
	public boolean editSupplier(int id, Supplier object) {
		return SupplierDAO.getInstance().update(id, object);
	}
}
