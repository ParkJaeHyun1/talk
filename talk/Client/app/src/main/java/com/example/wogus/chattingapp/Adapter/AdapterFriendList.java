package com.example.wogus.chattingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Activity.FriendInfoActivity;
import com.example.wogus.chattingapp.Activity.MainActivity;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-07-26.
 */

public class AdapterFriendList extends BaseAdapter {

	AppInfo appInfo;

	private LayoutInflater inflater;
	private Context context;
	private ArrayList<String> friendIDList;
	public HashMap<String, Friend> hmFriend;
	private float mScale;
	private MainActivity mainActivity;
	public AdapterFriendList(Context context,MainActivity mainActivity){
		this.context = context;
		this.mainActivity = mainActivity;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mScale = context.getResources().getDisplayMetrics().density;
		appInfo = (AppInfo)((Activity)context).getApplication();
		this.friendIDList = appInfo.getFriendIDList();
		this.hmFriend = appInfo.getHmFriend();
	}
	public void updateItemList(){
		this.friendIDList = appInfo.getFriendIDList();
		this.hmFriend = appInfo.getHmFriend();
		notifyDataSetInvalidated();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return friendIDList.size();
	}

	@Override
	public Friend getItem(int position) {
		return hmFriend.get(friendIDList.get(position));
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent){
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listitem_friend, parent, false);                    // listview_friend.xml 생성

			HolderAdapterFriendList holder = new HolderAdapterFriendList();

			holder.ivPicture = (ImageView)convertView.findViewById(R.id.ivPicture);
			holder.tvFriendNum = (TextView) convertView.findViewById(R.id.tvFriendNum);
			holder.tvLine = (TextView)convertView.findViewById(R.id.tvLine);
			holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
			holder.tvProfile = (TextView)convertView.findViewById(R.id.tvProfile);

			convertView.setTag(holder);
		}

		final Friend friend = getItem(position);
		HolderAdapterFriendList holder = (HolderAdapterFriendList)convertView.getTag();

		if(position==0){
			holder.tvLine.setVisibility(View.VISIBLE);
			holder.tvFriendNum.setVisibility(View.VISIBLE);
			holder.tvFriendNum.setText("친구 "+(getCount()-1));

			holder.tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
			holder.tvProfile.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			setParams(holder.ivPicture,60,60);
		}else{
			holder.tvLine.setVisibility(View.GONE);
			holder.tvFriendNum.setVisibility(View.GONE);

			holder.tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			holder.tvProfile.setTextSize(TypedValue.COMPLEX_UNIT_DIP,11);
			setParams(holder.ivPicture,45,45);
		}

		holder.ivPicture.setImageBitmap(friend.getPictureBitMap(context));
		Log.d("친구사진:", "getView: "+friend.getPictureBitMap(context));
		holder.tvName.setText(friend.getNameOrNickName());

		if(friend.getProfile()==null)
			holder.tvProfile.setVisibility(View.GONE);
		else {
			holder.tvProfile.setVisibility(View.VISIBLE);
			holder.tvProfile.setText(friend.getProfile());
		}
		convertView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, FriendInfoActivity.class);
				intent.putExtra(appInfo.getTAG_ID(),friend.getId());
				context.startActivity(intent);
			}
		});
		convertView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				mainActivity.displayFriendMenuBar(position);
				return true;
			}
		});
		return convertView;
	}
	private void setParams(ImageView ivPicture,int dpWidth,int dpHeight){
		ViewGroup.LayoutParams params = ivPicture.getLayoutParams();
		params.width = (int)(mScale*dpWidth);
		params.height = (int)(mScale*dpHeight);
		ivPicture.setLayoutParams(params);
	}
}
