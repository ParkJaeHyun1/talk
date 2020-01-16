package com.example.wogus.chattingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wogus.chattingapp.Activity.InviteChattingMemberActivity;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-09-10.
 */

public class AdapterInviteChattingRoomMemberList extends BaseAdapter{
	AppInfo appInfo;
	private ArrayList<String> friendIDList;
	private HashMap<String, Friend> hmFriend;
	private HashMap<String,Integer> isChecked;
	private LayoutInflater inflater;
	private AdapterSelectChattingRoomMemberList adapterSelectChattingRoomMemberList;
	private InviteChattingMemberActivity inviteChattingMemberActivity;
	private Context context;
	public AdapterInviteChattingRoomMemberList(Context context, HashMap<String,Integer> isChecked,ArrayList<String> friendIDList, InviteChattingMemberActivity inviteChattingMemberActivity){
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.appInfo = (AppInfo)((Activity)context).getApplication();
		this.friendIDList = friendIDList;
		hmFriend = appInfo.getHmFriend();
		this.isChecked = isChecked;
		this.inviteChattingMemberActivity = inviteChattingMemberActivity;
		this.context = context;
	}
	public void setAdapterMakeChattingSelectMemberList(AdapterSelectChattingRoomMemberList adapterSelectChattingRoomMemberList){
		this.adapterSelectChattingRoomMemberList = adapterSelectChattingRoomMemberList;
	}
	public void updateItemList(ArrayList<String> friendIDList){
		this.friendIDList = friendIDList;
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listitem_make_chattingroom_friendlist, parent, false);                    // listview_friend.xml 생성

			HolderAdapterMakeChattingRoomFriendList holder = new HolderAdapterMakeChattingRoomFriendList();

			holder.ivFriendPicture = (ImageView)convertView.findViewById(R.id.ivFriendPciture);
			holder.tvFriendName = (TextView) convertView.findViewById(R.id.tvFriendName);
			holder.cbCheckBox = (CheckBox) convertView.findViewById(R.id.cbCheckBox);

			convertView.setTag(holder);
		}
		final Friend friend = getItem(position);
		HolderAdapterMakeChattingRoomFriendList holder = (HolderAdapterMakeChattingRoomFriendList)convertView.getTag();

		holder.ivFriendPicture.setImageBitmap(friend.getPictureBitMap(context));
		holder.tvFriendName.setText(friend.getNameOrNickName());
		if(getIsChecked(friend.getId())==2)
			holder.cbCheckBox.setEnabled(false);
		else {
			holder.cbCheckBox.setEnabled(true);
			holder.cbCheckBox.setChecked(getIsChecked(friend.getId())==0?true:false);
		}
		holder.cbCheckBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {                                   							// 체크박스 클릭시
				CheckBox checkBox = (CheckBox) v;
				isChecked.put(friend.getId(),checkBox.isChecked()?0:1);
				if(checkBox.isChecked())
					adapterSelectChattingRoomMemberList.selectedFriendIDList.add(0,friend.getId());
				else
					adapterSelectChattingRoomMemberList.selectedFriendIDList.remove(friend.getId());
				adapterSelectChattingRoomMemberList.notifyDataSetChanged();
				inviteChattingMemberActivity.setInviteFriendNum();

			}
		} );
		return convertView;
	}
	public Integer getIsChecked(String id){
		if(isChecked.get(id)==null)
			return 1;
		return isChecked.get(id);
	}
}
