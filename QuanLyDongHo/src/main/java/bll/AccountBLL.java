package bll;

import dao.AccountDAO;
import dto.Account;

public class AccountBLL {
	
	public static final int VALID = 0;
	public static final int EMPTY_FIELD = 1;
	public static final int USER_NOT_EXIST = 2;
	public static final int PASSWORD_INCORRECT = 3;
	public static final int USERNAME_EXISTED = 4;
	public static final int INVALID_USERNAME = 5;
	public static final int INVALID_PASSWORD = 6;
	public static final int CONFIRM_PASSWD_MISMATCHED = 7;
	
	public static int checkLoginData(Account account) {
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
		return VALID;
	}
	
	public static int checkSigninData(Account account, String confirm) {
		if (account.getUsername().trim().equals("") || account.getPassword().trim().equals("") || confirm.trim().equals("")) {
			return EMPTY_FIELD;
		}
		if (AccountDAO.getInstance().getUserByUsername(account.getUsername()) != null) {
			return USERNAME_EXISTED;
		}
		if (!account.getUsername().matches("^[a-z][a-z0-9_]{5,}$")) {
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
}
