package com.phonefo.main.domain;

import java.util.Date;

public class MemberVO {
	
	private String userid;
	private String userpwd;
	private String username;
	private String birth;
	private Date rdate;
	private String gender;
	private String email;
	private String tel;
	private int root;
	private int status;
	
	
	public MemberVO() {
		
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}




	public Date getRdate() {
		return rdate;
	}


	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getRoot() {
		return root;
	}


	public void setRoot(int root) {
		this.root = root;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
