package com.hxzy.order.model;

import java.util.Set;

public class Function {
	private String id;
	private String code;//代码块
	private String remark;//描述
	private Module module;//模块
	private Set<Role> set;//具有该功能的角色
	public Function(String id, String code, String remark, Module module, Set<Role> set) {
		super();
		this.id = id;
		this.code = code;
		this.remark = remark;
		this.module = module;
		this.set = set;
	}
	public Function() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Set<Role> getSet() {
		return set;
	}
	public void setSet(Set<Role> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Function [id=" + id + ", code=" + code + ", remark=" + remark + ", module="  + ", set=" + set
				+ "]";
	}
}
