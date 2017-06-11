package com.hxzy.order.model;

import java.util.Set;

public class Kind {
	private String id;
	private String name;
	private Set<Dish> set;
	public Kind(String id, String name, Set<Dish> set) {
		super();
		this.id = id;
		this.name = name;
		this.set = set;
	}
	public Kind() {
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
	public Set<Dish> getSet() {
		return set;
	}
	public void setSet(Set<Dish> set) {
		this.set = set;
	}
	@Override
	public String toString() {
		return "Kind [id=" + id + ", name=" + name + "]";
	}
}
