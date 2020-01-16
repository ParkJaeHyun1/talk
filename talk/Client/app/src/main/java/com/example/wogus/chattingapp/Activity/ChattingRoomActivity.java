package com.example.wogus.chattingapp.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Adapter.AdapterChattingMsgList;
import com.example.wogus.chattingapp.Adapter.AdapterDrawerChattingMemberList;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.ClientSocket;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-08-05.
 */

public class ChattingRoomActivity extends AppCompatActivity{
	public static ChattingRoomActivity activity = null;

	private BroadcastReceiver mBroadcastReceiver;
	private final static String TAG_ReadChattingMsg ="6";
	private final static String TAG_SendChattingMsg ="7";
	private final static String TAG_SendInviteMsg ="5";
	private final static String TAG_SendEixtChattingRoomMsg ="4";
	AppInfo appInfo;
	ClientSocket socket;
	ChattingRoom chattingRoom;
	ArrayList<String> inviteMemberList;
	AdapterChattingMsgList adapterChattingMsgList;
	AdapterDrawerChattingMemberList adapterDrawerChattingMemberList;

	private DrawerLayout dlChattingRoom;
	private View llDrawerChattingMemberList;
	TextView tvChattingRoomName,tvChattingRoomMemberNum;
	ImageView ivMenu,ivBack,ivSend,ivInviteNewMember,ivExit;
	EditText etChatting;
	ListView lvMsgList,lvMemberList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chattingroom);

		init();
		sendReadChattingMsgToServer();
		setListener();
		setView();
		setAdapter();
		sendInviteMsg();

	}
	private void sendInviteMsg(){
		if(inviteMemberList==null || chattingRoom.getType()!=appInfo.getTAG_ChattingRoomType2())
			return;
		StringBuffer str = new StringBuffer();
		Message msg = new Message();
		msg.setType(msg.getTAG_InviteChattingMsg());
		msg.setSenderID(appInfo.getUserID());
		for(int i=0;i<inviteMemberList.size();i++) {
			if(!inviteMemberList.get(i).equals(appInfo.getUserID()))
				str.append(inviteMemberList.get(i) + msg.getTAG_InviteUserDivider());
		}
		msg.setChattingMsg(str.toString());

		SendChattingMsgTask task = new SendChattingMsgTask(msg);
		task.execute();
	}
	private void setListener(){
		ivInviteNewMember.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						// runOnUiThread를 추가하고 그 안에 UI작업을 한다.
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								dlChattingRoom.closeDrawer(llDrawerChattingMemberList);
							}
						});
					}
				}).start();
				Intent intent = new Intent(ChattingRoomActivity.this, InviteChattingMemberActivity.class);
				intent.putExtra(appInfo.getTAG_ChattingRoomNO(),chattingRoom.getNo());
				intent.putExtra(appInfo.getTAG_ChattingMemberList(),chattingRoom.getChattingMemberList());
				startActivity(intent);

			}
		});
		ivSend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Message msg = new Message();
				msg.setSenderID(appInfo.getUserID());
				msg.setType(msg.getTAG_SendChattingMsg());
				msg.setChattingMsg(etChatting.getText().toString());
				msg.setUnreadUserNum(chattingRoom.getChattingMemberList().size());

				SendChattingMsgTask task = new SendChattingMsgTask(msg);
				task.execute();
			}
		});
		ivExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());

				// AlertDialog 셋팅
				alertDialogBuilder
						.setMessage("채팅방에서 나가시겠습니까?")
						.setCancelable(false)
						.setPositiveButton("확인",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										ExitChattingRoomTask task = new ExitChattingRoomTask();
										task.execute();
									}
								})
						.setNegativeButton("취소",
								new DialogInterface.OnClickListener() {
									public void onClick(
											DialogInterface dialog, int id) {
										// 다이얼로그를 취소한다
										dialog.cancel();
									}
								});

				// 다이얼로그 생성
				final AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

				alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface arg0) {
						alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#000000"));
						alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
					}
				});

			}
		});
		ivMenu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dlChattingRoom.openDrawer(llDrawerChattingMemberList);
			}
		});
		etChatting.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {	}

			@Override
			public void onTextChanged(CharSequence s, int i, int i1, int i2) {
				if(s.toString().trim().length()!=0)
					ivSend.setVisibility(View.VISIBLE);
				else
					ivSend.setVisibility(View.INVISIBLE);
			}

			@Override
			public void afterTextChanged(Editable editable) {}
		});
	}
	private void sendReadChattingMsgToServer(){
		if(appInfo.getHmChattingRoom().get(chattingRoom.getNo())==null)
			return;

		ArrayList<Message> msgList= chattingRoom.getChattingMsgList();
		Message msg = new Message(TAG_ReadChattingMsg,chattingRoom.getNo(),chattingRoom.getLastReadMsgNo(),msgList.get(msgList.size()-1).getNo());

		if(msg.getLastReadMsgNo()!=0 && msg.getLastReadMsgNo() == msg.getRecentReadMsgNo())
			return;
		socket.sendMsgToServer(msg.msgToString());
		new updateLastReadMsgNoTask().execute();
	}
	private void init(){
		activity = this;
		appInfo = (AppInfo) getApplication();
		socket = appInfo.getClientSocket();

		inviteMemberList = (ArrayList<String>)getIntent().getSerializableExtra(appInfo.getTAG_InviteMemberList());
		int chattingRoomNo = getIntent().getIntExtra(appInfo.getTAG_ChattingRoomNO(),0);
		if(chattingRoomNo!=0 && appInfo.getHmChattingRoom().get(chattingRoomNo)!=null)
			chattingRoom = appInfo.getHmChattingRoom().get(chattingRoomNo);
		else{
			int chattingRoomType =getIntent().getIntExtra(appInfo.getTAG_ChattingRoomType(),0);
			chattingRoom = new ChattingRoom(chattingRoomNo,chattingRoomType,inviteMemberList);
			if(chattingRoomNo!=0)
				inviteMemberList = null;
		}

		adapterChattingMsgList = new AdapterChattingMsgList(this,chattingRoom.getChattingMsgList());
		adapterDrawerChattingMemberList = new AdapterDrawerChattingMemberList(this,chattingRoom.getChattingMemberList());

		dlChattingRoom = (DrawerLayout) findViewById(R.id.dlChattingRoom);
		llDrawerChattingMemberList = (View) findViewById(R.id.llDrawerChattingMemberList);
		lvMsgList = (ListView) findViewById(R.id.lvMsgList);
		lvMemberList = (ListView) findViewById(R.id.lvMemberList);
		tvChattingRoomName = (TextView) findViewById(R.id.tvChattingRoomName);
		tvChattingRoomMemberNum = (TextView)findViewById(R.id.tvChattingRoomMemberNum);
		ivMenu = (ImageView)findViewById(R.id.ivMenu);
		ivBack = (ImageView)findViewById(R.id.ivBack);
		ivSend = (ImageView)findViewById(R.id.ivSend);
		ivExit = (ImageView)findViewById(R.id.ivExit);
		ivInviteNewMember = (ImageView)findViewById(R.id.ivInviteNewMember);
		etChatting = (EditText) findViewById(R.id.etChatting);
		mBroadcastReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Message msg = (Message)intent.getSerializableExtra("chattingMsg");
				if(chattingRoom.getNo() == msg.getChattingRoomNo()) {
					adapterChattingMsgList.updateItemList(chattingRoom.getChattingMsgList());
					adapterDrawerChattingMemberList.updateItemList(chattingRoom.getChattingMemberList());
					setView();
					lvMsgList.setSelection(chattingRoom.getChattingMsgList().size());
					if(msg.getType().equals(TAG_SendChattingMsg))
						sendReadChattingMsgToServer();
				}
			}
		};
	}
	private void setAdapter(){
		lvMemberList.setAdapter(adapterDrawerChattingMemberList);
		lvMsgList.setAdapter(adapterChattingMsgList);
		lvMsgList.setSelection(chattingRoom.getChattingMsgList().size());
	}
	@Override
	public void onBackPressed() {
		if(dlChattingRoom.isDrawerOpen(llDrawerChattingMemberList))
			dlChattingRoom.closeDrawer(llDrawerChattingMemberList);
		else
			super.onBackPressed();
	}
	@Override
	public void onResume(){
		super.onResume();
		LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcastReceiver,new IntentFilter("chattingMsg"));
		adapterChattingMsgList.updateItemList(chattingRoom.getChattingMsgList());
	}
	@Override
	public void onPause(){
		super.onPause();
		LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcastReceiver);
		if(!(chattingRoom==null || chattingRoom.getNo()==0))
			new updateChattingroomUnreadMsgNumTask().execute();
	}
	private void setView(){
		tvChattingRoomName.setText(chattingRoom.getChattingRoomName(appInfo));
		if(chattingRoom.getChattingMemberList().size()<3)
			tvChattingRoomMemberNum.setVisibility(View.GONE);
		else
			tvChattingRoomMemberNum.setText(chattingRoom.getChattingMemberList().size()+"");
	}
	private class updateLastReadMsgNoTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE()))
				chattingRoom.setLastReadMsgNo(chattingRoom.getChattingMsgList().get(chattingRoom.getChattingMsgList().size()-1).getNo());
		}

		@Override
		protected String doInBackground(String... params) {

			String serverURL = appInfo.getUrlIP() + "updateLastReadMsgNo.php";
			String postParameters = "chattingRoomNo=" + chattingRoom.getNo() + "&userID=" +appInfo.getUserID()+"&lastReadMsgNo="+chattingRoom.getChattingMsgList().get(chattingRoom.getChattingMsgList().size()-1).getNo();
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result = requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
	private class SendChattingMsgTask extends AsyncTask<String, Void, String> {
		Message msg;
		SendChattingMsgTask(Message msg){
			this.msg = msg;
		}
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			msg.setChattingRoomNo(chattingRoom.getNo());
			socket.sendMsgToServer(msg.msgToString());
			if(msg.getType() == msg.getTAG_SendChattingMsg())
				etChatting.setText("");
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL, postParameters, result = null;
			RequestHttpURLConnection requestHttpURLConnection;
			int chattingRoomNo = chattingRoom.getNo();
			if (chattingRoomNo == 0) {
				serverURL = appInfo.getUrlIP() + "insertChattingRoomType.php";
				postParameters = "type=" + chattingRoom.getType();

				requestHttpURLConnection = new RequestHttpURLConnection();
				result = requestHttpURLConnection.request(serverURL, postParameters);

				if (result.equals(appInfo.getTAG_FALSE())) {
					Log.d("채팅방 생성실패:",result);
				} else {
					chattingRoomNo = Integer.parseInt(result);
					chattingRoom.setNo(chattingRoomNo);

					if (chattingRoom.getType() == appInfo.getTAG_ChattingRoomType0()) {
						appInfo.getHmFriend().get(appInfo.getUserID()).setChattingRoomNo(chattingRoomNo);
					} else if (chattingRoom.getType() == appInfo.getTAG_ChattingRoomType1()) {
						for (String id : chattingRoom.getChattingMemberList()) {
							if (!id.equals(appInfo.getUserID())) {
								appInfo.getHmFriend().get(id).setChattingRoomNo(chattingRoomNo);
								serverURL = appInfo.getUrlIP() + "updateFriendChattingRoomNo.php";
								postParameters = "userID=" + appInfo.getUserID() + "&friendID=" + id + "&chattingRoomNo=" + chattingRoomNo;
								requestHttpURLConnection = new RequestHttpURLConnection();
								result = requestHttpURLConnection.request(serverURL, postParameters);
							}
						}
					} else {
					}
				}
			}
			if(appInfo.getHmChattingRoom().get(chattingRoomNo)==null && chattingRoomNo!=0) {
				appInfo.getChattingRoomNoList().add(chattingRoomNo);
				appInfo.getHmChattingRoom().put(chattingRoomNo, chattingRoom);
			}
			if (inviteMemberList != null) {
				serverURL = appInfo.getUrlIP() + "insertChattingRoom.php";
				postParameters = "chattingRoomNo=" + chattingRoomNo + "&memberList=" + appInfo.getChattingRoomMemberIDListToJsonArray(inviteMemberList);
				requestHttpURLConnection = new RequestHttpURLConnection();
				result = requestHttpURLConnection.request(serverURL, postParameters);
				inviteMemberList=null;
				Log.d("멤버추가:",result);
			}
			return result;
		}
	}
	private class updateChattingroomUnreadMsgNumTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			appInfo.getHmChattingRoom().get(chattingRoom.getNo()).setUnreadMsgNum(0);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}

		@Override
		protected String doInBackground(String... params) {

			String serverURL = appInfo.getUrlIP() + "updateChattingRoomUnreadMsgNum.php";
			String postParameters = "chattingRoomNo=" + chattingRoom.getNo() + "&userID=" + appInfo.getUserID()+"&unreadMsgNum="+0;
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
	private class ExitChattingRoomTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals("TRUE")){
				if( chattingRoom.getType()==appInfo.getTAG_ChattingRoomType2()) {
					Message msg = new Message();
					msg.setType(msg.getTAG_SendEixtChattingRoomMsg());
					msg.setSenderID(appInfo.getUserID());
					msg.setChattingRoomNo(chattingRoom.getNo());
					appInfo.getClientSocket().sendMsgToServer(msg.msgToString());
				}
				appInfo.getHmChattingRoom().remove(chattingRoom.getNo());
				appInfo.getChattingRoomNoList().remove((Object)chattingRoom.getNo());
				chattingRoom = null;
				Intent intent = new Intent(ChattingRoomActivity.this, MainActivity.class);
				intent.putExtra("Category",2);
				startActivity(intent);
			}else{
				Log.d("메인문방나가기에러:",result);
			}
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL;
			if(chattingRoom.getType()==appInfo.getTAG_ChattingRoomType2())
				serverURL = appInfo.getUrlIP() + "ExitChattingRoom.php";
			else
				serverURL = appInfo.getUrlIP() + "updateChattingRoomJoinDate.php";
			String postParameters = "chattingRoomNo=" + chattingRoom.getNo() + "&userID=" + appInfo.getUserID();
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
}
