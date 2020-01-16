package com.example.wogus.chattingapp.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.Class.User;
import com.example.wogus.chattingapp.Fragment.FragmentUserSearchMyId;
import com.example.wogus.chattingapp.Fragment.FragmentUserSearchNoResult;
import com.example.wogus.chattingapp.Fragment.FragmentUserSearchResult;
import com.example.wogus.chattingapp.R;

import org.json.JSONObject;

/**
 * Created by wogus on 2019-07-22.
 */

public class FriendInsertActivity extends AppCompatActivity {
	private final int TAG_FRAG_MYID = 0;
	private final int TAG_FRAG_RESULT = 1;
	private final int TAG_FRAG_NORESULT = 2;

	private User user;
	private boolean isFriend;

	AppInfo appInfo;

	private Button btFind;
	private ImageView ivBack;
	private EditText etSearchId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_insert);

		init();
		setListener();
		setFrag(TAG_FRAG_MYID);
	}

	protected void init(){
		appInfo = (AppInfo) getApplication();
		user = new User();

		btFind = (Button)findViewById(R.id.btFind);
		ivBack = (ImageView)findViewById(R.id.ivBack);
		etSearchId = (EditText) findViewById(R.id.etSearchId);
		ivBack= (ImageView)findViewById(R.id.ivBack);
	}
	protected void setListener(){
		btFind.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				SelectUserTask task = new SelectUserTask();
				task.execute( etSearchId.getText().toString());
			}
		});
		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		etSearchId.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {	}

			@Override
			public void onTextChanged(CharSequence s, int i, int i1, int i2) {
				if(s.toString().trim().length()!=0) {
					btFind.setTextColor(Color.parseColor("#000000"));
					btFind.setEnabled(true);
				}else {
					btFind.setTextColor(Color.parseColor("#9e9393"));
					btFind.setEnabled(false);
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {}
		});
	}
	protected  void setFrag(int frag_no){
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (frag_no){
			case TAG_FRAG_MYID:
				FragmentUserSearchMyId fragUserSearchMyId = new FragmentUserSearchMyId();
				ft.replace(R.id.flFrag,fragUserSearchMyId);
				ft.commit();
				break;
			case TAG_FRAG_RESULT:
				FragmentUserSearchResult fragUserSearchResult = new FragmentUserSearchResult();

				Bundle bundle = new Bundle();
				bundle.putSerializable(appInfo.getTAG_USER(),user);
				bundle.putBoolean(appInfo.getTAG_isFriend(),isFriend);

				fragUserSearchResult.setArguments(bundle);

				ft.replace(R.id.flFrag,fragUserSearchResult);
				ft.commit();
				break;
			case TAG_FRAG_NORESULT:
				FragmentUserSearchNoResult fragUserSearchNoResult = new FragmentUserSearchNoResult();
				ft.replace(R.id.flFrag,fragUserSearchNoResult);
				ft.commit();
		}
	}
	private class SelectUserTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			showUserInfo(result);
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL = appInfo.getUrlIP() + "selectUser.php";
			String postParameters = "searchID=" + params[0] + "&userID=" + appInfo.getUserID();

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();

			return requestHttpURLConnection.request(serverURL,postParameters);
		}
	}
	private void showUserInfo(String jsonString) {
		try {
			JSONObject jsonObject = new JSONObject(jsonString);

			if(!jsonObject.isNull(appInfo.getTAG_ID())) {
				user.setId(jsonObject.getString(appInfo.getTAG_ID()));
				user.setName(jsonObject.getString(appInfo.getTAG_NAME()));
				user.setPicture(jsonObject.getString(appInfo.getTAG_PICTURE()));
				isFriend = jsonObject.getBoolean(appInfo.getTAG_isFriend());
				setFrag(TAG_FRAG_RESULT);
			}else
				setFrag(TAG_FRAG_NORESULT);
		}catch (Exception e){
			Log.d("에러","에러:"+e.getMessage());
		}
	}
}
