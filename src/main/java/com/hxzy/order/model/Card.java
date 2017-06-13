package com.hxzy.order.model;

public class Card {
	private String id;
	private String name;
	private int per;
	private int level;
	private int status;
	private Member member;
	public Card(String id, String name, int per, int level, Member member) {
		super();
		this.id = id;
		this.level = level;
		this.name = (level==6) ? "青铜卡" : ((level==5) ? "白银卡" : ((level==4) ? "黄金卡" : ((level==3) ? "铂金卡" : ((level==2) ? "钻石卡" : "至尊卡"))));
		this.per = (level==6) ? 9 : ((level==5) ? 8 : ((level==4) ? 7 : ((level==3) ? 6 : ((level==2) ? 5 : 4))));
		this.member = member;
	}
	public Card() {
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
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		this.name = (level==6) ? "青铜卡" : ((level==5) ? "白银卡" : ((level==4) ? "黄金卡" : ((level==3) ? "铂金卡" : ((level==2) ? "钻石卡" : "至尊卡"))));
		this.per = (level==6) ? 9 : ((level==5) ? 8 : ((level==4) ? 7 : ((level==3) ? 6 : ((level==2) ? 5 : 4))));
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", per=" + per + ", level=" + level + ", status=" + status
				+ ", member=" + member.getName() + "]";
	}
}
