package dao;

import system.ConfigPRJ;

public class PermissionDAO extends ObjectDAO {
	
	public static PermissionDAO instance = new PermissionDAO();
	
	public void loadPermission(String roleId) {
		String sql = "select * from decentralization where role_id = ?";
		try {
			rs = runQuery2(sql, roleId);
			while (rs.next()) {
				switch (rs.getString("permission_code")) {
				case "PRODUCT":
					ConfigPRJ.product.put("add", rs.getBoolean("adding"));
					ConfigPRJ.product.put("edit", rs.getBoolean("editing"));
					ConfigPRJ.product.put("delete", rs.getBoolean("deleting"));
					break;
				case "EMPLOYEE":
					ConfigPRJ.employee.put("add", rs.getBoolean("adding"));
					ConfigPRJ.employee.put("edit", rs.getBoolean("editing"));
					ConfigPRJ.employee.put("delete", rs.getBoolean("deleting"));
					break;
				case "CUSTOMER":
					ConfigPRJ.customer.put("edit", rs.getBoolean("editing"));
					ConfigPRJ.customer.put("delete", rs.getBoolean("deleting"));
					break;
				case "ORDER":
					ConfigPRJ.order.put("add", rs.getBoolean("adding"));
					ConfigPRJ.order.put("edit", rs.getBoolean("editing"));
					break;
				case "RECEIPT":
					ConfigPRJ.receipt.put("add", rs.getBoolean("adding"));
					ConfigPRJ.receipt.put("edit", rs.getBoolean("editing"));
					break;
				case "WARRANTY":
					ConfigPRJ.warranty.put("other", rs.getBoolean("other"));
					break;
				case "SUPPLIER":
					ConfigPRJ.supplier.put("add", rs.getBoolean("adding"));
					ConfigPRJ.supplier.put("edit", rs.getBoolean("editing"));
					ConfigPRJ.supplier.put("delete", rs.getBoolean("deleting"));
					ConfigPRJ.supplier.put("other", rs.getBoolean("other"));
					break;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void savePermission(String roleId) {
		String sql = "update decentralization set adding = ?, editing = ?, deleting = ?, other = ? where permission_code = ? and role_id = ?";
		runUpdate(sql, ConfigPRJ.product.get("add"), ConfigPRJ.product.get("edit"), ConfigPRJ.product.get("delete"), ConfigPRJ.product.get("other"), "PRODUCT", roleId);
		runUpdate(sql, ConfigPRJ.employee.get("add"), ConfigPRJ.employee.get("edit"), ConfigPRJ.employee.get("delete"), ConfigPRJ.employee.get("other"), "EMPLOYEE", roleId);
		runUpdate(sql, ConfigPRJ.customer.get("add"), ConfigPRJ.customer.get("edit"), ConfigPRJ.customer.get("delete"), ConfigPRJ.customer.get("other"), "CUSTOMER", roleId);
		runUpdate(sql, ConfigPRJ.order.get("add"), ConfigPRJ.order.get("edit"), ConfigPRJ.order.get("delete"), ConfigPRJ.order.get("other"), "ORDER", roleId);
		runUpdate(sql, ConfigPRJ.receipt.get("add"), ConfigPRJ.receipt.get("edit"), ConfigPRJ.receipt.get("delete"), ConfigPRJ.receipt.get("other"), "RECEIPT", roleId);
		runUpdate(sql, ConfigPRJ.warranty.get("add"), ConfigPRJ.warranty.get("edit"), ConfigPRJ.warranty.get("delete"), ConfigPRJ.warranty.get("other"), "WARRANTY", roleId);
		runUpdate(sql, ConfigPRJ.supplier.get("add"), ConfigPRJ.supplier.get("edit"), ConfigPRJ.supplier.get("delete"), ConfigPRJ.supplier.get("other"), "SUPPLIER", roleId);

	}
}
