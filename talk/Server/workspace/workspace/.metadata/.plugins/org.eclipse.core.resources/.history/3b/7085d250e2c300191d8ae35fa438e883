package Main;
import java.util.Calendar;

/**
 * Created by wogus on 2019-08-14.
 */

public class Message{
	private final static String TAG_LoginMsg  = "8";
	private final static String TAG_LogoutMsg  = "9";
	private final static String TAG_ChattingMsg ="7";
	private final static String TAG_ReadChattingMsg ="6";
	private final static String TAG_InviteMsg ="5";
	private final static String TAG_EixtChattingRoomMsg ="4";
	private final static String TAG_MsgDivider = "/";
	private final static String TAG_InviteUserDivider = "&";
	private int no;
	private String type;
	private String senderID;
	private int chattingRoomNo;
	private int unreadUserNum;
	private String content;
	private Calendar cal;

	private int lastReadMsgNo;
	private int recentReadMsgNo;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUnreadUserNum() {
		return unreadUserNum;
	}
	public void setUnreadUserNum(int unreadUserNum) {
		this.unreadUserNum = unreadUserNum;
	}
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
	public Message(String type,String senderID){
		this.type = type;
		this.senderID = senderID;
	}
	public final static String getTAG_LoginMsg() {
		return TAG_LoginMsg;
	}
	public final String getTAG_EixtChattingRoomMsg() {
		return TAG_EixtChattingRoomMsg;
	}
	public final String getTAG_LogoutMsg() {
		return TAG_LogoutMsg;
	}
	public final String get() {
		return TAG_ChattingMsg;
	}
	public final String getTAG_InviteChattingMsg() {
		return TAG_ChattingMsg;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public String msgToString(){
		StringBuffer sendMsg = new StringBuffer();

		sendMsg.append(type);
		sendMsg.append(TAG_MsgDivider);

		switch (type){
		case TAG_EixtChattingRoomMsg:
		case TAG_InviteMsg:
		case TAG_ChattingMsg:
			sendMsg.append(senderID);
			sendMsg.append(TAG_MsgDivider);
			sendMsg.append(chattingRoomNo);
			sendMsg.append(TAG_MsgDivider);
			sendMsg.append(content);
			sendMsg.append(TAG_MsgDivider);
			sendMsg.append(unreadUserNum);
			sendMsg.append(TAG_MsgDivider);
			sendMsg.append(no);
			sendMsg.append(TAG_MsgDivider);
			if(cal != null){
				sendMsg.append(cal.get(Calendar.YEAR)+TAG_MsgDivider);
				sendMsg.append(cal.get(Calendar.MONTH)+TAG_MsgDivider);
				sendMsg.append(cal.get(Calendar.DATE)+TAG_MsgDivider);
				sendMsg.append(cal.get(Calendar.HOUR_OF_DAY)+TAG_MsgDivider);
				sendMsg.append(cal.get(Calendar.MINUTE));
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
		case TAG_LoginMsg:
			senderID = buffer.substring(0,buffer.indexOf(TAG_MsgDivider));
			break;
		case TAG_EixtChattingRoomMsg:
		case TAG_InviteMsg:
		case TAG_ChattingMsg:
			senderID = buffer.substring(0,buffer.indexOf(TAG_MsgDivider));
			buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

			chattingRoomNo = Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
			buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

			content = buffer.substring(0,buffer.indexOf(TAG_MsgDivider));
			buffer = buffer.substring(buffer.indexOf(TAG_MsgDivider)+TAG_MsgDivider.length());

			unreadUserNum =  Integer.parseInt(buffer.substring(0,buffer.indexOf(TAG_MsgDivider)));
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
	public String calToString(){
		StringBuffer result = new StringBuffer();
		result.append(cal.get(Calendar.YEAR)+TAG_MsgDivider);
		result.append(cal.get(Calendar.MONTH)+TAG_MsgDivider);
		result.append(cal.get(Calendar.DATE)+TAG_MsgDivider);
		result.append(cal.get(Calendar.HOUR_OF_DAY)+TAG_MsgDivider);
		result.append(cal.get(Calendar.MINUTE)+TAG_MsgDivider);
		return result.toString();
	}


}
