package system;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.swing.FontIcon;

import dao.EmployeeDAO;
import dao.PermissionDAO;
import dto.Person;
import gui.menu.UserMenu;

public class ConfigPRJ {
	public static Person currentUser = EmployeeDAO.getInstance().readByID(1);
	
	public static HashMap<String, Boolean> product = new HashMap<>();
	public static HashMap<String, Boolean> order = new HashMap<>();
	public static HashMap<String, Boolean> receipt = new HashMap<>();
	public static HashMap<String, Boolean> warranty = new HashMap<>();
	public static HashMap<String, Boolean> customer = new HashMap<>();
	public static HashMap<String, Boolean> employee = new HashMap<>();
	public static HashMap<String, Boolean> supplier = new HashMap<>();
	
	public static HashMap<String, JPanel> menu = new HashMap<>();
	
	public static UserMenu umenu = null;
	
	public static void loadUser(Person user) {
		currentUser = user;
		loadPermission(user.getAccount().getRoleId());
		UserMenu fr = new UserMenu();
		umenu = fr;
		fr.setVisible(true);
	}
	
	public static void loadPermission(String role_id) {
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
		case "CTM":
			break;
		default:
			System.err.println("INVALID ROLE");
		}
		System.out.println(currentUser.getAccount().getRoleId());
		System.out.println(order.get("edit"));
	}
	
	public static boolean shwMsg(boolean v) {
		if (!v) {			
			JOptionPane.showMessageDialog(null,
				"Bạn không có quyền thực hiện thao tác này!!!",
				"Không đủ quyền",
				JOptionPane.PLAIN_MESSAGE,
				FontIcon.of(MaterialDesignA.ALERT_CIRCLE_OUTLINE, 70, Color.decode("#9e3838"))
			);
		}
		return v;
	}
}
