package com.example.wogus.chattingapp.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;
import com.example.wogus.chattingapp.Service.ConnectServerService;

public class LoginActivity extends AppCompatActivity {

	private AppInfo appInfo;  				//현재 앱에 로
	private Button btLogin,btMemberJoin;
	private EditText etID,etPassword;
	TextView tvLoginFailed;
	ProgressBar pbLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
		setListener();
	}
	protected  void init(){
		appInfo = (AppInfo) getApplication();
		stopService();
		btLogin = (Button) findViewById(R.id.btLogin);
		btMemberJoin = (Button) findViewById(R.id.btMemberJoin);
		etID=(EditText) findViewById(R.id.etLoginId);
		etPassword=(EditText)findViewById(R.id.etLoginPassword);
		tvLoginFailed =(TextView) findViewById(R.id.tvLoginFailed);
		pbLogin = (ProgressBar) findViewById(R.id.pbLogin);
	}
	public void stopService(){
		Log.d("스톱서비스:",appInfo.getmService()+"");
		if(appInfo.getClientSocket()==null)
			return;
		Message msg = new Message();
		msg.setType(msg.getTAG_LogoutMsg());;
		appInfo.getClientSocket().sendMsgToServer(msg.msgToString());
		try {
			appInfo.getClientSocket().getSocket().close();
		}catch (Exception e){
			Log.d("소켓끊기에러:",e.toString());
		}
		appInfo.removeData();
	}
	public void setListener(){
		etID.addTextChangedListener(textWatcher);
		etPassword.addTextChangedListener(textWatcher);
		btLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				LoginTask task = new LoginTask();
				task.execute( etID.getText().toString(), etPassword.getText().toString());
			}
		});
		btMemberJoin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginActivity.this, MemberJoinActivity.class);
				startActivity(intent);
			}
		});
	}
	private void disableEnableControls(ViewGroup vg,boolean flag){
		for (int i = 0; i < vg.getChildCount(); i++){
			View child = vg.getChildAt(i);
			child.setEnabled(flag);
			if (child instanceof ViewGroup){
				disableEnableControls((ViewGroup)child,false);
			}
		}
	}
	TextWatcher textWatcher=new TextWatcher() {													// 채팅메세지에 변화 생겼을시
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {						// 채팅메세지 변화 생겼을 시
			if(etID.getText().toString().replaceAll(" ","").length() !=0 && etPassword.getText().toString().length()!=0) {                // 전송버튼 안보여줌
				btLogin.setTextColor(Color.parseColor("#ffffff"));
				btLogin.setEnabled(true);
			}else {
				btLogin.setTextColor(Color.parseColor("#8e7974"));
				btLogin.setEnabled(false);
			}
		}
		@Override
		public void afterTextChanged(Editable arg0) {
			// 입력이 끝났을 때 호출된다.
		}
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			// 입력하기 전에 호출된다.
		}
	};

	private class LoginTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			disableEnableControls((ViewGroup) pbLogin.getParent(),false);
			pbLogin.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			try {
				Thread.sleep(300);
			}catch (Exception e){}

			pbLogin.setVisibility(View.INVISIBLE);
			disableEnableControls((ViewGroup) pbLogin.getParent(),true);
			if(result == null) {
				tvLoginFailed.setVisibility(View.VISIBLE);
				tvLoginFailed.setText("네트워크에 연결되어있지 않습니다.");        // RequestHttpURLConnection 실패, 네트워크연결안될때인가?
			}else if(result.equals(appInfo.getTAG_TRUE())) {
				appInfo.initClientSocket();
				Intent serviceIntent = new Intent(LoginActivity.this, ConnectServerService.class);
				serviceIntent.putExtra(appInfo.getTAG_ID(),appInfo.getUserID());
				appInfo.setmService(startService(serviceIntent));
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}else if (result.equals(appInfo.getTAG_FALSE())) {
				tvLoginFailed.setVisibility(View.VISIBLE);
				tvLoginFailed.setText("아이디 혹은 비밀번호가 잘못되었습니다.");
			}else{
				Log.d("로그인실패:",result);				// result가 true,false,null 3개올수있는데 이럴땐 어떨때지?
			}
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL = appInfo.getUrlIP() + "login.php";
			String postParameters = "id=" + params[0] + "&password=" + params[1];

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result = requestHttpURLConnection.request(serverURL,postParameters);
			if(result == null)
				return result;
			if(result.equals(appInfo.getTAG_TRUE())) {
				appInfo.setUserID(etID.getText().toString());
				appInfo.receiveAllData();
			}
			return result;
		}
	}
}


