package com.example.wogus.chattingapp.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-07-24.
 */

public class FragmentUserSearchNoResult  extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_user_search_no_result, container, false);
	}
}
