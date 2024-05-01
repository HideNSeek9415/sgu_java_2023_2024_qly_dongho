package bll;

import java.util.Date;

import dao.AccountDAO;
import dao.EmployeeDAO;
import dto.Account;
import dto.Customer;
import dto.Employee;

public class EmployeeBLL {
	
	public static final int VALID = 0;
	public static final int EMPTY_FIELD = 1;
	public static final int USED_PHONE_NUMBER = 2;
	public static final int INVALID_PHONE_NUMBER = 3;

	public static int checkInfo(Employee emp) {
		
		String fname = emp.getFullName();
		String phone = emp.getPhoneNumber();
		Date dob = emp.getDateOfBirth();
		String address = emp.getAddress();
		
		if (fname.isBlank() || phone.isBlank() || dob == null || address.isBlank()) {
			return EMPTY_FIELD;
		} else if (!phone.matches("^0[0-9]{9}")) {
			return INVALID_PHONE_NUMBER;
		} else if (EmployeeDAO.getInstance().isUsedPhoneNum(phone)) {
			return USED_PHONE_NUMBER;
		}
		return VALID;
	}
	
	public static boolean addEmployee(Employee emp) {
		Account acc = emp.getAccount();
		AccountDAO.getInstance().create(acc);
		Account updateAc = AccountDAO.getInstance().getUserByUsername(acc.getUsername());
		emp.setAccountId(updateAc.getId());
		return EmployeeDAO.getInstance().create(emp);
	}
	
	public static Employee getEmployee(int id) {
		Employee emp =  EmployeeDAO.getInstance().readByID(id);
		emp.setAccount(getAccount(emp));
		return emp;
	}
	
	public static Account getAccount(Employee emp) {
		Account acc = AccountDAO.getInstance().readByID(emp.getAccountId());
		acc.setRoleName(AccountDAO.getInstance().getRole(acc.getId()));
		return acc;
	}
	
	public static String getRole(int id) {
		return EmployeeDAO.getInstance().getRole(id);
	}
	
	public static void updateUser(Employee emp) {
		EmployeeDAO.getInstance().update(0, emp);
		AccountDAO.getInstance().update(0, emp.getAccount());
	} 
}
