package com.example.wogus.chattingapp.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.ClientSocket;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by wogus on 2019-08-07.
 */

public class ConnectServerService extends Service{

	private final String TAG_ID ="id";
	private final int port = 10001;
	private final String ip = "172.16.81.198";
	private final static String TAG_LoginMsg  = "8";
	private final static String TAG_LogoutMsg  = "9";
	private final static String TAG_ChattingMsg ="7";
	private final static String TAG_ReadChattingMsg ="6";
	private final static String TAG_InviteMsg ="5";
	private final static String TAG_EixtChattingRoomMsg ="4";
	private AppInfo appInfo;
	static private ClientSocket clientSocket;
	private String id;

	@Override public void onCreate() {
		Log.d("서비스온크리에이트:","서비스온크리에이트");
		super.onCreate(); // Thread를 이용해 Counter 실행시키기
	}
	@Override public IBinder onBind(Intent intent) {
		return null;
	}

	@Override public void onDestroy() {
		super.onDestroy();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startld){
		Log.d("서비스온스사트커맨드:","서비스온스사트커맨드");

		init(intent);
		Message msg = new Message();
		msg.setType(msg.getTAG_LoginMsg());
		msg.setSenderID(appInfo.getUserID());
		clientSocket.sendMsgToServer(msg.msgToString());
		startReceiveMsgFromServer(this);

		return Service.START_REDELIVER_INTENT;
	}
	public void init(Intent intent){
		appInfo = (AppInfo) getApplication();

		clientSocket = appInfo.getClientSocket();
		id = intent.getStringExtra(TAG_ID);
		if(appInfo !=null)
			appInfo.setClientSocket(clientSocket);

	}
	public void inviteChattingRoomMember(ChattingRoom chattingRoom,String[] memberList){
		for(String member : memberList)
			chattingRoom.getChattingMemberList().add(member);
	}
	public ArrayList<String> getNoFriendChattingMemberList(String[] memberList){
		ArrayList<String> result = new ArrayList<>();
		for(String member : memberList){
			if(appInfo.getHmFriend().get(member)==null)
				result.add(member);
		}
		return result;
	}
	public void startReceiveMsgFromServer(final Context context){
		new Thread(new Runnable() {
			@Override
			public void run() {
				//서버와 접속이 끊길 때까지 무한반복하면서 서버의 메세지 수신
				clientSocket.waitForSocketConnecting();
				DataInputStream is = clientSocket.getIs();
				while(clientSocket.getIs()!=null) {
					String msg;
					try {
						msg = is.readUTF();
						Log.d("메세지수신","메세지수신:"+msg);
						Message chattingMsg = new Message(msg);
						if(appInfo!=null) {
							ChattingRoom chattingRoom = appInfo.getHmChattingRoom().get(chattingMsg.getChattingRoomNo());
							switch (chattingMsg.getType()) {
								case TAG_EixtChattingRoomMsg:
									if(!appInfo.getUserID().equals(chattingMsg.getSenderID())){
										chattingRoom.getChattingMsgList().add(chattingMsg);
										chattingRoom.getChattingMemberList().remove(chattingMsg.getSenderID());
									}
									break;
								case TAG_InviteMsg:
									if (chattingRoom == null) {
										appInfo.receiveChattingRoomList();
										appInfo.receiveChattingMemberNoFriendList();
									} else {
										chattingRoom.getChattingMsgList().add(chattingMsg);
										addChattingRoomMember(chattingRoom,chattingMsg.getChattingMsg().split(chattingMsg.getTAG_InviteUserDivider()));
										if(!appInfo.getUserID().equals(chattingMsg.getSenderID())) {
											appInfo.receiveChattingMemberNoFriendList();
										}
									}
									break;
								case TAG_ChattingMsg:
									if (chattingRoom == null) {
										appInfo.receiveChattingRoomList();
										appInfo.receiveChattingMemberNoFriendList();
										chattingRoom = appInfo.getHmChattingRoom().get(chattingMsg.getChattingRoomNo());
										if (chattingRoom.getType() == 1 && appInfo.getHmFriend().get(chattingMsg.getSenderID()) != null) {
											String serverURL = appInfo.getUrlIP() + "updateFriendChattingRoomNo.php";
											String postParameters = "userID=" + appInfo.getUserID() + "&friendID=" + chattingMsg.getSenderID() + "&chattingRoomNo=" + chattingRoom.getNo();
											appInfo.getHmFriend().get(chattingMsg.getSenderID()).setChattingRoomNo(chattingRoom.getNo());
											RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
											requestHttpURLConnection.request(serverURL, postParameters);
										}
									}else
										chattingRoom.getChattingMsgList().add(chattingMsg);
									if (!appInfo.getUserID().equals(chattingMsg.getSenderID()))
										chattingRoom.setUnreadMsgNum(chattingRoom.getUnreadMsgNum() + 1);
									break;
								case TAG_ReadChattingMsg:
									//Log.d("서버에서 메세지받음","서버에서 메세지받음");
									int pos = chattingRoom.getChattingMsgList().size()-1;
									while(pos>=0){
										Message currentMsg = chattingRoom.getChattingMsgList().get(pos);
										if(currentMsg.getNo()<=chattingMsg.getRecentReadMsgNo() && currentMsg.getNo() > chattingMsg.getLastReadMsgNo()) {
											currentMsg.setUnreadUserNum(currentMsg.getUnreadUserNum() - 1);
											pos--;
										}else
											break;
									}
									break;
							}
						}
						Intent intent = new Intent("chattingMsg");
						intent.putExtra("chattingMsg",chattingMsg);
						LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
						//////////////////////////////////////////////////////////////////////////
					} catch (IOException e) {
						Log.d("서비스끝남:","서비스끝남");
						e.printStackTrace();
						break;
					}
				}//while
				Log.d("서비스끝남:","서비스끝남");
			}//run method...
		}).start();
	}
	public void addChattingRoomMember(ChattingRoom chattingRoom,String[] memberList){
		for(String member:memberList) {
			if(!chattingRoom.getChattingMemberList().contains(member))
				chattingRoom.getChattingMemberList().add(member);
		}
	}
}
