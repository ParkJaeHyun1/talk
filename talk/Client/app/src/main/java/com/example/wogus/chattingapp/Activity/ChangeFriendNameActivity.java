package com.example.wogus.chattingapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-09-21.
 */

public class ChangeFriendNameActivity extends AppCompatActivity {
	AppInfo appInfo;
	Friend friend;

	ImageView ivBack;
	Button btSubmit;
	EditText etFriendName;
	TextView tvTextNum,tvFriendNameByFriend;
	LinearLayout llFriendInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_friend_name);

		init();
		setView();
		setListtener();
	}
	private void setListtener(){
		btSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new updateFriendNickNameTask().execute();
			}
		});
		etFriendName.addTextChangedListener(new TextWatcher() {                                                // 채팅메세지에 변화 생겼을시
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {                      // 채팅메세지 변화 생겼을 시
				if(s.toString().trim().length()!=0) {
					btSubmit.setTextColor(Color.parseColor("#000000"));
					btSubmit.setEnabled(true);
				}else {
					btSubmit.setTextColor(Color.parseColor("#9e9393"));
					btSubmit.setEnabled(false);
				}tvTextNum.setText(s.length()+"/10");
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
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
	}
	private void setView(){
		tvFriendNameByFriend.setText(friend.getName());
		etFriendName.setHint(friend.getNameOrNickName());
		if(appInfo.getUserID().equals(friend.getId()))
			llFriendInfo.setVisibility(View.GONE);
	}
	private void init(){
		appInfo = (AppInfo) getApplication();
		friend = appInfo.getHmFriend().get(getIntent().getSerializableExtra(appInfo.getTAG_ID()));

		llFriendInfo = (LinearLayout) findViewById(R.id.llFriendInfo);
		ivBack = (ImageView) findViewById(R.id.ivBack);
		btSubmit = (Button) findViewById(R.id.btSubmit);
		etFriendName = (EditText) findViewById(R.id.etFriendName);
		tvTextNum = (TextView) findViewById(R.id.tvTextNum);
		tvFriendNameByFriend = (TextView) findViewById(R.id.tvFriendNameByFriend);
	}
	private class updateFriendNickNameTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE()))
				friend.setNickname(etFriendName.getText().toString());
			else
				Log.d("닉네임변경에러:",result);

			Intent intent = new Intent(ChangeFriendNameActivity.this, FriendInfoActivity.class);
			intent.putExtra(appInfo.getTAG_ID(),friend.getId());
			finish();
			startActivity(intent);
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL,postParameters;
			if(!appInfo.getUserID().equals(friend.getId())) {
				serverURL = appInfo.getUrlIP() + "updateFriendNickName.php";
				postParameters = "friendNickName=" + etFriendName.getText().toString() + "&userID=" + appInfo.getUserID() + "&friendID=" + friend.getId();
			}else{
				serverURL = appInfo.getUrlIP() + "updateUserName.php";
				postParameters = "name=" + etFriendName.getText().toString() + "&userID=" + appInfo.getUserID() ;
			}
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
}
