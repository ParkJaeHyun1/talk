package com.example.wogus.chattingapp.Fragment;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import com.example.wogus.chattingapp.Activity.MainActivity;
import com.example.wogus.chattingapp.Adapter.AdapterChattingList;
import com.example.wogus.chattingapp.Adapter.AdapterChattingMsgList;
import com.example.wogus.chattingapp.Adapter.AdapterFriendList;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.R;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wogus on 2019-08-01.
 */

public class FragmentChattingList extends Fragment{

	AppInfo appInfo;
	View view;
	private ListView lvChattingList;
	private AdapterChattingList adapterChattingList;
	private BroadcastReceiver mBroadcastReceiver;


	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_chattinglist, container, false);

		init();
		sortChattingList();
		displayChattingList();
		return view;
	}
	@Override
	public void onResume(){
		super.onResume();
		sortChattingList();
		updateChattingList();
	}
	public void deleteChattingRoomAnimation(int position,Animation animation ){
		lvChattingList.getChildAt(position).startAnimation(animation);
	}
	public void updateChattingList(){
		adapterChattingList.updateItemList(appInfo.getChattingRoomNoList(),appInfo.getHmChattingRoom());
	}
	private void init(){
		appInfo = (AppInfo) getActivity().getApplication();

		lvChattingList = (ListView) view.findViewById(R.id.lvChattingList);
	}
	private void displayChattingList(){
		adapterChattingList = new AdapterChattingList(getActivity(),(MainActivity) getActivity());
		lvChattingList.setAdapter(adapterChattingList);

		mBroadcastReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				Message msg = (Message)intent.getSerializableExtra("chattingMsg");
				adapterChattingList.updateItemList(appInfo.getChattingRoomNoList(),appInfo.getHmChattingRoom());
			}
		};
		LocalBroadcastManager.getInstance(this.getContext()).registerReceiver(mBroadcastReceiver,new IntentFilter("chattingMsg"));
	}
	private void sortChattingList(){
		Collections.sort(appInfo.getChattingRoomNoList(), new Comparator<Integer>() {
			@Override
			public int compare(Integer chattingRoomNo1, Integer chattingRoomNo2) {
				ChattingRoom chattingRoom1 = appInfo.getHmChattingRoom().get(chattingRoomNo1);
				ChattingRoom chattingRoom2 = appInfo.getHmChattingRoom().get(chattingRoomNo2);

				Calendar cal1 = chattingRoom1.getChattingMsgList().get(chattingRoom1.getChattingMsgList().size()-1).getSendMsgDate();
				Calendar cal2 = chattingRoom2.getChattingMsgList().get(chattingRoom2.getChattingMsgList().size()-1).getSendMsgDate();
				return compareCal(0,cal1,cal2);
			}
		});
	}
	public int compareCal(int num,Calendar cal1,Calendar cal2) {
		int[] calendarAttribute= {Calendar.YEAR,Calendar.MONTH,Calendar.DATE,Calendar.HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND};

		if(num == 6)
			return 1;

		if(cal1.get(calendarAttribute[num]) < cal2.get(calendarAttribute[num]))
			return 1;
		else if(cal1.get(calendarAttribute[num]) > cal2.get(calendarAttribute[num]))
			return -1;
		else
			return compareCal(++num,cal1,cal2);
	}
}
