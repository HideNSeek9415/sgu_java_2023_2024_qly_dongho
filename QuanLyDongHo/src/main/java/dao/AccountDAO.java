package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Account;

public class AccountDAO extends ObjectDAO implements ICrud<Account> {
	
	public static AccountDAO getInstance() {
		return new AccountDAO();
	}

	@Override
	public String create(Account Obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account readByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> readAllData() {
		ArrayList<Account> accounts = new ArrayList<>();
		String sql = "select * from accounts";
		try {
			ResultSet rs = runQuery(sql);
			while (rs.next()) {
				Account account = new Account(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					new java.util.Date(rs.getDate(6).getTime())
				);
				accounts.add(account);
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public boolean update(String ID, Account Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Account Obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Account getUserByUsername(String username) {
		Account returnValue = null;
		String sql = String.format("select * from accounts where username = '%s'", username);
		ResultSet rs = runQuery(sql);
		try {
			if (rs.next()) returnValue = new Account(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					new java.util.Date(rs.getDate(6).getTime())
				);
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean isActive(int accountId) {
		boolean returnValue = false;
		try {
			String sql = String.format("select account_status from accounts where id = '%d'", accountId);
			ResultSet rs = runQuery(sql);
			if (rs.next() && rs.getString(1).equals("active")) {
				returnValue = true;
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public String getRoleId(int accountId) {
		String returnValue = null;
		try {
			String sql = String.format("select role_id from accounts where id = '%d'", accountId);
			ResultSet rs = runQuery(sql);
			if (rs.next()) returnValue = rs.getString(1);
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return returnValue;
	}
}
