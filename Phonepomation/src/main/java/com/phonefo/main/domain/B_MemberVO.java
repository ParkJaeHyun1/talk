package com.phonefo.main.domain;

import java.util.Date;

public class B_MemberVO {

	private String userid;
	private String userpwd;
	private String tel;
	private String email;
	private String businessNum;
	private String companyName;
	private String leader;
	private String address;
	private Date rdate;
	private int root;
	
	public B_MemberVO() {

	}
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(String businessNum) {
		this.businessNum = businessNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	
	
	
}
