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

import com.example.wogus.chattingapp.Activity.ChattingRoomActivity;
import com.example.wogus.chattingapp.Activity.FriendInfoActivity;
import com.example.wogus.chattingapp.Activity.MainActivity;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Fragment.FragmentChattingList;
import com.example.wogus.chattingapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by wogus on 2019-08-21.
 */

public class AdapterChattingList extends BaseAdapter{

	private AppInfo appInfo;
	private Calendar nowCal;
	private LayoutInflater inflater;
	private Context context;
	private ArrayList<Integer> chattingRoomNoList;
	private MainActivity mainActivity;
	public HashMap<Integer, ChattingRoom> hmChattingRoom;

	public AdapterChattingList(Context context, MainActivity mainActivity){
		this.context = context;
		this.mainActivity = mainActivity;
		this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		appInfo = (AppInfo)((Activity)context).getApplication();
		this.chattingRoomNoList = appInfo.getChattingRoomNoList();
		this.hmChattingRoom = appInfo.getHmChattingRoom();
		nowCal = Calendar.getInstance();
	}
	public void updateItemList(ArrayList<Integer> chattingRoomNoList,HashMap<Integer,ChattingRoom> hmChattingRoom){
		this.chattingRoomNoList = chattingRoomNoList;
		this.hmChattingRoom = hmChattingRoom;
		notifyDataSetInvalidated();
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return chattingRoomNoList.size();
	}
	@Override
	public ChattingRoom getItem(int position) {
		return hmChattingRoom.get((int)getItemId(position));
	}

	@Override
	public long getItemId(int position) {
		return chattingRoomNoList.get(position);
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent){
		//Log.d("채팅","채팅");
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listitem_chattingroom, parent, false);

			HolderAdapterChattingRoomList holder = new HolderAdapterChattingRoomList();

			holder.ivChattingPicture = (ImageView)convertView.findViewById(R.id.ivChattingPicture);
			holder.tvChattingName = (TextView) convertView.findViewById(R.id.tvChattingName);
			holder.tvChattingMemberNum = (TextView)convertView.findViewById(R.id.tvChattingMemberNum);
			holder.tvChattingLastMsg = (TextView)convertView.findViewById(R.id.tvChattingLastMsg);
			holder.tvChattingLastMsgTime = (TextView)convertView.findViewById(R.id.tvChattingLastMsgTime);
			holder.tvUnreadChattingMsg = (TextView)convertView.findViewById(R.id.tvUnreadChattingMsg);

			convertView.setTag(holder);
		}
		final ChattingRoom chattingRoom = getItem(position);
		HolderAdapterChattingRoomList holder = (HolderAdapterChattingRoomList)convertView.getTag();

		holder.ivChattingPicture.setImageBitmap(chattingRoom.getChattingRoomPicture(appInfo,context));
		holder.tvChattingName.setText(chattingRoom.getChattingRoomName(appInfo));

		if(chattingRoom.getChattingMemberList().size() <3)
			holder.tvChattingMemberNum.setVisibility(View.INVISIBLE);
		else {
			holder.tvChattingMemberNum.setVisibility(View.VISIBLE);
			holder.tvChattingMemberNum.setText(chattingRoom.getChattingMemberList().size()+"");
		}
		if(chattingRoom.getUnreadMsgNum()==0)
			holder.tvUnreadChattingMsg.setVisibility(View.INVISIBLE);
		else{
			holder.tvUnreadChattingMsg.setVisibility(View.VISIBLE);
			holder.tvUnreadChattingMsg.setText(chattingRoom.getUnreadMsgNum()+"");
		}


		Message lastMsg = chattingRoom.getChattingMsgList().get(chattingRoom.getChattingMsgList().size()-1);
		if(lastMsg.getType().equals(lastMsg.getTAG_SendChattingMsg()))
			holder.tvChattingLastMsg.setText(lastMsg.getChattingMsg());
		else
			holder.tvChattingLastMsg.setText("");
		holder.tvChattingLastMsgTime.setText(lastMsg.calToString(nowCal));

		convertView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, ChattingRoomActivity.class);
				intent.putExtra(appInfo.getTAG_ChattingRoomNO(),chattingRoom.getNo());
				context.startActivity(intent);
			}
		});
		convertView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				mainActivity.displayChattingMenuBar(position);
				return true;
			}
		});
		return convertView;
	}
}
