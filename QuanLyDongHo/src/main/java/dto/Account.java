package dto;

import java.util.ArrayList;
import java.util.Date;

import dao.AccountDAO;

public class Account {
    @Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", accountStatus="
				+ accountStatus + ", roleId=" + roleId + ", createdDate=" + createdDate + ", roleName=" + roleName
				+ ", permission=" + permission + "]";
	}
	private int id;
    private String username;
    private String password;
    private String accountStatus;
    private String roleId;
    private Date createdDate;
    private String roleName;
    private ArrayList<String> permission = new ArrayList<>();

	public ArrayList<String> getPermission() {
		return permission;
	}

	public void setPermission(ArrayList<String> permission) {
		this.permission = permission;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Account(int id, String username, String password, String accountStatus, String roleId, Date createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.accountStatus = accountStatus;
		this.roleId = roleId;
		this.createdDate = createdDate;
		setRoleName(AccountDAO.getInstance().getRole(id));
	}
	
	public Account() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
    
}
