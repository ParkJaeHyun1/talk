package com.example.wogus.chattingapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-09-11.
 */

public class HolderAdapterChattingSelectMemberList extends RecyclerView.ViewHolder{
	ImageView ivFriendPicture,ivDelete;
	TextView tvFriendName;

	public HolderAdapterChattingSelectMemberList(View itemView){
		super(itemView);
		ivFriendPicture = (ImageView) itemView.findViewById(R.id.ivFriendPicture);
		ivDelete = (ImageView) itemView.findViewById(R.id.ivX);
		tvFriendName = (TextView) itemView.findViewById(R.id.tvFriendName);
	}
}
