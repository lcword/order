package com.hxzy.order.model;

public class Admin {
	private int id;
	private String name;//操作员姓名
	private String username;//用户名
	private String password;//密码
	private int loginCount;//登陆次数
	private Role role;//角色
	public Admin(String name, String username, String password, int loginCount, Role role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.loginCount = loginCount;
		this.role = role;
	}
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Admin() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", loginCount=" + loginCount + ", role=" + role + "]";
	}
}
