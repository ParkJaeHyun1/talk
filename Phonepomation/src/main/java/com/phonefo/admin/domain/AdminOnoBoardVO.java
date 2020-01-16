package com.phonefo.admin.domain;

import java.util.Date;

public class AdminOnoBoardVO {

	private int ono;
	private String userid;
	private String title;
	private String categori;
	private String content;
	private String image_path;
	private Date regdate;
	private String answer;
	private Date answer_regdate;
	
	public AdminOnoBoardVO() {
		
	}
	
	public AdminOnoBoardVO(int ono, String userid, String title, String categori, String content, String image_path,
			Date regdate, String answer, Date answer_regdate) {
		super();
		this.ono = ono;
		this.userid = userid;
		this.title = title;
		this.categori = categori;
		this.content = content;
		this.image_path = image_path;
		this.regdate = regdate;
		this.answer = answer;
		this.answer_regdate = answer_regdate;
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnswer_regdate() {
		return answer_regdate;
	}

	public void setAnswer_regdate(Date answer_regdate) {
		this.answer_regdate = answer_regdate;
	}
	
	
	
}
