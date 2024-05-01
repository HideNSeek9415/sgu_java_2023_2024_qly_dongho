package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Customer;

public class CustomerDAO extends ObjectDAO implements ICrud<Customer> {
	
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

	@Override
	public boolean create(Customer Obj) {
		int rowChanges = 0;
		String sql = "INSERT INTO customers (full_name, gender, date_of_birth, phone_number, address, account_id) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			rowChanges = runUpdate(sql, 
				Obj.getFullName(),
				Obj.getGender(),
				Obj.getDateOfBirth(),
				Obj.getPhoneNumber(),
				Obj.getAddress(),
				Obj.getAccount().getId()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowChanges > 0;
	}

	@Override
	public Customer readByID(int ID) {
		// TODO Auto-generated method stub
		Customer ctm = null;
		try {
			String sql = String.format("select * from customers");
			ResultSet rs = runQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("id"),
					rs.getString("full_name"),
					rs.getString("gender"),
					new java.util.Date(rs.getDate("date_of_birth").getTime()),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getInt("account_id")
				);
				ctm = customer;
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctm;
	}

	@Override
	public ArrayList<Customer> readAllData() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			String sql = String.format("select * from customers");
			ResultSet rs = runQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getInt("id"),
					rs.getString("full_name"),
					rs.getString("gender"),
					new java.util.Date(rs.getDate("date_of_birth").getTime()),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getInt("account_id")
				);
				customers.add(customer);
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean update(int ID, Customer Obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isActive(int id) {
		boolean returnValue = false;
		try {
			String sql = String.format("select a.account_status from accounts as a join customers as e on e.account_id = a.id where id = '%d'", id);
			rs = runQuery(sql);
			if (rs.next() && rs.getString(1).equals("active")) {
				returnValue = true;
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue; 
	}
	
	public Customer getCustomerByAccountId(int accountId) {
		Customer customer = null;
		try {
			String sql = String.format("select * from customers where account_id = '%d'", accountId);
			rs = runQuery(sql);
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("id"),
					rs.getString("full_name"),
					rs.getString("gender"),
					new java.util.Date(rs.getDate("date_of_birth").getTime()),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getInt("account_id")
				);
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recovery(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isUsedPhoneNum(String phoneNum) {
		boolean ret = false;
		try {
			String sql = "select phone_number from customers where phone_number = ?";
			rs = runQuery2(sql, phoneNum);
			if (rs.next()) ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
