package com.example.wogus.chattingapp.Activity;

import android.content.Intent;
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
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-10-31.
 */

public class ChangeProfileActivity extends AppCompatActivity{
	AppInfo appInfo;
	ImageView ivBack;
	Button btSubmit;
	EditText etProfile;
	TextView tvTextNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_profile);

		init();
		setView();
		setListtener();
	}
	private void setView(){
		String profile =appInfo.getHmFriend().get(appInfo.getUserID()).getProfile();
		etProfile.setText(profile == null?"":profile);
	}
	private void init(){
		appInfo = (AppInfo) getApplication();

		ivBack = (ImageView) findViewById(R.id.ivBack);
		btSubmit = (Button) findViewById(R.id.btSubmit);
		etProfile = (EditText) findViewById(R.id.etProfile);
		tvTextNum = (TextView) findViewById(R.id.tvTextNum);
	}
	private void setListtener(){
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		btSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new updateProfileTask().execute();
			}
		});
		etProfile.addTextChangedListener(new TextWatcher() {                                                // 채팅메세지에 변화 생겼을시
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {                      // 채팅메세지 변화 생겼을 시
				tvTextNum.setText(s.length()+"/20");
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
	private class updateProfileTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE()))
				appInfo.getHmFriend().get(appInfo.getUserID()).setProfile(etProfile.getText().toString());
			else
				Log.d("프로필변경:",result);

			Intent intent = new Intent(ChangeProfileActivity.this, FriendInfoActivity.class);
			intent.putExtra(appInfo.getTAG_ID(),appInfo.getUserID());
			finish();
			startActivity(intent);
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL,postParameters;
				serverURL = appInfo.getUrlIP() + "updateProfile.php";
				postParameters = "profile=" + etProfile.getText().toString() + "&userID=" + appInfo.getUserID() ;
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
}
