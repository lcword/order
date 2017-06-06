package com.hxzy.order.dto;

public class AdminDto {
	private int id;
	private String name;//操作员姓名
	private String username;//用户名
	private int roleId;//角色
	public AdminDto(int id, String name, String username, int roleId) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.roleId = roleId;
	}
	public AdminDto() {
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "AdminDto [id=" + id + ", name=" + name + ", username=" + username + ", roleId=" + roleId + "]";
	}
}
