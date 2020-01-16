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
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-09-23.
 */

public class ChangeChattingroomNameActivity  extends AppCompatActivity{
	AppInfo appInfo;
	ChattingRoom chattingRoom;

	ImageView ivBack;
	Button btSubmit;
	EditText etChattingRoomName;
	TextView tvTextNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_chattingroom_name);

		init();
		setView();
		setListtener();
	}
	private void setView(){
		etChattingRoomName.setHint(chattingRoom.getChattingRoomName(appInfo));
	}
	private void setListtener(){
		btSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new updateChattingRoomNameTask().execute();
			}
		});
		etChattingRoomName.addTextChangedListener(new TextWatcher() {                                                // 채팅메세지에 변화 생겼을시
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
	}
	private void init(){
		appInfo = (AppInfo) getApplication();
		chattingRoom = appInfo.getHmChattingRoom().get(getIntent().getSerializableExtra(appInfo.getTAG_ChattingRoomNO()));

		ivBack = (ImageView) findViewById(R.id.ivBack);
		btSubmit = (Button) findViewById(R.id.btSubmit);
		etChattingRoomName = (EditText) findViewById(R.id.etChattingRoomName);
		tvTextNum = (TextView) findViewById(R.id.tvTextNum);
	}
	private class updateChattingRoomNameTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE()))
				chattingRoom.setName(etChattingRoomName.getText().toString());
			else
				Log.d("닉네임변경에러:",result);

			finish();
		}

		@Override
		protected String doInBackground(String... params) {

			String	serverURL = appInfo.getUrlIP() + "updateChattingRoomName.php";
			String	postParameters = "chattingRoomName=" + etChattingRoomName.getText().toString() + "&userID=" + appInfo.getUserID() + "&chattingRoomNo=" + chattingRoom.getNo();

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
}
