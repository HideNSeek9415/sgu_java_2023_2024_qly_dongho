package bll;

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
	
	public static void addNewProduct(int sid, Product np) {
		ProductDAO.getInstance().create(np);
		int pid = ProductDAO.getLastIndex();
		SupplierDAO.getInstance().addNewProvidablePrd(sid, pid);
	}
}
