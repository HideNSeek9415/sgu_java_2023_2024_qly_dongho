package bll;

import java.util.Date;

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dto.Account;
import dto.Customer;
import dto.Employee;
import system.ConfigPRJ;

public class CustomerBLL {
	
	public static final int VALID = 0;
	public static final int EMPTY_FIELD = 1;
	public static final int USED_PHONE_NUMBER = 2;
	public static final int INVALID_PHONE_NUMBER = 3;

	public static int checkInfo(Customer ctm) {
		
		String fname = ctm.getFullName();
		String phone = ctm.getPhoneNumber();
		Date dob = ctm.getDateOfBirth();
		String address = ctm.getAddress();
		
		if (fname.isBlank() || phone.isBlank() || dob == null || address.isBlank()) {
			return EMPTY_FIELD;
		} else if (!phone.matches("^0[0-9]{9}")) {
			return INVALID_PHONE_NUMBER;
		} else if (CustomerDAO.getInstance().isUsedPhoneNum(phone)) {
			return USED_PHONE_NUMBER;
		}
		return VALID;
	}
	
	public static void addCustomer(Customer ctm) {
		Account acc = ctm.getAccount();
		acc.setRoleId("CTM");
		AccountDAO.getInstance().create(acc);
		Account updateAc = AccountDAO.getInstance().getUserByUsername(acc.getUsername());
		ctm.setAccount(updateAc);
		CustomerDAO.getInstance().create(ctm);
		ConfigPRJ.currentUser = CustomerDAO.getInstance().getCustomerByAccountId(updateAc.getId());
	}
	
	public static Customer getCustomer(int id) {
		return CustomerDAO.getInstance().readByID(id);
	}
	
	public static Account getAccount(Customer cus) {
		return AccountDAO.getInstance().readByID(cus.getAccountId());
	}
	
	public static void updateUser(Customer ctm) {
		CustomerDAO.getInstance().update(0, ctm);
		AccountDAO.getInstance().update(0, ctm.getAccount());
	}
}
