package com.hxzy.order.model;

public class Member {
	private String id;
	private String name;
	private double expenditure;//消费
	private double balance;//余额
	private int integral;//积分
	private String phone;//电话
	private Card card;
	public Member(String id, String name, double expenditure, double balance, int integral, String phone, Card card) {
		super();
		this.id = id;
		this.name = name;
		this.expenditure = expenditure;
		this.balance = balance;
		this.integral = integral;
		this.phone = phone;
		this.card = card;
	}
	public Member() {
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
	public double getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", expenditure=" + expenditure + ", balance=" + balance
				+ ", integral=" + integral + ", phone=" + phone + ", card=" + card.getName() + "]";
	}
	
}
