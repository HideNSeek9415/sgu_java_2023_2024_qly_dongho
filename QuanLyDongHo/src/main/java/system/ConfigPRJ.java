package system;

import java.util.HashMap;

import dao.PermissionDAO;
import dto.Person;

public class ConfigPRJ {
	public static Person currentUser = null;
	
	public static HashMap<String, Boolean> product = new HashMap<>();
	public static HashMap<String, Boolean> order = new HashMap<>();
	public static HashMap<String, Boolean> receipt = new HashMap<>();
	public static HashMap<String, Boolean> warranty = new HashMap<>();
	public static HashMap<String, Boolean> customer = new HashMap<>();
	public static HashMap<String, Boolean> employee = new HashMap<>();
	public static HashMap<String, Boolean> supplier = new HashMap<>();
 
	
	public static void loadUser(Person user) {
		currentUser = user;
	}
	
	public void loadPermission(String role_id) {
		switch (role_id) {
		case "ADM":
			product.put("add", true);
			product.put("edit", true);
			product.put("delete", true);
			employee.put("add", true);
			employee.put("edit", true);
			employee.put("delete", true);
			customer.put("edit", true);
			customer.put("delete", true);
			order.put("add", true);
			order.put("edit", true);
			receipt.put("add", true);
			receipt.put("edit", true);
			warranty.put("other", true);
			supplier.put("add", true);
			supplier.put("edit", true);
			supplier.put("delete", true);
			supplier.put("other", true);
			break;
		case "WHM":
			PermissionDAO.instance.loadPermission("WHM");
			break;
		case "SLR":
			PermissionDAO.instance.loadPermission("SLR");
			break;
		}
	}
}
