package bll;

import java.util.ArrayList;

import dao.ProductDAO;
import dto.Product;

public class ProductBLL {
	
	public static boolean saveProduct(Product prd) {
		return ProductDAO.getInstance().create(prd);
	}
	
	public static ArrayList<Product> getAllProduct() {
		return ProductDAO.getInstance().readAllData();
	}
	
	public static Product getById(int id) {
		return ProductDAO.getInstance().readByID(id);
	}
	
	public static boolean updateProduct(Product p) {
		return ProductDAO.getInstance().update(0, p);
	}
	
	public static boolean decreaseQuantity(int ID) {
		return ProductDAO.getInstance().decreaseQuantity(ID);
	}
	
	public static int getQuantityNumber(int ID) {
		return ProductDAO.getInstance().getQuantityNumber(ID);
	}
}
