package com.hxzy.order.model;

public class Role {
	private int id;
	private String name;//角色名
	private String remark;//备注
	public Role(String name, String remark) {
		super();
		this.name = name;
		this.remark = remark;
	}
	public Role() {
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
}
