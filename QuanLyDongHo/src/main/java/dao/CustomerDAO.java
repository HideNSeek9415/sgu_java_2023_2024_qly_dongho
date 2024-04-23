package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import dto.Customer;

public class CustomerDAO extends ObjectDAO implements ICrud<Customer> {
	
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

	@Override
	public boolean create(Customer Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer readByID(int ID) {
		// TODO Auto-generated method stub
		return null;
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
	
	public boolean isActive(int accountId) {
		return AccountDAO.getInstance().isActive(accountId);
	}
	
	public Customer getCustomerByAccountId(int accountId) {
		Customer customer = null;
		try {
			String sql = String.format("select * from customers where account_id = '%d'", accountId);
			ResultSet rs = runQuery(sql);
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

}