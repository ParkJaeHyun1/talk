package com.example.wogus.chattingapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;

import java.util.regex.Pattern;

/**
 * Created by wogus on 2019-10-10.
 */

public class MemberJoinActivity extends AppCompatActivity{
	AppInfo appInfo;
	boolean[] isPassed;
	EditText etId, etPassword, etPasswordCheck, etName, etPhoneNumber;
	TextView tvId, tvPassword, tvPasswordCheck, tvPhoneNumber, tvName, tvJoinMember;
	Button  btJoinMember;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_join);

		init();
		setListener();
	}

	public void init(){
		appInfo = (AppInfo) getApplication();
		isPassed = new boolean[5];
		etId = (EditText) findViewById(R.id.etId);
		etPassword = (EditText)findViewById(R.id.etPassword);
		etPasswordCheck = (EditText)findViewById(R.id.etPasswordCheck);
		etName = (EditText)findViewById(R.id.etName);
		etPhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);

		tvId = (TextView)findViewById(R.id.tvId);
		tvPassword = (TextView)findViewById(R.id.tvPassword);
		tvPasswordCheck = (TextView)findViewById(R.id.tvPasswordCheck);
		tvPhoneNumber = (TextView)findViewById(R.id.tvPhoneNumber);
		tvName = (TextView)findViewById(R.id.tvName);

		tvJoinMember = (TextView)findViewById(R.id.tvJoinMember);

		btJoinMember = (Button)findViewById(R.id.btJoinMember);
	}
	public void setListener() {
		btJoinMember.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (isPassed[0] == true && isPassed[1] == true && isPassed[2] == true && isPassed[3] == true && isPassed[4] == true ) {
					new MemberJoinTask().execute();                                                                                      // 액티비티 실행
				} else
					tvJoinMember.setVisibility(View.VISIBLE);
			}
		});

		etId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				if(b)
					return;
				String s = etId.getText().toString();
				String regExp_symbol = "^[a-z0-9]*$";
				Pattern pattern_symbol = Pattern.compile(regExp_symbol);

				tvId.setVisibility(View.VISIBLE);
				if (!pattern_symbol.matcher(s).find() || s.length() < 5 || s.length() > 15) {
					tvId.setText("5~15자의 영문 소문자와 숫자만 사용 가능합니다.");
					tvId.setTextColor(Color.RED);
					isPassed[0] = false;
				} else{
					new CheckIDTask().execute();
				}
			}
		});
		etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				if(b)
					return;
				String s = etPassword.getText().toString();
				String regExp_symbol = "^[A-Za-z0-9]{8,15}$";
				Pattern pattern_symbol = Pattern.compile(regExp_symbol);

				tvPassword.setVisibility(View.VISIBLE);
				if (pattern_symbol.matcher(s).find()) {
					tvPassword.setText("사용할 수 있는 비밀번호입니다.");
					tvPassword.setTextColor(Color.GREEN);
					isPassed[1] = true;
				} else {
					tvPassword.setText("8~15자의 영문,숫자를 사용하세요.");
					tvPassword.setTextColor(Color.RED);
					isPassed[1] = false;
				}
				PasswordCheck();
			}
		});
		etPasswordCheck.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				if(b)
					return;
				PasswordCheck();
			}
		});

		etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				if(b)
					return;
				if (etName.getText().toString().length() > 0) {
					tvName.setVisibility(View.VISIBLE);
					tvName.setTextColor(Color.GREEN);
					tvName.setText("알맞은 이름 형태입니다.");
					isPassed[3] = true;
				} else {
					tvName.setVisibility(View.VISIBLE);
					tvName.setText("이름을 입력하세요.");
					tvName.setTextColor(Color.RED);
					isPassed[3] = false;
				}
			}
		});
		etPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View view, boolean b) {
				if(b)
					return;
				String s = etPhoneNumber.getText().toString();
				String regExp_symbol = "01[016789][0-9]{8}";
				Pattern pattern_symbol = Pattern.compile(regExp_symbol);

				tvPhoneNumber.setVisibility(View.VISIBLE);
				if (pattern_symbol.matcher(s).find()) {
					tvPhoneNumber.setText("올바른 핸드폰 번호 형식입니다.");
					tvPhoneNumber.setTextColor(Color.GREEN);
					isPassed[4] = true;
				} else {
					tvPhoneNumber.setText("핸드폰 번호 형식을 확인해주세요.");
					tvPhoneNumber.setTextColor(Color.RED);
					isPassed[4] = false;
				}
			}
		});
	}
	private class CheckIDTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE())){
				tvId.setText("사용할 수 있는 아이디입니다.");
				tvId.setTextColor(Color.GREEN);
				isPassed[0] = true;
			}
			else if(result.equals(appInfo.getTAG_FALSE())){
				tvId.setText("이미 사용중인 아이디입니다.");
				tvId.setTextColor(Color.RED);
				isPassed[0] = false;
			}else
				Log.d("아이디검사에러",result);
		}

		@Override
		protected String doInBackground(String... params) {

			String	serverURL = appInfo.getUrlIP() + "checkID.php";
			String	postParameters = "id=" + etId.getText().toString();

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
	private class MemberJoinTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE())){
				finish();
				Intent intent = new Intent(MemberJoinActivity.this, LoginActivity.class);
				startActivity(intent);
			}else
				Log.d("회원가입에러",result);
		}

		@Override
		protected String doInBackground(String... params) {

			String	serverURL = appInfo.getUrlIP() + "memberJoin.php";
			String	postParameters = "id=" + etId.getText().toString()+"&password="+etPassword.getText().toString()+"&name="+etName.getText().toString()+"&phone="+etPhoneNumber.getText().toString();

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
	public void PasswordCheck(){
		String s = etPasswordCheck.getText().toString();
		if (etPassword.getText().toString().length() > 0) {
			tvPasswordCheck.setVisibility(View.VISIBLE);
			if (!etPassword.getText().toString().equals(s.toString())) {
				tvPasswordCheck.setText("비밀번호가 일치하지 않습니다.");
				tvPasswordCheck.setTextColor(Color.RED);
				isPassed[2] = false;
			} else {
				tvPasswordCheck.setText("사용할 수 있는 비밀번호입니다.");
				tvPasswordCheck.setTextColor(Color.GREEN);
				isPassed[2] = true;
			}
		}
	}
}
