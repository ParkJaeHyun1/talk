package com.example.wogus.chattingapp.Fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import com.example.wogus.chattingapp.Activity.MainActivity;
import com.example.wogus.chattingapp.Adapter.AdapterFriendList;
import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.R;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by wogus on 2019-07-31.
 */

public class FragmentFriendList extends Fragment {
	private AdapterFriendList adapterFriendList;
	private AppInfo appInfo;
	private View view;
	private ListView lvFriendList;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_chattinglist, container, false);
		init();
		sortFriendList();
		displayFriendList();
		return view;
	}
	@Override
	public void onResume(){
		super.onResume();
		sortFriendList();
		updateFriendList();
	}
	protected void init(){
		appInfo = (AppInfo) getActivity().getApplication();
		lvFriendList = (ListView) view.findViewById(R.id.lvChattingList);
	}
	protected  void displayFriendList(){
		adapterFriendList = new AdapterFriendList(getActivity(),(MainActivity)getActivity());
		lvFriendList.setAdapter(adapterFriendList);
	}
	public void updateFriendList(){
		adapterFriendList.updateItemList();
	}
	public void deleteFriendAnimation(int position,Animation animation ){
		lvFriendList.getChildAt(position).startAnimation(animation);
	}
	private void sortFriendList(){
		Log.d("에러1:",appInfo+"");
		Log.d("에러2:",appInfo.getFriendIDList()+"");
		Log.d("에러3:",appInfo.getUserID()+"");
		Log.d("에러4:",appInfo.getHmChattingRoom()+"");
		Log.d("에러5:",appInfo.getChattingRoomNoList()+"");
		Collections.sort(appInfo.getFriendIDList(), new Comparator<String>() {
			@Override
			public int compare(String friendID1, String friendID2) {
				if(friendID1.equals(appInfo.getUserID()))
					return -1;
				else if(friendID2.equals(appInfo.getUserID()))
					return 1;
				else {
					Friend friend1 = appInfo.getHmFriend().get(friendID1);
					Friend friend2 = appInfo.getHmFriend().get(friendID2);
					return friend1.getNameOrNickName().compareTo(friend2.getNameOrNickName());
				}
			}
		});
	}
}
