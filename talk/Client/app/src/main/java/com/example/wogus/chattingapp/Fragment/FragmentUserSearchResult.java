package com.example.wogus.chattingapp.Fragment;

import android.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.Class.User;
import com.example.wogus.chattingapp.R;


/**
 * Created by wogus on 2019-07-23.
 */

public class FragmentUserSearchResult extends Fragment {
	AppInfo appInfo;

	private User user;
	private boolean isFriend,isSuccess;

	View view;

	ImageView ivUserPicture;
	TextView tvUserName,tvAlreadyFriend,tvMe,tvFriendInsertSuccess;
	Button btFriendInsert;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_user_search_result, container, false);

		init();
		setView();
		setListener();

		return view;
	}

	private void init(){
		appInfo = (AppInfo) getActivity().getApplication();

		user = (User)getArguments().getSerializable(appInfo.getTAG_USER());
		isFriend = getArguments().getBoolean(appInfo.getTAG_isFriend());

		ivUserPicture = (ImageView) view.findViewById(R.id.ivUserPicture);
		tvUserName = (TextView)view.findViewById(R.id.tvUserName);
		btFriendInsert = (Button)view.findViewById(R.id.btFriendInsert);
		tvAlreadyFriend = (TextView)view.findViewById(R.id.tvAlreadyFriend);
		tvMe = (TextView)view.findViewById(R.id.tvMe);
		tvFriendInsertSuccess = (TextView)view.findViewById(R.id.tvFriendInsertSuccess);
	}
	private void setView(){
		tvUserName.setText(user.getName());
		btFriendInsert.setVisibility(isFriend||appInfo.getUserID().equals(user.getId())||isSuccess? View.GONE: View.VISIBLE);
		tvAlreadyFriend.setVisibility(isFriend? View.VISIBLE: View.GONE);
		tvMe.setVisibility(appInfo.getUserID().equals(user.getId())? View.VISIBLE: View.GONE);
		tvFriendInsertSuccess.setVisibility(isSuccess? View.VISIBLE: View.GONE);
		isSuccess = false;
		if(user.getPicture() != null)
			new DownloadPicture().execute(user.getId());
	}
	private void setListener(){
		btFriendInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				InsertFriend task = new InsertFriend();
				task.execute(user.getId());
			}
		});
	}

	private class InsertFriend extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			if(result.equals(appInfo.getTAG_TRUE()))
				isSuccess = true;
			else {
				isSuccess = false;
				Log.d("친구추가실패:", result);
			}
			setView();
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL = appInfo.getUrlIP() + "insertFriend.php";
			String postParameters = "userID=" + appInfo.getUserID() + "&friendID=" + params[0];

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result = requestHttpURLConnection.request(serverURL, postParameters);

			if(result.equals(appInfo.getTAG_TRUE())) {        //php 연결은 메인스레드에서 못해서 여기서 함.
				appInfo.receiveFriend(params[0]);
			}
			return result;
		}
	}
	private class DownloadPicture extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals(appInfo.getTAG_TRUE())) {
				ivUserPicture.setImageBitmap(user.getPictureBitMap(getContext()));
			}else
				Log.d("검색유저 사진다운로드실패",result);
		}

		@Override
		protected String doInBackground(String... params) {
			return appInfo.downloadPicture(params[0]);
		}
	}
}
