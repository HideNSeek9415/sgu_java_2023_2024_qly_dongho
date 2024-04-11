package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Employee;

public class EmployeeDAO extends ObjectDAO implements ICrud<Employee> {

	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}
	
	@Override
	public String create(Employee Obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee readByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Employee> readAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(String ID, Employee Obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee Obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isActive(int accountId) {
		return AccountDAO.getInstance().isActive(accountId);
	}
	
	public Employee getEmployeeByAccountId(int accountId) {
		Employee employee = null;
		try {
			String sql = String.format("select * from employees where account_id = '%d'", accountId);
			ResultSet rs = runQuery(sql);
			if (rs.next()) {
				employee = new Employee(
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
		return employee;
	}

}
