package com.hxzy.order.model;

import java.util.Set;

public class Role {
	private String id;
	private String name;//角色名
	private String remark;//备注
	private Set<Function> set;//该角色具有的功能
	public Role(String id, String name, String remark, Set<Function> set) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.set = set;
	}
	public Role() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Set<Function> getSet() {
		return set;
	}
	public void setSet(Set<Function> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
}
