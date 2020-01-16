package com.example.wogus.chattingapp.Class;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

/**
 * Created by wogus on 2019-08-06.
 */

public class ChattingRoom implements Serializable{
	private final static int chattingRoomNameLimitLenth = 17;

	private int no;
	private String name;
	private int type;				// 0:자기자신,1:친구랑1대1, 2:그이외 (ex:단톡or 단톡방에서 사람 다나가던가 몇명남아서 친구랑2명이라던가)
	private int unreadMsgNum;
	private int lastReadMsgNo;
	private ArrayList<Message> chattingMsgList;
	private ArrayList<String> chattingMemberList;

	public ChattingRoom(int no, String name, int type, int unreadMsgNum,int lastReadMsgNo, ArrayList<Message> chattingMsgList, ArrayList<String> chattingMemberList) {
		this.no = no;
		this.name = name;
		this.type = type;
		this.lastReadMsgNo = lastReadMsgNo;
		this.unreadMsgNum = unreadMsgNum;
		this.chattingMsgList = chattingMsgList;
		this.chattingMemberList = chattingMemberList;
	}
	public ChattingRoom(int no, int type, ArrayList<String> chattingMemberList) {
		this.no = no;
		this.type = type;
		this.chattingMemberList = chattingMemberList;
		this.chattingMsgList = new ArrayList<Message>();
	}
	public ChattingRoom(int no, int type, String name, int unreadMsgNum, int lastReadMsgNo){
		this.no = no;
		this.type = type;
		this.name = name;
		this.unreadMsgNum = unreadMsgNum;
		this.lastReadMsgNo = lastReadMsgNo;
		this.chattingMemberList = new ArrayList<>();
		this.chattingMsgList = new ArrayList<Message>();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUnreadMsgNum() {
		return unreadMsgNum;
	}
	public int getLastReadMsgNo() {
		return lastReadMsgNo;
	}
	public void setLastReadMsgNo(int lastReadMsgNo) {
		this.lastReadMsgNo = lastReadMsgNo;
	}
	public void setUnreadMsgNum(int unreadMsgNum) {
		this.unreadMsgNum = unreadMsgNum;
	}
	public ArrayList<Message> getChattingMsgList() {
		return chattingMsgList;
	}
	public void setChattingMsgList(ArrayList<Message> chattingMsgList) {
		this.chattingMsgList = chattingMsgList;
	}
	public ArrayList<String> getChattingMemberList() {
		return chattingMemberList;
	}
	public void setChattingMemberList(ArrayList<String> chattingMemberList) {
		this.chattingMemberList = chattingMemberList;
	}

	public String getChattingRoomName(AppInfo appInfo){
		if(name != null)
			return name;

		if(chattingMemberList.size()==1)
			return appInfo.getHmFriend().get(chattingMemberList.get(0)).getNameOrNickName();

		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<chattingMemberList.size() && buffer.length()<=chattingRoomNameLimitLenth;i++) {
			if(!chattingMemberList.get(i).equals(appInfo.getUserID())) {
				if(buffer.length()>0 )
					buffer.append(",");
				if(appInfo.getHmFriend().get(chattingMemberList.get(i))!=null)
					buffer.append(appInfo.getHmFriend().get(chattingMemberList.get(i)).getNameOrNickName());
				else
					buffer.append(appInfo.getHmNoFriendChattingMember().get(chattingMemberList.get(i)).getName());
			}
		}
		return buffer.toString();
	}
	public Bitmap getChattingRoomPicture(AppInfo appInfo, Context context){
		for(int i=0;i<chattingMemberList.size();i++){
			if(!chattingMemberList.get(i).equals(appInfo.getUserID())){
				if(appInfo.getHmFriend().get(chattingMemberList.get(i)) !=null)
					return appInfo.getHmFriend().get(chattingMemberList.get(i)).getPictureBitMap(context);
				else
					return appInfo.getHmNoFriendChattingMember().get(chattingMemberList.get(i)).getPictureBitMap(context);
			}
		}
		return appInfo.getHmFriend().get(chattingMemberList.get(0)).getPictureBitMap(context);
	}



}
