package bll;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;

import dao.ProductDAO;
import dao.SupplierDAO;
import dto.Product;
import dto.Supplier;

public class SupplierBLL {
		
	public static ArrayList<Supplier> getSupplierList() {
		ArrayList<Supplier> suppliers = new ArrayList<>();
		suppliers = SupplierDAO.getInstance().readAllData();
		return suppliers;
	}
	
	public static Supplier getByID(int id) {
		Supplier supplier = SupplierDAO.getInstance().readByID(id);
		return supplier;
	}
	
	public static ArrayList<Product> getProvidedList(int id) {
		return SupplierDAO.getInstance().getProvidablePrds(id);
	}
	
	public static void addProduct(int sid, int pid) {
		SupplierDAO.getInstance().addNewProvidablePrd(sid, pid);
	}
	
	public static void rmProduct(int sid, int pid) {
		SupplierDAO.getInstance().removeProvidablePrd(sid, pid);
	}
	
	public static void addNewProduct(int sid, Product np) {
		ProductDAO.getInstance().create(np);
		int pid = ProductDAO.getInstance().size();
		SupplierDAO.getInstance().addNewProvidablePrd(sid, pid);
>>>>>>> c70bf685ade918b55237da08f39bf58d9f86323d
	}
}
