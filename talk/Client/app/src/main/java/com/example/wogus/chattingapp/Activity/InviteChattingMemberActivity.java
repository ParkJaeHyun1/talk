package com.example.wogus.chattingapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Adapter.AdapterInviteChattingRoomMemberList;
import com.example.wogus.chattingapp.Adapter.AdapterSelectChattingRoomMemberList;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-09-10.
 */

public class InviteChattingMemberActivity extends AppCompatActivity{
	AppInfo appInfo;
	int chattingRoomNo;
	ArrayList<String> chattingRoomMemberList;

	EditText etFindUserId;
	TextView tvInviteUserNum;
	Button btInvite;
	ListView lvFriendList;
	RecyclerView rvSelectFriend;

	AdapterInviteChattingRoomMemberList adapterInviteChattingRoomMemberList;
	AdapterSelectChattingRoomMemberList adapterSelectChattingRoomMemberList;
	HashMap<String,Integer> isChecked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_chattingroom);

		init();
		setIsChecked();
		setadapterInviteChattingRoomMemberList();
		setListener();
		setInviteFriendNum();
	}
	private void init(){
		appInfo = (AppInfo) getApplication();
		isChecked = new HashMap<>();
		chattingRoomNo = (int)getIntent().getSerializableExtra(appInfo.getTAG_ChattingRoomNO());
		chattingRoomMemberList = (ArrayList<String>) getIntent().getSerializableExtra(appInfo.getTAG_ChattingMemberList());

		etFindUserId = (EditText) findViewById(R.id.etFindUserId);
		tvInviteUserNum = (TextView) findViewById(R.id.tvInviteUserNum);
		btInvite = (Button) findViewById(R.id.btInvite);
		lvFriendList = (ListView) findViewById(R.id.lvFriendList);
		rvSelectFriend = (RecyclerView) findViewById(R.id.rvSelectFriend);
	}
	private void setIsChecked(){
		if(chattingRoomMemberList==null)
			return;
		for(String memberID: chattingRoomMemberList)
			isChecked.put(memberID, 2);

	}
	private void setadapterInviteChattingRoomMemberList(){
		adapterInviteChattingRoomMemberList = new AdapterInviteChattingRoomMemberList(this,isChecked,selectFriendList(""),this);
		lvFriendList.setAdapter(adapterInviteChattingRoomMemberList);

		adapterSelectChattingRoomMemberList = new AdapterSelectChattingRoomMemberList(this,isChecked,this);
		LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this);
		horizontalLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

		rvSelectFriend.setLayoutManager(horizontalLayoutManager);
		rvSelectFriend.setHasFixedSize(true);
		rvSelectFriend.setAdapter(adapterSelectChattingRoomMemberList);

		adapterInviteChattingRoomMemberList.setAdapterMakeChattingSelectMemberList(adapterSelectChattingRoomMemberList);
		adapterSelectChattingRoomMemberList.setAdapterInviteChattingRoomMemberList(adapterInviteChattingRoomMemberList);
	}
	private void setListener(){
		btInvite.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(InviteChattingMemberActivity.this, ChattingRoomActivity.class);

				ArrayList<String> memberList = adapterSelectChattingRoomMemberList.selectedFriendIDList;
				if(chattingRoomNo != 0){
					ChattingRoom chattingRoom = appInfo.getHmChattingRoom().get(chattingRoomNo);
					if(chattingRoom.getType()!=appInfo.getTAG_ChattingRoomType2()) {
						chattingRoomNo = 0;
						memberList.addAll(chattingRoom.getChattingMemberList());
						memberList.remove(appInfo.getUserID());
					}
				}
				if(chattingRoomNo == 0) {
					memberList.add(appInfo.getUserID());
					if (memberList.size() == 2) {
						intent.putExtra(appInfo.getTAG_ChattingRoomType(), 1);
						if(appInfo.getHmFriend().get(memberList.get(0)).getChattingRoomNo()!=0){
							chattingRoomNo = appInfo.getHmFriend().get(memberList.get(0)).getChattingRoomNo();
							memberList = null;
						}
					}else
						intent.putExtra(appInfo.getTAG_ChattingRoomType(),2);
				}

				intent.putExtra(appInfo.getTAG_ChattingRoomNO(),chattingRoomNo);
				intent.putExtra(appInfo.getTAG_InviteMemberList(),memberList);

				if(ChattingRoomActivity.activity!=null)
					ChattingRoomActivity.activity.finish();

				finish();
				startActivity(intent);
			}
		});
		etFindUserId.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {                        // 채팅메세지 변화 생겼을 시
				adapterInviteChattingRoomMemberList.updateItemList(selectFriendList(s));
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// 입력이 끝났을 때 호출된다.
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// 입력하기 전에 호출된다.
			}
		});
	}
	private ArrayList<String> selectFriendList(CharSequence name){
		ArrayList<String> friendIDList = appInfo.getFriendIDList();
		HashMap<String,Friend> hmFriend = appInfo.getHmFriend();
		ArrayList<String> result = new ArrayList<>();
		for(int i=1;i<friendIDList.size();i++){
			Friend friend = hmFriend.get(friendIDList.get(i));
			if(friend.getNameOrNickName().contains(name))
				result.add(friendIDList.get(i));
		}
		return result;
	}
	public void setInviteFriendNum(){
		int size = adapterSelectChattingRoomMemberList.getItemCount();

		tvInviteUserNum.setText(size+"");
		if(size == 0 ){
			btInvite.setTextColor(Color.parseColor("#cac1c1"));
			btInvite.setEnabled(false);
		}else{
			btInvite.setTextColor(Color.parseColor("#000000"));
			btInvite.setEnabled(true);
		}
	}
}
