package dto;

import java.util.Date;

public class Person {
    private int id;
    private String fullName;
    private String gender;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;
    private int accountId;
    
	public Person(int id, String fullName, String gender, Date dateOfBirth, String phoneNumber, String address, int accountId) {
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountId = accountId;
	}
	
	public Person() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", accountId=" + accountId + "]";
	}
    
    
}
