package com.example.wogus.chattingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wogus.chattingapp.Activity.InviteChattingMemberActivity;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wogus on 2019-09-11.
 */

public class AdapterSelectChattingRoomMemberList extends RecyclerView.Adapter<HolderAdapterChattingSelectMemberList>{
	private LayoutInflater inflater;
	private AppInfo appInfo;
	private HashMap<String,Friend> hmFriend;
	public ArrayList<String> selectedFriendIDList;
	private HashMap<String,Integer> isChecked;
	private AdapterInviteChattingRoomMemberList adapterInviteChattingRoomMemberList;
	private InviteChattingMemberActivity inviteChattingMemberActivity;
	private Context context;
	public AdapterSelectChattingRoomMemberList(Context context, HashMap<String,Integer> isChecked, InviteChattingMemberActivity inviteChattingMemberActivity){
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.appInfo = (AppInfo)((Activity)context).getApplication();
		hmFriend = appInfo.getHmFriend();
		selectedFriendIDList = new ArrayList<>();
		this.isChecked = isChecked;
		this.inviteChattingMemberActivity = inviteChattingMemberActivity;
		this.context = context;

	}
	public void setAdapterInviteChattingRoomMemberList(AdapterInviteChattingRoomMemberList adapterInviteChattingRoomMemberList){
		this.adapterInviteChattingRoomMemberList = adapterInviteChattingRoomMemberList;
	}
	@Override
	public HolderAdapterChattingSelectMemberList onCreateViewHolder(ViewGroup parent, int viewType) {
		return new HolderAdapterChattingSelectMemberList(inflater.inflate(R.layout.listitem_make_chattingroom_select_friendlist,parent,false));
	}

	@Override
	public void onBindViewHolder(HolderAdapterChattingSelectMemberList holder, int position) {
		final Friend friend = hmFriend.get(selectedFriendIDList.get(position));

		//holder.ivPicture.setImageURI(friend.getPicture());
		holder.ivFriendPicture.setImageBitmap(friend.getPictureBitMap(context));
		holder.tvFriendName.setText(friend.getNameOrNickName());
		holder.ivDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				isChecked.put(friend.getId(),1);
				selectedFriendIDList.remove(friend.getId());
				notifyDataSetChanged();

				adapterInviteChattingRoomMemberList.notifyDataSetChanged();
				inviteChattingMemberActivity.setInviteFriendNum();
			}
		});
	}

	@Override
	public int getItemCount() {
		return selectedFriendIDList.size();
	}
}
