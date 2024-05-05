package gui.menu;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import dto.Account;
import dto.Customer;
import dto.Employee;
import gui.dashboard.DashboardFrame;
import gui.dashboard.FunctionBtn;
import system.ConfigPRJ;

@SuppressWarnings("serial")
public class UserMenu extends DashboardFrame {
	public UserMenu() {
		super();
		if (ConfigPRJ.currentUser.getAccount().getRoleId().equals("CTM")) {
			addFunction(new FunctionBtn(FunctionBtn.HISTORY));
		} else {
			addFunction(new FunctionBtn(FunctionBtn.PRODUCTS));
			addFunction(new FunctionBtn(FunctionBtn.RECEIPTS));
			addFunction(new FunctionBtn(FunctionBtn.ORDERS));
			addFunction(new FunctionBtn(FunctionBtn.CUSTOMERS));
			addFunction(new FunctionBtn(FunctionBtn.SUPPLIERS));
			addFunction(new FunctionBtn(FunctionBtn.EMPLOYEES));
			addFunction(new FunctionBtn(FunctionBtn.STATISTICAL));
			addFunction(new FunctionBtn(FunctionBtn.PERMISSION));
			addFunction(new FunctionBtn(FunctionBtn.WARRANTY));
		}
		changeLabel(ConfigPRJ.currentUser.getFullName(), ConfigPRJ.currentUser.getAccount().getRoleName());
	}
	
	public void updateName() {
		Account acc = ConfigPRJ.currentUser.getAccount(); 
		if (acc.getRoleId().equals("CTM")) {
			Customer cus =  CustomerDAO.getInstance().getCustomerByAccountId(acc.getId());
			ConfigPRJ.currentUser = cus;
		} else {
			Employee emp = EmployeeDAO.getInstance().getEmployeeByAccountId(acc.getId());
			ConfigPRJ.currentUser = emp;
		}
		ConfigPRJ.loadPermission(ConfigPRJ.currentUser.getAccount().getRoleId());
		changeLabel(ConfigPRJ.currentUser.getFullName(), ConfigPRJ.currentUser.getAccount().getRoleName());
	}
}
