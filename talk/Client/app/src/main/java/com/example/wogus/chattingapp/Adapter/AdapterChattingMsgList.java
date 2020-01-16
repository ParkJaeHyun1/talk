package com.example.wogus.chattingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Class.User;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;

/**
 * Created by wogus on 2019-09-04.
 */

public class AdapterChattingMsgList  extends BaseAdapter {

	ArrayList<Message> chattingMsgList;
	private LayoutInflater inflater;
	private String userID;
	private AppInfo appInfo;
	private Context context;
	public AdapterChattingMsgList(Context context,ArrayList<Message> chattingMsgList){
		appInfo = (AppInfo)((Activity)context).getApplication();
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.chattingMsgList = chattingMsgList;
		this.userID = appInfo.getUserID();
		this.context = context;
	}
	public void updateItemList(ArrayList<Message> chattingMsgList){
		this.chattingMsgList = chattingMsgList;
		notifyDataSetInvalidated();
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return chattingMsgList.size();
	}
	@Override
	public Message getItem(int position) {
		return chattingMsgList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	@Override
	public int getItemViewType(int position) {
		Message msg = getItem(position);

		if(msg.getType().equals(msg.getTAG_InviteChattingMsg())||msg.getType().equals(msg.getTAG_SendEixtChattingRoomMsg()))
			return R.layout.listitem_member_join_msg;
		if (getItem(position).getSenderID().equals(userID))
			return R.layout.listitem_my_msg;
		return R.layout.listitem_other_msg;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent){

		convertView = inflater.inflate(getItemViewType(position), parent, false);

		HolderAdapterChattingMsgList holder = new HolderAdapterChattingMsgList();

		holder.llMsgDate = (LinearLayout) convertView.findViewById(R.id.llMsgDate);
		holder.ivSenderPicture = (ImageView) convertView.findViewById(R.id.ivSenderPicture);
		holder.tvSenderName = (TextView)convertView.findViewById(R.id.tvSenderName);
		holder.tvMsg = (TextView)convertView.findViewById(R.id.tvMsg);
		holder.tvMsgTime = (TextView)convertView.findViewById(R.id.tvMsgTime);
		holder.tvDate=(TextView)convertView.findViewById(R.id.tvDate);
		holder.tvUnreadUserNum = (TextView)convertView.findViewById(R.id.tvUnreadUserNum);

		final Message msg = getItem(position);
		if (position == 0 || msg.compareMsgDate(getItem(position - 1).getSendMsgDate())) {
			holder.llMsgDate.setVisibility(View.VISIBLE);
			holder.tvDate.setText(msg.calToStringYearDate());
		} else
			holder.llMsgDate.setVisibility(View.GONE);
		if(msg.getType().equals(msg.getTAG_SendChattingMsg())){
			if (!getItem(position).getSenderID().equals(userID)) {

				if (position > 0 && msg.getSenderID().equals(getItem(position - 1).getSenderID()) && msg.calToStringTime().equals(getItem(position - 1).calToStringTime())&&!getItem(position - 1).getType().equals(msg.getTAG_InviteChattingMsg())) {
					holder.tvSenderName.setVisibility(View.GONE);
					holder.ivSenderPicture.setVisibility(View.INVISIBLE);
				} else {
					holder.tvSenderName.setVisibility(View.VISIBLE);
					holder.ivSenderPicture.setVisibility(View.VISIBLE);
					holder.tvSenderName.setText(getNameFromID(msg.getSenderID()));
					holder.ivSenderPicture.setImageBitmap(appInfo.getUser(msg.getSenderID()).getPictureBitMap(context));
				}

			}
			if (position < chattingMsgList.size() - 1 && msg.getSenderID().equals(getItem(position + 1).getSenderID()) && msg.calToStringTime().equals(getItem(position + 1).calToStringTime()))
				holder.tvMsgTime.setVisibility(View.GONE);
			else {
				holder.tvMsgTime.setVisibility(View.VISIBLE);
				holder.tvMsgTime.setText(msg.calToStringTime());
			}
			holder.tvMsg.setText(msg.getChattingMsg());
			if (msg.getUnreadUserNum()<1)
				holder.tvUnreadUserNum.setVisibility(View.INVISIBLE);
			else {
				holder.tvUnreadUserNum.setVisibility(View.VISIBLE);
				holder.tvUnreadUserNum.setText(msg.getUnreadUserNum() + "");
			}
		}else{
			if(msg.getType().equals(msg.getTAG_InviteChattingMsg()))
				holder.tvMsg.setText(getInviteMsg(msg));
			else
				holder.tvMsg.setText(getExitMsg(msg));
		}
		return convertView;
	}
	public String getNameFromID(String senderID){
		Friend friend = appInfo.getHmFriend().get(senderID);
		if(friend != null)
			return friend.getNameOrNickName();
		return appInfo.getHmNoFriendChattingMember().get(senderID).getName();
	}
	public String getInviteMsg(Message msg){
		String result;
		result = getNameFromID(msg.getSenderID())+"님이 ";
		String[] inviteMemberID = msg.getChattingMsg().split(msg.getTAG_InviteUserDivider());

		for(int i=0;i<inviteMemberID.length;i++){
			result+=getNameFromID(inviteMemberID[i])+"님";
			if(i<inviteMemberID.length-1)
				result+=", ";
		}
		result+="을 초대하였습니다.";
		return result;
	}
	public String getExitMsg(Message msg){
		return  getNameFromID(msg.getSenderID())+"님이 채팅방을 나가셨습니다.";
	}
}
