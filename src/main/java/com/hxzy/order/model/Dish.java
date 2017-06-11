package com.hxzy.order.model;

public class Dish {
	private String id;
	private String name;
	private double price;
	private int status;
	private String picture;
	private String remark;
	private String createDate;
	private Kind kind;
	public Dish(String id, String name, double price, int status, String picture, String remark, String createDate,
			Kind kind) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.picture = picture;
		this.remark = remark;
		this.createDate = createDate;
		this.kind = kind;
	}
	public Dish() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price + ", status=" + status + ", picture=" + picture
				+ ", remark=" + remark + ", createDate=" + createDate + ", kind=" + kind.getName() + "]";
	}
}
