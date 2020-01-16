package com.example.wogus.chattingapp.Class;

/**
 * Created by wogus on 2019-07-26.
 */

public class Friend  extends User{
	private String nickname,phone;

	private int chattingRoomNo;

	public Friend(String id,String name,String phone,String profile,String picture,String nickname,int chattingRoomNo){
		super(id,name,profile,picture);
		this.nickname = nickname;
		this.phone = phone;
		this.chattingRoomNo =chattingRoomNo;
	}
	public Friend() {}

	public int getChattingRoomNo() {
		return chattingRoomNo;
	}
	public void setChattingRoomNo(int chattingRoomNo) {
		this.chattingRoomNo = chattingRoomNo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNameOrNickName(){
		return nickname==null?getName():nickname;
	}



}
