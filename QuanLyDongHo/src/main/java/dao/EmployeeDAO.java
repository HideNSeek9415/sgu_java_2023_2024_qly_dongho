package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Employee;

public class EmployeeDAO extends ObjectDAO implements ICrud<Employee> {

	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}
	
	@Override
	public boolean create(Employee Obj) {
		String sql = "INSERT INTO employees (full_name, gender, date_of_birth, phone_number, address, account_id) VALUE (?, ?, ?, ?, ?, ?)";
		int rowChanges = runUpdate(sql,
			Obj.getFullName(),
			Obj.getGender(),
			Obj.getDateOfBirth(),
			Obj.getPhoneNumber(),
			Obj.getAddress(),
			Obj.getAccountId()
		);
		return rowChanges > 0;
	}

	@Override
	public Employee readByID(int ID) {
		String sql = "select * from employees where id = ?";
		Employee employee = null;
		try {
			rs = runQuery2(sql, ID);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return employee;
	}

	@Override
	public ArrayList<Employee> readAllData() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			String sql = String.format("select * from employees");
			ResultSet rs = runQuery(sql);
			while (rs.next()) {
				Employee employee = new Employee(
					rs.getInt("id"),
					rs.getString("full_name"),
					rs.getString("gender"),
					new java.util.Date(rs.getDate("date_of_birth").getTime()),
					rs.getString("phone_number"),
					rs.getString("address"),
					rs.getInt("account_id")
				);
				employees.add(employee);
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean update(int ID, Employee Obj) {
		int rowChanges = 0;
		String sql = "UPDATE employees SET full_name = ?, gender = ?, date_of_birth = ?, phone_number = ?, address = ? WHERE id = ?";
		try {
			rowChanges = runUpdate(sql, 
				Obj.getFullName(),
				Obj.getGender(),
				Obj.getDateOfBirth(),
				Obj.getPhoneNumber(),
				Obj.getAddress(),
				Obj.getId()
			);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rowChanges > 0;
	}
	
	public boolean isActive(int id) {
		boolean returnValue = false;
		try {
			String sql = String.format("select a.account_status from accounts as a join employees as e on e.account_id = a.id where id = '%d'", id);
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

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		closeConnection();
		return false;
	}

	@Override
	public boolean recovery(int id) {
		// TODO Auto-generated method stub
		closeConnection();
		return false;
	}
	
	public String getRoleName(int accountId) {
		String sql = "select r.role_name from roles as r join accounts as a on a.role_id = r.role_id where a.id = ?";
		String ret = null;
		rs = runQuery2(sql, accountId);
		try {
			if (rs.next()) {
				ret = rs.getString("role_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return ret;
	}
	
	public String getRole(int id) {
		String sql = "select a.role_id from accounts as a join employees as e on e.account_id = a.id where e.id = ?";
		String ret = null;
		rs = runQuery2(sql, id);
		try {
			if (rs.next()) {
				ret = rs.getString("role_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public boolean isUsedPhoneNum(String phoneNum) {
		boolean ret = false;
		try {
			String sql = "select phone_number from employees where phone_number = ?";
			rs = runQuery2(sql, phoneNum);
			if (rs.next()) ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret; 
	}
	
//	public boolean changeRole(int id, String role) {
//		
//	}

}
