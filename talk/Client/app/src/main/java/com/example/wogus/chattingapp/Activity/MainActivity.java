package com.example.wogus.chattingapp.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.ChattingRoom;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.Message;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.Class.User;
import com.example.wogus.chattingapp.Fragment.FragmentChattingList;
import com.example.wogus.chattingapp.Fragment.FragmentFriendList;
import com.example.wogus.chattingapp.R;

/**
 * Created by wogus on 2019-07-12.
 */

public class MainActivity extends AppCompatActivity {
	private final int TAG_FRAG_FRIEND = 0;
	private final int TAG_FRAG_CHAT = 1;

	private AppInfo appInfo;
	FragmentFriendList fragmentFriendList;
	FragmentChattingList fragmentChattingList;

	private RelativeLayout rlChattingDrawer,rlFriendDrawer,rlSettingDrawer;
	public TextView tvMenuBarName,tvMenuBarNameSet,tvMenuBarEnter,tvMenuBarExit;
	public TextView tvMenuBarName2,tvMenuBarChange,tvMenuBarDelete,tvLogout;

	private int curCategory; 			//0:친구목록 1:채팅목록
	private TextView tvCategory;		//맨위에 한글로 채팅or 친구 나오는부분
	private ImageView ivSelect,ivInsert,ivSettings,ivFriendCategory,ivChatCategory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setListener();
		setFrag(TAG_FRAG_FRIEND);
	}
	@Override
	public void onBackPressed() {
		if(rlChattingDrawer.getVisibility() == View.VISIBLE)
			rlChattingDrawer.setVisibility(View.GONE);
		else if(rlFriendDrawer.getVisibility() == View.VISIBLE)
			rlFriendDrawer.setVisibility(View.GONE);
		else if(rlSettingDrawer.getVisibility() == View.VISIBLE)
			rlSettingDrawer.setVisibility(View.GONE);
		else
			super.onBackPressed();
	}
	protected  void setFrag(int frag_no){
		if(frag_no == curCategory)
			return;
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (frag_no){
			case TAG_FRAG_FRIEND:
				curCategory = 0;
				ivFriendCategory.setImageResource(R.drawable.iv_friend_select);
				ivChatCategory.setImageResource(R.drawable.iv_chat);
				ivInsert.setImageResource(R.drawable.iv_add_friend);
				tvCategory.setText("친구");

				fragmentFriendList = new FragmentFriendList();
				ft.replace(R.id.flFrag,fragmentFriendList);
				ft.commit();
				break;
			case TAG_FRAG_CHAT:

				curCategory = 1;
				ivFriendCategory.setImageResource(R.drawable.iv_friend);
				ivChatCategory.setImageResource(R.drawable.iv_chat_select);
				ivInsert.setImageResource(R.drawable.iv_add_chat);
				tvCategory.setText("채팅");

				fragmentChattingList = new FragmentChattingList();
				ft.replace(R.id.flFrag,fragmentChattingList);
				ft.commit();
				break;
		}
	}
	protected  void init(){
		appInfo = (AppInfo)getApplication();
		curCategory=getIntent().getIntExtra("Category",-1);
		tvCategory = (TextView) findViewById(R.id.tvCategory);
		ivSelect=(ImageView) findViewById(R.id.ivSelect);
		ivInsert=(ImageView)findViewById(R.id.ivInsert);
		ivSettings=(ImageView)findViewById(R.id.ivSettings);
		ivFriendCategory=(ImageView)findViewById(R.id.ivFriendCategory);
		ivChatCategory=(ImageView)findViewById(R.id.ivChatCategory);

		rlChattingDrawer = (RelativeLayout) findViewById(R.id.rlChattingDrawer);
		rlFriendDrawer = (RelativeLayout) findViewById(R.id.rlFriendDrawer);
		rlSettingDrawer= (RelativeLayout) findViewById(R.id.rlSettingDrawer);
		tvLogout = (TextView) findViewById(R.id.tvLogout);
		tvMenuBarName = (TextView) findViewById(R.id.tvMenuBarName);
		tvMenuBarNameSet = (TextView) findViewById(R.id.tvMenuBarNameSet);
		tvMenuBarEnter = (TextView) findViewById(R.id.tvMenuBarEnter);
		tvMenuBarExit = (TextView) findViewById(R.id.tvMenuBarExit);
		tvMenuBarName2 = (TextView) findViewById(R.id.tvMenuBarName2);
		tvMenuBarChange = (TextView) findViewById(R.id.tvMenuBarChange);
		tvMenuBarDelete = (TextView) findViewById(R.id.tvMenuBarDelete);
	}
	protected void setListener(){
		ivInsert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				switch (curCategory){
					case 0:
						Intent InsertFriendIntent = new Intent(MainActivity.this, FriendInsertActivity.class);
						startActivity(InsertFriendIntent);
						break;
					case 1:
						Intent MakeChattingRoomIntent = new Intent(MainActivity.this, InviteChattingMemberActivity.class);
						MakeChattingRoomIntent.putExtra(appInfo.getTAG_ChattingRoomNO(),0);
						startActivity(MakeChattingRoomIntent);
						break;
				}
			}
		});
		tvLogout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
		ivSettings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlSettingDrawer.setVisibility(View.VISIBLE);
			}
		});
		ivFriendCategory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				setFrag(TAG_FRAG_FRIEND);
			}
		});
		ivChatCategory.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				setFrag(TAG_FRAG_CHAT);
			}
		});
		rlChattingDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlChattingDrawer.setVisibility(View.GONE);
			}
		});
		rlFriendDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlFriendDrawer.setVisibility(View.GONE);
			}
		});
		rlSettingDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlSettingDrawer.setVisibility(View.GONE);
			}
		});

	}
	public void displayFriendMenuBar(final int position) {
		final Friend friend = appInfo.getHmFriend().get(appInfo.getFriendIDList().get(position));
		rlFriendDrawer.setVisibility(View.VISIBLE);

		tvMenuBarName2.setText(friend.getNameOrNickName());

		tvMenuBarChange.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlFriendDrawer.setVisibility(View.GONE);
				Intent intent = new Intent(MainActivity.this, ChangeFriendNameActivity.class);
				intent.putExtra(appInfo.getTAG_ID(),friend.getId());
				startActivity(intent);
			}
		});
		tvMenuBarDelete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());

				// AlertDialog 셋팅
				alertDialogBuilder
						.setMessage("친구를 삭제하시겠습니까?")
						.setCancelable(false)
						.setPositiveButton("확인",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										rlFriendDrawer.setVisibility(View.GONE);
										DeleteFriendTask task = new DeleteFriendTask();
										task.execute(friend.getId());
										Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_exit_chat);
										animation.setAnimationListener(new Animation.AnimationListener() {
											@Override
											public void onAnimationStart(Animation animation) {

											}

											@Override
											public void onAnimationEnd(Animation animation) {
												appInfo.getHmFriend().remove(friend.getId());
												appInfo.getFriendIDList().remove(position);
												appInfo.getHmNoFriendChattingMember().put(friend.getId(),(User)friend);
												fragmentFriendList.updateFriendList();

											}

											@Override
											public void onAnimationRepeat(Animation animation) {
											}
										});
										fragmentFriendList.deleteFriendAnimation( position, animation );
									}
								})
						.setNegativeButton("취소",
								new DialogInterface.OnClickListener() {
									public void onClick(
											DialogInterface dialog, int id) {
										// 다이얼로그를 취소한다
										dialog.cancel();
									}
								});

				// 다이얼로그 생성
				final AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

				alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface arg0) {
						alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#000000"));
						alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
					}
				});
			}
		});
	}
	public void displayChattingMenuBar(final int position) {
		final int chattingRoomNo = appInfo.getChattingRoomNoList().get(position);

		rlChattingDrawer.setVisibility(View.VISIBLE);
		tvMenuBarName.setText(appInfo.getHmChattingRoom().get(chattingRoomNo).getChattingRoomName(appInfo));
		tvMenuBarNameSet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlChattingDrawer.setVisibility(View.GONE);
				Intent intent = new Intent(MainActivity.this, ChangeChattingroomNameActivity.class);
				intent.putExtra(appInfo.getTAG_ChattingRoomNO(), chattingRoomNo);
				startActivity(intent);
			}
		});
		tvMenuBarEnter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlChattingDrawer.setVisibility(View.GONE);
				Intent intent = new Intent(MainActivity.this, ChattingRoomActivity.class);
				intent.putExtra(appInfo.getTAG_ChattingRoomNO(),chattingRoomNo);
				startActivity(intent);
			}
		});
		tvMenuBarExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());

				// AlertDialog 셋팅
				alertDialogBuilder
						.setMessage("채팅방에서 나가시겠습니까?")
						.setCancelable(false)
						.setPositiveButton("확인",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										ExitChattingRoomTask task = new ExitChattingRoomTask();
										task.execute(appInfo.getChattingRoomNoList().get(position)+"");
										Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_exit_chat);
										animation.setAnimationListener(new Animation.AnimationListener() {
											@Override
											public void onAnimationStart(Animation animation) {

											}

											@Override
											public void onAnimationEnd(Animation animation) {
												appInfo.getHmChattingRoom().remove(appInfo.getChattingRoomNoList().get(position));
												appInfo.getChattingRoomNoList().remove(position);
												fragmentChattingList.updateChattingList();
											}

											@Override
											public void onAnimationRepeat(Animation animation) {
											}
										});
										rlChattingDrawer.setVisibility(View.GONE);
										fragmentChattingList.deleteChattingRoomAnimation( position, animation );
									}
								})
						.setNegativeButton("취소",
								new DialogInterface.OnClickListener() {
									public void onClick(
											DialogInterface dialog, int id) {
										// 다이얼로그를 취소한다
										dialog.cancel();
									}
								});

				// 다이얼로그 생성
				final AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

				alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
					@Override
					public void onShow(DialogInterface arg0) {
						alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#000000"));
						alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
					}
				});

			}
		});
	}
	private class ExitChattingRoomTask extends AsyncTask<String, Void, String> {
		int chattingRoomNo;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals("TRUE")){
				if(appInfo.getHmChattingRoom().get(chattingRoomNo).getType()==appInfo.getTAG_ChattingRoomType2()) {
					Message msg = new Message();
					msg.setType(msg.getTAG_SendEixtChattingRoomMsg());
					msg.setSenderID(appInfo.getUserID());
					msg.setChattingRoomNo(chattingRoomNo);
					appInfo.getClientSocket().sendMsgToServer(msg.msgToString());
				}
			}else{
				Log.d("메인문방나가기에러:",result);
			}
		}

		@Override
		protected String doInBackground(String... params) {
			String serverURL;
			chattingRoomNo = Integer.parseInt(params[0]);
			if(appInfo.getHmChattingRoom().get(chattingRoomNo).getType()==appInfo.getTAG_ChattingRoomType2())
				serverURL = appInfo.getUrlIP() + "ExitChattingRoom.php";
			else
				serverURL = appInfo.getUrlIP() + "updateChattingRoomJoinDate.php";
			String postParameters = "chattingRoomNo=" + chattingRoomNo + "&userID=" + appInfo.getUserID();
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
	private class DeleteFriendTask extends AsyncTask<String, Void, String> {
		String friendID;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			if(result.equals("TRUE")){
			}else{
				Log.d("친구삭제에러:",result);
			}
		}

		@Override
		protected String doInBackground(String... params) {
			friendID = params[0];
			String serverURL = appInfo.getUrlIP() + "deleteFriend.php";

			String postParameters = "friendID=" + friendID + "&userID=" + appInfo.getUserID();
			RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
			String result =  requestHttpURLConnection.request(serverURL, postParameters);
			return result;
		}
	}
}
