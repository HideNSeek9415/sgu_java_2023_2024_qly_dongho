package dto;

import java.util.Date;

public class Employee extends Person {
	public Employee(int id, String fullName, String gender, Date dateOfBirth, String phoneNumber, String address, int accountId) {
		super(id, fullName, gender, dateOfBirth, phoneNumber, address, accountId);
	}
}
