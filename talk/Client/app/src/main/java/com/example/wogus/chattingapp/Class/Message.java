package com.example.wogus.chattingapp.Class;

import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by wogus on 2019-08-14.
 */

public class Message implements Serializable{
	private final static String TAG_LoginMsg  = "8";
	private final static String TAG_LogoutMsg  = "9";
	private final static String TAG_SendChattingMsg ="7";
	private final static String TAG_SendInviteMsg ="5";
	private final static String TAG_SendEixtChattingRoomMsg ="4";
	private final static String TAG_ReadChattingMsg ="6";
	private final static String TAG_MsgDivider = "/";
	private final static String TAG_InviteUserDivider = "&";
	private final static String[] dayOfWeek = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};

	private int no;
	private String type;
	private String senderID;
	private String chattingMsg;
	private Calendar sendMsgDate;
	private int unreadUserNum;
	private int chattingRoomNo;

	private int lastReadMsgNo;
	private int recentReadMsgNo;

	public int getLastReadMsgNo() {
		return lastReadMsgNo;
	}
	public void setLastReadMsgNo(int lastReadMsgNo) {
		this.lastReadMsgNo = lastReadMsgNo;
	}
	public int getRecentReadMsgNo() {
		return recentReadMsgNo;
	}
	public void setRecentReadMsgNo(int recentReadMsgNo) {
		this.recentReadMsgNo = recentReadMsgNo;
	}

	public Message(){};
	public Message(int no,String type,String senderID,String chattingMsg,Calendar sendMsgDate, int unreadUserNum){
		this.no = no;
		this.type = type;
		this.senderID = senderID;
		this.chattingRoomNo = chattingRoomNo;
		this.chattingMsg = chattingMsg;
		this.sendMsgDate = sendMsgDate;
		this.unreadUserNum = unreadUserNum;
	}
	public Message(String msg){
		StringToMsg(msg);
	}
	public Message(String type,int chattingRoomNo,int lastReadMsgNo,int recentReadMsgNo){
		this.type = type;
		this.chattingRoomNo = chattingRoomNo;
		this.lastReadMsgNo = lastReadMsgNo;
		this.recentReadMsgNo = recentReadMsgNo;
	}
	public final int getNo(){return no;}
	public final void setNo(int no){this.no = no;}
	public final String getTAG_LoginMsg() {
		return TAG_LoginMsg;
	}
	public final String getTAG_InviteUserDivider() {
		return TAG_InviteUserDivider;
	}
	public final String getTAG_LogoutMsg() {
		return TAG_LogoutMsg;
	}
	public final String getTAG_SendEixtChattingRoomMsg() {
		return TAG_SendEixtChattingRoomMsg;
	}
	public final String getTAG_SendChattingMsg() {
		return TAG_SendChattingMsg;
	}
	public final String getTAG_InviteChattingMsg() {
		return TAG_SendInviteMsg;
	}
	public final String getTAG_ReadChattingMsg() {
		return TAG_ReadChattingMsg;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public int getChattingRoomNo() {
		return chattingRoomNo;
	}
	public void setChattingRoomNo(int chattingRoomNo) {
		this.chattingRoomNo = chattingRoomNo;
	}
	public String getChattingMsg() {
		return chattingMsg;
	}
	public void setChattingMsg(String chattingMsg) {
		this.chattingMsg = chattingMsg;
	}
	public Calendar getSendMsgDate() {
		return sendMsgDate;
	}
	public void setSendMsgDate(Calendar cal) {
		this.sendMsgDate = cal;
	}
	public int getUnreadUserNum() {
		return unreadUserNum;
	}
	public void setUnreadUserNum(int unreadUserNum) {
		this.unreadUserNum = unreadUserNum;
	}

	public String msgToString(){
		StringBuffer sendMsg = new StringBuffer();
		sendMsg.append(type);
		sendMsg.append(TAG_MsgDivider);

		switch (type){
			case TAG_LoginMsg:
				sendMsg.append(senderID);
				break;
			case TAG_LogoutMsg:
				break;
			case TAG_SendEixtChattingRoomMsg:
			case TAG_SendInviteMsg:
			case TAG_SendChattingMsg:
				sendMsg.append(senderID);
				sendMsg.append(TAG_MsgDivider);
				sendMsg.append(chattingRoomNo);
				sendMsg.append(TAG_MsgDivider);
				sendMsg.append(chattingMsg);
				sendMsg.append(TAG_MsgDivider);
				sendMsg.append(unreadUserNum);
				if(sendMsgDate != null) {
					sendMsg.append(TAG_MsgDivider);
					sendMsg.append(sendMsgDate.get(Calendar.YEAR));
					sendMsg.append(TAG_MsgDivider);
					sendMsg.append(sendMsgDate.get(Calendar.MONTH));
					sendMsg.append(TAG_MsgDivider);
					sendMsg.append(sendMsgDate.get(Calendar.DATE));
					sendMsg.append(TAG_MsgDivider);
					sendMsg.append(sendMsgDate.get(Calendar.HOUR));
					sendMsg.append(TAG_MsgDivider);
					sendMsg.append(sendMsgDate.get(Calendar.MINUTE));
				}
				break;
			case TAG_ReadChattingMsg:
				sendMsg.append(chattingRoomNo);
				sendMsg.append(TAG_MsgDivider);
				sendMsg.append(lastReadMsgNo);
				sendMsg.append(TAG_MsgDivider);
				sendMsg.append(recentReadMsgNo);
				break;
		}
		sendMsg.append(TAG_MsgDivider);
		return sendMsg.toString();
	}
	public void StringToMsg(String receiveMsg){
		type = receiveMsg.substring(0,receiveMsg.indexOf(TAG_MsgDivider));
		String buffer = receiveMsg.substring(receiveMsg.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());
		switch (type){
			case TAG_SendEixtChattingRoomMsg:
			case TAG_SendInviteMsg:
			case TAG_SendChattingMsg:
				sendMsgDate = Calendar.getInstance();

				senderID = buffer.substring(0,buffer.indexOf(TAG_MsgDivider));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				chattingRoomNo = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				chattingMsg = buffer.substring(0,buffer.indexOf(TAG_MsgDivider));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				unreadUserNum = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				no = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				if(sendMsgDate != null) {
					sendMsgDate.set(Calendar.YEAR, Integer.parseInt(buffer.substring(0, buffer.indexOf(TAG_MsgDivider))));
					buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider) + TAG_MsgDivider.length());

					sendMsgDate.set(Calendar.MONTH, Integer.parseInt(buffer.substring(0, buffer.indexOf(TAG_MsgDivider))));
					buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider) + TAG_MsgDivider.length());

					sendMsgDate.set(Calendar.DATE, Integer.parseInt(buffer.substring(0, buffer.indexOf(TAG_MsgDivider))));
					buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider) + TAG_MsgDivider.length());

					sendMsgDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(buffer.substring(0, buffer.indexOf(TAG_MsgDivider))));
					buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider) + TAG_MsgDivider.length());

					sendMsgDate.set(Calendar.MINUTE, Integer.parseInt(buffer.substring(0, buffer.indexOf(TAG_MsgDivider))));
				}
				//buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());
				break;
			case TAG_ReadChattingMsg:
				chattingRoomNo = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				lastReadMsgNo = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

				recentReadMsgNo = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
				break;
		}
	}
	public String calToString(Calendar nowCal){

		if(nowCal.get(Calendar.YEAR)== sendMsgDate.get(Calendar.YEAR) &&nowCal.get(Calendar.MONTH)== sendMsgDate.get(Calendar.MONTH)&&nowCal.get(Calendar.DATE)== sendMsgDate.get(Calendar.DATE))
			return calToStringTime();
		else if(nowCal.get(Calendar.YEAR)== sendMsgDate.get(Calendar.YEAR) &&nowCal.get(Calendar.MONTH)== sendMsgDate.get(Calendar.MONTH)&&nowCal.get(Calendar.DATE)-1== sendMsgDate.get(Calendar.DATE))
			return "어제";
		else if(nowCal.get(Calendar.YEAR) == sendMsgDate.get(Calendar.YEAR))
			return (sendMsgDate.get(Calendar.MONTH)+1)+"월 "+sendMsgDate.get(Calendar.DATE)+"일";
		else
			return sendMsgDate.get(Calendar.YEAR)+"-"+(sendMsgDate.get(Calendar.MONTH)+1)+"-"+sendMsgDate.get(Calendar.DATE);
	}
	public String calToStringTime(){
		String result;
		if(sendMsgDate.get(Calendar.AM_PM)==Calendar.AM)
			result="오전 ";
		else
			result ="오후 ";
		if(sendMsgDate.get(Calendar.HOUR)==0)
			result+=(12+":");
		else if(sendMsgDate.get(Calendar.HOUR)<10)
			result+=("0"+sendMsgDate.get(Calendar.HOUR)+":");
		else
			result+=(sendMsgDate.get(Calendar.HOUR)+":");
		return result+(sendMsgDate.get(Calendar.MINUTE)<10?"0"+sendMsgDate.get(Calendar.MINUTE):sendMsgDate.get(Calendar.MINUTE));
	}
	public String calToStringYearDate(){
		return sendMsgDate.get(Calendar.YEAR)+"년 "+(sendMsgDate.get(Calendar.MONTH)+1)+"월 "+sendMsgDate.get(Calendar.DATE)+"일 "+dayOfWeek[sendMsgDate.get(Calendar.DAY_OF_WEEK)-1];
	}
	public boolean compareMsgDate(Calendar cal){
		if(cal.get(Calendar.YEAR) != sendMsgDate.get(Calendar.YEAR) || cal.get(Calendar.MONTH) != sendMsgDate.get(Calendar.MONTH) || cal.get(Calendar.DATE) != sendMsgDate.get(Calendar.DATE)  )
			return true;
		return false;
	}
}
