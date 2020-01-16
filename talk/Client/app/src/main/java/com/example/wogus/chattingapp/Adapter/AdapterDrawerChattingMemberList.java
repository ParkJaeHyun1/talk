package com.example.wogus.chattingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.Class.User;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-09-21.
 */

public class AdapterDrawerChattingMemberList extends BaseAdapter{
	private LayoutInflater inflater;
	private ArrayList<String> memberList;
	private AppInfo appInfo;
	private HashMap<String, Friend> hmFriend;
	private HashMap<String, User> hmNoFriendChattingMember;
	private Context context;
	public AdapterDrawerChattingMemberList(Context context, ArrayList<String> memberList){
		appInfo = (AppInfo)((Activity)context).getApplication();
		hmFriend = appInfo.getHmFriend();
		hmNoFriendChattingMember = appInfo.getHmNoFriendChattingMember();
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.memberList = memberList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return memberList.size();
	}

	@Override
	public String getItem(int position) {
		return memberList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = inflater.inflate(R.layout.listitem_drawer_chattingroom_memberlist, parent, false);				// listview_friend.xml 생성

			HolderAdapterDrawerChattingMemberList holder = new HolderAdapterDrawerChattingMemberList();

			holder.ivMemberPicture = (ImageView) convertView.findViewById(R.id.ivMemberPicture);										// listview_friend.xml에 있는 ivFriendPicture가져옴
			holder.tvMemberName = (TextView) convertView.findViewById(R.id.tvMemberName);											// listview_friend.xml에 있는 tvFriendName가져옴
			holder.btInsertFriend = (Button) convertView.findViewById(R.id.btInsertFriend);

			convertView.setTag(holder);
		}
		HolderAdapterDrawerChattingMemberList holder = (HolderAdapterDrawerChattingMemberList)convertView.getTag();
		final String memberID = getItem(position);

		holder.ivMemberPicture.setImageBitmap(appInfo.getUser(memberID).getPictureBitMap(context));
		holder.tvMemberName.setText(getMemberName(memberID));

		if(hmFriend.get(memberID)==null){
			holder.btInsertFriend.setVisibility(View.VISIBLE);
		}else{
			holder.btInsertFriend.setVisibility(View.GONE);
		}
		holder.btInsertFriend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new InsertFriendTask().execute(memberID);
				view.setVisibility(View.GONE);
			}
		});
		return convertView;
	}
	public String getMemberName(String senderID){
		Friend friend = appInfo.getHmFriend().get(senderID);
		if(friend != null)
			return friend.getNameOrNickName();
		return appInfo.getHmNoFriendChattingMember().get(senderID).getName();
	}
	private class InsertFriendTask extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL = appInfo.getUrlIP() + "insertFriend.php";
			String postParameters = "userID=" + appInfo.getUserID() + "&friendID=" + params[0];

			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result = requestHttpURLConnection.request(serverURL, postParameters);
			if(result.equals("TRUE"))
				appInfo.receiveFriendList();
			return result;
		}
	}
	public void updateItemList(ArrayList<String> memberList){
		this.memberList = memberList;
		notifyDataSetInvalidated();
		notifyDataSetChanged();
	}
}
