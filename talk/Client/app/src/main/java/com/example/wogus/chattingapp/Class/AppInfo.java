package com.example.wogus.chattingapp.Class;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.wogus.chattingapp.Activity.LoginActivity;
import com.example.wogus.chattingapp.Activity.MainActivity;
import com.example.wogus.chattingapp.Service.ConnectServerService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by wogus on 2019-07-12.
 */

public class AppInfo extends Application implements Serializable {

	static private ClientSocket clientSocket;
	static 	private ComponentName mService;
	private String userID;

	private ArrayList<Integer> chattingRoomNoList;
	private ArrayList<String> friendIDList;
	private HashMap<String, Friend> hmFriend;
	private HashMap<Integer, ChattingRoom> hmChattingRoom;
	private HashMap<String, User> hmNoFriendChattingMember;

	private final String ip = "172.16.81.198";
	//private final String urlIP = "http://"+ip+"/chatApp/";
	private final String urlIP = "http://"+ip+"/";
	private final int port = 10001;
	private final String TAG_TRUE = "TRUE";
	private final String TAG_FALSE = "FALSE";
	private final String TAG_SendMsgDate = "sendMsgDate";
	private final String TAG_ReadUserNum = "readUserNum";
	private final String TAG_CONTENT = "content";
	private final String TAG_SenderID = "senderID";
	private final String TAG_ID ="id";
	private final String TAG_UserID ="userID";
	private final String  TAG_NO = "no";
	private final String TAG_NAME ="name";
	private final String TAG_PHONE ="phone";
	private final String TAG_NICKNAME ="nickName";
	private final String TAG_PICTURE ="picture";
	private final String TAG_PROFILE ="profile";
	private final String TAG_ChattingRoomNO="chattingRoomNo";
	private final String TAG_USER ="user";
	private final String TAG_TYPE ="type";
	private final String TAG_isFriend="isFriend";
	private final String TAG_FRIEND = "friend";
	private final String TAG_CHATTINGROOM ="chattingRoom";
	private final String TAG_InviteMemberList = "inviteMemberList";
	private final String TAG_noFriendChattingMemberList = "chattingMemberNoFriend";
	private final String TAG_ChattingMemberList = "chattingMemberList";
	private final String TAG_ChattingMsgList = "chattingMsgList";
	private final String TAG_ChattingRoomType = "type";
	private final String TAG_ChattingRoomName = "chattingRoomName";
	private final String TAG_unreadMsgNum = "unreadMsgNum";
	private final String TAG_unreadUserNum = "unreadUserNum";
	private final String TAG_LastReadMsgNo = "lastReadMsgNo";
	private final int TAG_ChattingRoomType0 = 0;						// 자기 자신과대화
	private final int TAG_ChattingRoomType1 = 1;						// 친구랑 1대1대화 (단톡방만들어서 애들다나가고 2명남은거는 제외)
	private final int TAG_ChattingRoomType2 = 2;						// 단톡방 (단톡방다나가고 2명남아도 여기임)

	public static ComponentName getmService() {
		return mService;
	}
	public void setmService(ComponentName mService) {
		AppInfo.mService = mService;
	}
	public String getIp() {
		return ip;
	}
	public String getUrlIP() {
		return urlIP;
	}
	public int getPort() {
		return port;
	}
	public String getTAG_TRUE() {
		return TAG_TRUE;
	}
	public String getTAG_FALSE() {
		return TAG_FALSE;
	}
	public String getTAG_SendMsgDate() {
		return TAG_SendMsgDate;
	}
	public String getTAG_ReadUserNum() {
		return TAG_ReadUserNum;
	}
	public String getTAG_CONTENT() {
		return TAG_CONTENT;
	}
	public String getTAG_SenderID() {
		return TAG_SenderID;
	}
	public String getTAG_ID() {
		return TAG_ID;
	}
	public String getTAG_NO() {
		return TAG_NO;
	}
	public String getTAG_NAME() {
		return TAG_NAME;
	}
	public String getTAG_PHONE() {
		return TAG_PHONE;
	}
	public String getTAG_NICKNAME() {
		return TAG_NICKNAME;
	}
	public String getTAG_PICTURE() {
		return TAG_PICTURE;
	}
	public String getTAG_PROFILE() {
		return TAG_PROFILE;
	}
	public String getTAG_ChattingRoomNO() {
		return TAG_ChattingRoomNO;
	}
	public String getTAG_USER() {
		return TAG_USER;
	}
	public String getTAG_TYPE() {
		return TAG_TYPE;
	}
	public String getTAG_isFriend() {
		return TAG_isFriend;
	}
	public String getTAG_FRIEND() {
		return TAG_FRIEND;
	}
	public String getTAG_CHATTINGROOM() {
		return TAG_CHATTINGROOM;
	}
	public String getTAG_InviteMemberList() {
		return TAG_InviteMemberList;
	}
	public String getTAG_noFriendChattingMemberList() {
		return TAG_noFriendChattingMemberList;
	}
	public String getTAG_ChattingMemberList() {
		return TAG_ChattingMemberList;
	}
	public String getTAG_ChattingListMsg() {
		return TAG_ChattingMsgList;
	}
	public String getTAG_ChattingRoomType() {
		return TAG_ChattingRoomType;
	}
	public String getTAG_ChattingRoomName() {
		return TAG_ChattingRoomName;
	}
	public String getTAG_unreadMsgNum() {
		return TAG_unreadMsgNum;
	}
	public String getTAG_unreadUserNum() {
		return TAG_unreadUserNum;
	}
	public String getTAG_LastReadMsgNo() {
		return TAG_LastReadMsgNo;
	}
	public int getTAG_ChattingRoomType0() {
		return TAG_ChattingRoomType0;
	}
	public int getTAG_ChattingRoomType1() {
		return TAG_ChattingRoomType1;
	}
	public int getTAG_ChattingRoomType2() {
		return TAG_ChattingRoomType2;
	}


	public String getUserID() {	return userID;}
	public ClientSocket getClientSocket() {	return clientSocket;}
	public void setClientSocket(ClientSocket clientSocket) {this.clientSocket = clientSocket;}
	public void setUserID(String userID) {this.userID = userID;}
	public ArrayList<Integer> getChattingRoomNoList() {
		return chattingRoomNoList;
	}
	public void setChattingRoomNoList(ArrayList<Integer> chattingRoomNoList) {
		this.chattingRoomNoList = chattingRoomNoList;
	}
	public ArrayList<String> getFriendIDList() {
		return friendIDList;
	}
	public void setFriendIDList(ArrayList<String> friendIDList) {
		this.friendIDList = friendIDList;
	}
	public HashMap<String, Friend> getHmFriend() {
		return hmFriend;
	}
	public void setHmFriend(HashMap<String, Friend> hmFriend) {
		this.hmFriend = hmFriend;
	}
	public HashMap<Integer, ChattingRoom> getHmChattingRoom() {
		return hmChattingRoom;
	}
	public void setHmChattingRoom(HashMap<Integer, ChattingRoom> hmChattingRoom) {
		this.hmChattingRoom = hmChattingRoom;
	}
	public HashMap<String, User> getHmNoFriendChattingMember() {
		return hmNoFriendChattingMember;
	}
	public void setHmNoFriendChattingMember(HashMap<String, User> hmNoFriendChattingMember) {
		this.hmNoFriendChattingMember = hmNoFriendChattingMember;
	}

	public void receiveAllData(){
		receiveFriendList();
		receiveChattingRoomList();
		receiveChattingMemberNoFriendList();
		downloadPictureList();
	}
	public void receiveChattingRoomList(){
		String serverURL = urlIP + "selectChattingList.php";
		String postParameters = "userID=" + getUserID();
		RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
		String result = requestHttpURLConnection.request(serverURL,postParameters);
		jsonToChattingList(result);
	}
	public void receiveFriendList(){
		String serverURL = urlIP + "selectFriendList.php";
		String postParameters = "userID=" + getUserID();
		RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
		String result = requestHttpURLConnection.request(serverURL,postParameters);
		jsonToFriendList(result);
	}
	public void receiveFriend(String friendID){
		String serverURL = urlIP + "selectFriend.php";
		String postParameters = "userID=" + getUserID()+"&friendID="+friendID;
		RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
		String result = requestHttpURLConnection.request(serverURL,postParameters);
		jsonToFriend(result);
	}
	public void receiveChattingMemberNoFriendList(){
		String serverURL = urlIP + "selectChattingMemberNoFriend.php";
		String postParameters = "userID=" + getUserID();
		RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
		String result = requestHttpURLConnection.request(serverURL,postParameters);
		jsonToChattingMemberNoFriendList(result);
	}

	public void jsonToFriendList(String jsonString){

		friendIDList = new ArrayList<String>();
		hmFriend = new HashMap<>();
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			for(int i=0; i<jsonArray.length();i++){
				JSONObject item = jsonArray.getJSONObject(i);
				String id = item.getString(TAG_ID);
				String name = item.getString(TAG_NAME);
				String nickname =item.isNull(TAG_NICKNAME)?null:item.getString(TAG_NICKNAME);
				String phone = item.isNull(TAG_PHONE)?null:item.getString(TAG_PHONE);
				String profile = item.isNull(TAG_PROFILE)?null:item.getString(TAG_PROFILE);
				String picture = item.isNull(TAG_PICTURE)?null:item.getString(TAG_PICTURE);
				int chattingRoomNo = item.isNull(TAG_ChattingRoomNO)?0:item.getInt(TAG_ChattingRoomNO);

				Friend friend = new Friend(id,name,phone,profile,picture,nickname,chattingRoomNo);
				friendIDList.add(id);
				hmFriend.put(id,friend);
			}
		}catch (Exception e){
			Log.d("친구목록불러오기실패", ":"+e);
		}
	}
	public void jsonToChattingList(String jsonString){

		chattingRoomNoList = new ArrayList<Integer>();
		hmChattingRoom = new HashMap<>();
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject item = jsonArray.getJSONObject(i);
				int no = item.getInt(TAG_ChattingRoomNO);
				int type = item.getInt(TAG_ChattingRoomType);
				String name = item.isNull(TAG_ChattingRoomName)?null:item.getString(TAG_ChattingRoomName);
				int unreadMsgNum = item.getInt(TAG_unreadMsgNum);
				int lastReadMsgNo = item.getInt(TAG_LastReadMsgNo);

				JSONArray jsonMemberList = item.getJSONArray(TAG_ChattingMemberList);
				ArrayList<String> chattingMemberList = new ArrayList<>();

				for(int j=0;j<jsonMemberList.length();j++){
					JSONObject JsonMember = jsonMemberList.getJSONObject(j);
					chattingMemberList.add(JsonMember.getString(TAG_UserID));
				}


				JSONArray jsonChattingMsgList = item.getJSONArray(TAG_ChattingMsgList);
				ArrayList<Message> chattingMsgList = new ArrayList<>();
				for(int j=0;j<jsonChattingMsgList.length();j++){
					JSONObject JsonChattingMsg = jsonChattingMsgList.getJSONObject(j);
					int Msgno = JsonChattingMsg.getInt(TAG_NO);
					String Msgtype =JsonChattingMsg.getString(TAG_TYPE);
					int unreadUserNum = JsonChattingMsg.getInt(TAG_unreadUserNum);
					String senderID = JsonChattingMsg.getString(TAG_SenderID);
					String msg = JsonChattingMsg.getString(TAG_CONTENT);
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					cal.setTime(formatter.parse(JsonChattingMsg.getString(TAG_SendMsgDate)));
					chattingMsgList.add(new Message(Msgno,Msgtype,senderID,msg,cal, unreadUserNum));
				}
				if(chattingMsgList.size()>0) {
					hmChattingRoom.put(no, new ChattingRoom(no, name, type, unreadMsgNum, lastReadMsgNo, chattingMsgList, chattingMemberList));
					chattingRoomNoList.add(no);
				}
			}
		}catch (Exception e){
			Log.d("채팅목록불러오기실패", ":"+e);
		}
	}
	public void jsonToChattingMemberNoFriendList(String jsonString){
		hmNoFriendChattingMember = new HashMap<>();
		try {
			JSONArray jsonArray = new JSONArray(jsonString);
			for(int i=0; i<jsonArray.length();i++){
				JSONObject item = jsonArray.getJSONObject(i);
				String id = item.getString(TAG_ID);
				String name = item.getString(TAG_NAME);
				String profile = item.isNull(TAG_PROFILE)?null:item.getString(TAG_PROFILE);
				String picture = item.isNull(TAG_PICTURE)?null:item.getString(TAG_PICTURE);

				User user = new User(id,name,profile,picture);
				hmNoFriendChattingMember.put(id,user);
			}
		}catch (Exception e){
			Log.d("친구아닌채팅멤버목록불러오기실패", ":"+e);
		}
	}
	public void jsonToFriend(String jsonString){
		if(friendIDList==null)
			friendIDList = new ArrayList<String>();
		if(hmFriend == null)
			hmFriend = new HashMap<>();

		try {
			JSONObject jsonFriend = new JSONObject(jsonString);
			String id = jsonFriend.getString(TAG_ID);
			String name = jsonFriend.getString(TAG_NAME);
			String nickname =jsonFriend.isNull(TAG_NICKNAME)?null:jsonFriend.getString(TAG_NICKNAME);
			String phone = jsonFriend.isNull(TAG_PHONE)?null:jsonFriend.getString(TAG_PHONE);
			String profile = jsonFriend.isNull(TAG_PROFILE)?null:jsonFriend.getString(TAG_PROFILE);
			String picture = jsonFriend.isNull(TAG_PICTURE)?null:jsonFriend.getString(TAG_PICTURE);
			int chattingRoomNo = jsonFriend.isNull(TAG_ChattingRoomNO)?0:jsonFriend.getInt(TAG_ChattingRoomNO);
			Friend friend = new Friend(id,name,phone,profile,picture,nickname,chattingRoomNo);
			friendIDList.add(id);
			hmFriend.put(id,friend);
		}catch (Exception e){
			Log.d("단일친구정보불러오기실패", ":"+e);
		}
	}
	public JSONArray getChattingRoomMemberIDListToJsonArray(ArrayList<String> MemberIDList){
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<MemberIDList.size();i++)
			jsonArray.put(MemberIDList.get(i));
		return jsonArray;
	}
	public ChattingRoom getChattingRoomType1(String friendID){
		Friend friend = hmFriend.get(friendID);
		if(friend.getChattingRoomNo()==0){
			ArrayList<String> chattingMemberList = new ArrayList<String>();

			chattingMemberList.add(friend.getId());
			if(!friend.getId().equals(getUserID()))
				chattingMemberList.add(getFriendIDList().get(0));

			int chattingRoomType = friend.getId().equals(getUserID())?getTAG_ChattingRoomType0():getTAG_ChattingRoomType1();
			return new ChattingRoom(friend.getChattingRoomNo(),chattingRoomType,chattingMemberList);
		}
		return getHmChattingRoom().get(friend.getChattingRoomNo());
	}
	public void removeData(){
		if(clientSocket!=null)
			clientSocket.setIs(null);
		clientSocket=null;
		userID=null;

		chattingRoomNoList=null;
		friendIDList=null;
		hmFriend=null;
		hmChattingRoom=null;
		hmNoFriendChattingMember=null;
	}
	public void initClientSocket(){
		clientSocket = new ClientSocket(ip,port);
	}
	public void downloadPictureList() {
		File dir = new File(Environment.getExternalStorageDirectory() + "/chattApp/profile/");
		//상위 디렉토리가 존재하지 않을 경우 생성
		if (!dir.exists()) {
			dir.mkdirs();
		}
		for (String friendID : friendIDList) {
			downloadPicture(friendID);
		}

		for (String friendID : hmNoFriendChattingMember.keySet()) {
			Log.d("친구아이디:", "downloadPictureList: "+friendID);
			downloadPicture(friendID);
		}
	}
	public String downloadPicture(String friendID){

		if(hmFriend.get(friendID)==null || hmFriend.get(friendID).getPicture()==null)
			return getTAG_TRUE();
		String fileUrl = urlIP+"uploads/"+friendID+".jpg";
		String localPath = Environment.getExternalStorageDirectory() + "/chattApp/profile/" + friendID + ".jpg";
		try {
			URL imgUrl = new URL(fileUrl);
			//서버와 접속하는 클라이언트 객체 생성
			HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
			int response = conn.getResponseCode();

			File file = new File(localPath);

			InputStream is = conn.getInputStream();
			OutputStream outStream = new FileOutputStream(file);

			byte[] buf = new byte[1024];
			int len = 0;

			while ((len = is.read(buf)) > 0) {
				outStream.write(buf, 0, len);
			}

			outStream.close();
			is.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			return getTAG_FALSE();
		}
		return getTAG_TRUE();

	}


	public User getUser(String senderID){
		Friend friend = hmFriend.get(senderID);
		if(friend != null)
			return friend;
		return hmNoFriendChattingMember.get(senderID);
	}
}
