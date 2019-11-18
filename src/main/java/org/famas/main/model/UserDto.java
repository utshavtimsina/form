package org.famas.main.model;
public class UserDto {
	private int id;
	private int roleId;
	private String username;
	private String password;
	private String firstName;
	private Role role;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, int roleId, String username, String password, String firstName, Role role) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
