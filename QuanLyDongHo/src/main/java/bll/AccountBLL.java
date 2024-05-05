package bll;

import java.util.ArrayList;

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dto.Account;
import dto.Employee;
import system.ConfigPRJ;

public class AccountBLL { 
	
	public static final int VALID = 0;
	public static final int EMPTY_FIELD = 1;
	public static final int USER_NOT_EXIST = 2;
	public static final int PASSWORD_INCORRECT = 3;
	public static final int USERNAME_EXISTED = 4;
	public static final int INVALID_USERNAME = 5;
	public static final int INVALID_PASSWORD = 6;
	public static final int CONFIRM_PASSWD_MISMATCHED = 7;
	
	public static int login(Account account) {
		if (account.getUsername().trim().equals("") || account.getPassword().trim().equals("")) {
			return EMPTY_FIELD;
		}
		Account accountToCheck = AccountDAO.getInstance().getUserByUsername(account.getUsername());
		if (accountToCheck == null) {
			return USER_NOT_EXIST;
		}
		if (!accountToCheck.getPassword().equals(account.getPassword())) {
			return PASSWORD_INCORRECT;
		}
		account = AccountDAO.getInstance().getUserByUsername(account.getUsername());
		if (account.getRoleId().equals("CTM")) {
			ConfigPRJ.loadUser(CustomerDAO.getInstance().getCustomerByAccountId(account.getId()));
		} else {
			ConfigPRJ.loadUser(EmployeeDAO.getInstance().getEmployeeByAccountId(account.getId()));
		}
		return VALID;
	}
	
	public static int signin(Account account, String confirm) {
		if (account.getUsername().trim().equals("") || account.getPassword().trim().equals("") || confirm.trim().equals("")) {
			return EMPTY_FIELD;
		}
		if (AccountDAO.getInstance().getUserByUsername(account.getUsername()) != null) {
			return USERNAME_EXISTED;
		}
		if (!account.getUsername().matches("^[a-z][a-z0-9]{5,}$")) {
			return INVALID_USERNAME;
		}
		if (account.getPassword().length() < 8) {
			return INVALID_PASSWORD;
		}
		if (!account.getPassword().equals(confirm)) {
			return CONFIRM_PASSWD_MISMATCHED;
		}
		return VALID;
	}
	
	public static boolean changeRole(Employee emp, String role) {
		return AccountDAO.getInstance().changeRole(emp.getAccountId(), role);
	}
}
