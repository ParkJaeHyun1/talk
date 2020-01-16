package com.example.wogus.chattingapp.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-07-22.
 */

public class FragmentUserSearchMyId extends Fragment{
	AppInfo appInfo;

	View view;
	TextView tvMyId;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_user_search_my_id, container, false);
		init();

		return view;
	}
	protected void init(){
		appInfo = (AppInfo) getActivity().getApplication();

		tvMyId = (TextView) view.findViewById(R.id.tvMyId);
		tvMyId.setText(appInfo.getUserID());
	}
}
