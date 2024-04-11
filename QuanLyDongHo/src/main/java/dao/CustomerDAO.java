package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import dto.Customer;

public class CustomerDAO extends ObjectDAO implements ICrud<Customer> {
	
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

	@Override
	public String create(Customer Obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer readByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> readAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String ID, Customer Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer Obj) {
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

}
