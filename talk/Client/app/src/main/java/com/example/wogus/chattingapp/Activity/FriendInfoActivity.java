package com.example.wogus.chattingapp.Activity;

import android.Manifest;
import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wogus.chattingapp.Class.AppInfo;
import com.example.wogus.chattingapp.Class.Friend;
import com.example.wogus.chattingapp.Class.ImageResizeUtils;
import com.example.wogus.chattingapp.Class.RequestHttpURLConnection;
import com.example.wogus.chattingapp.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.soundcloud.android.crop.Crop;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


/**
 * Created by wogus on 2019-08-01.
 */

public class FriendInfoActivity extends AppCompatActivity {
	private static final String TAG = "blackjin";
	private Boolean isCamera = false;
	private Boolean isPermission = true;

	private static final int PICK_FROM_ALBUM = 1;
	private static final int PICK_FROM_CAMERA = 2;

	private File tempFile;

	AppInfo appInfo;
	Friend friend;

	ImageView ivPicture,ivFriendNameUpdate,ivFriendPictureUpdate;
	TextView tvName,tvPhoneNumber,tvPhoto,tvAlbum,tvProfile;
	LinearLayout llPhone,llChatting,llUpdateProfile;
	RelativeLayout rlProfileDrawer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_info);

		init();
		setView();
		setListener();
		tedPermission();
	}
	private void init(){
		appInfo = (AppInfo) getApplication();
		friend = appInfo.getHmFriend().get(getIntent().getSerializableExtra(appInfo.getTAG_ID()));

		ivPicture = (ImageView) findViewById(R.id.ivPicture);
		ivFriendNameUpdate = (ImageView)findViewById(R.id.ivFriendNameUpdate);
		tvName = (TextView)findViewById(R.id.tvName);
		tvPhoneNumber = (TextView)findViewById(R.id.tvPhoneNumber);
		tvPhoto = (TextView)findViewById(R.id.tvPhoto);
		tvAlbum = (TextView)findViewById(R.id.tvAlbum);
		tvProfile = (TextView)findViewById(R.id.tvProfile);
		llPhone = (LinearLayout) findViewById(R.id.llPhone);
		llChatting = (LinearLayout)findViewById(R.id.llChatting);
		llUpdateProfile = (LinearLayout)findViewById(R.id.llUpdateProfile);
		rlProfileDrawer = (RelativeLayout) findViewById(R.id.rlProfileDrawer);
		ivFriendPictureUpdate = (ImageView)findViewById(R.id.ivFriendPictureUpdate);
		if(friend.getId().equals(appInfo.getUserID()))
			ivFriendPictureUpdate.setVisibility(View.VISIBLE);
	}
	private void setView(){
		ivPicture.setImageBitmap(friend.getPictureBitMap(this));
		tvName.setText(friend.getNameOrNickName());
		if(friend.getProfile() != null){
			tvProfile.setText(friend.getProfile());
		}
		if(friend.getId().equals(appInfo.getUserID()) ) {
			ivFriendPictureUpdate.setVisibility(View.VISIBLE);
			llUpdateProfile.setVisibility(View.VISIBLE);
			llPhone.setVisibility(View.GONE);
		}else{
			if(friend.getPhone()!=null) {
				llPhone.setVisibility(View.VISIBLE);
				tvPhoneNumber.setText(new StringBuffer(friend.getPhone()).insert(3,'-').insert(8,'-'));
			}
		}
	}
	private void setListener(){
		llChatting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(FriendInfoActivity.this, ChattingRoomActivity.class);
				intent.putExtra(appInfo.getTAG_ChattingRoomNO(),friend.getChattingRoomNo());
				if(appInfo.getHmChattingRoom().get(friend.getChattingRoomNo())==null){
					ArrayList<String> inviteMemberList = new ArrayList<>();
					inviteMemberList.add(friend.getId());
					if(!appInfo.getUserID().equals(friend.getId())) {
						inviteMemberList.add(appInfo.getUserID());
						intent.putExtra(appInfo.getTAG_ChattingRoomType(), appInfo.getTAG_ChattingRoomType1());
					}else
						intent.putExtra(appInfo.getTAG_ChattingRoomType(), appInfo.getTAG_ChattingRoomType0());
					intent.putExtra(appInfo.getTAG_InviteMemberList(),inviteMemberList);
				}
				finish();
				startActivity(intent);
			}
		});
		ivFriendNameUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(FriendInfoActivity.this, ChangeFriendNameActivity.class);
				intent.putExtra(appInfo.getTAG_ID(),friend.getId());
				finish();
				startActivity(intent);
			}
		});
		llUpdateProfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(FriendInfoActivity.this, ChangeProfileActivity.class);
				intent.putExtra(appInfo.getTAG_ID(),friend.getId());
				finish();
				startActivity(intent);
			}
		});
		ivFriendPictureUpdate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlProfileDrawer.setVisibility(View.VISIBLE);
			}
		});
		tvAlbum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// 권한 허용에 동의하지 않았을 경우 토스트를 띄웁니다.
				if(isPermission) goToAlbum();
				else Toast.makeText(view.getContext(),"갤러리권한x", Toast.LENGTH_LONG).show();
				if(rlProfileDrawer.getVisibility() == View.VISIBLE)
					rlProfileDrawer.setVisibility(View.GONE);
			}
		});
		tvPhoto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// 권한 허용에 동의하지 않았을 경우 토스트를 띄웁니다.
				if(isPermission)  takePhoto();
				else Toast.makeText(view.getContext(),"카메라찍는권한x", Toast.LENGTH_LONG).show();
				if(rlProfileDrawer.getVisibility() == View.VISIBLE)
					rlProfileDrawer.setVisibility(View.GONE);
			}
		});
		llPhone.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				call();
			}
		});
		rlProfileDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rlProfileDrawer.setVisibility(View.GONE);
			}
		});
	}
	@Override
	public void onBackPressed() {
		if(rlProfileDrawer.getVisibility() == View.VISIBLE)
			rlProfileDrawer.setVisibility(View.GONE);
		else
			super.onBackPressed();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != Activity.RESULT_OK) {
			Toast.makeText(this, "취소 되었습니다.", Toast.LENGTH_SHORT).show();
			tempFile = null;
			if(friend.getPicture() == null) {
				if (tempFile.exists()) {
					if (tempFile.delete()) {
						Log.e(TAG, tempFile.getAbsolutePath() + " 삭제 성공");

					}
				}
			}

			return;
		}
		switch (requestCode) {
			case PICK_FROM_ALBUM: {

				Uri photoUri = data.getData();

				cropImage(photoUri);

				break;
			}
			case PICK_FROM_CAMERA: {

				Uri photoUri = Uri.fromFile(tempFile);
				Log.d("두번째URI:",":"+photoUri);
				ImageResizeUtils.resizeFile(tempFile, tempFile, 1280, isCamera);
				cropImage(photoUri);

				break;
			}
			case Crop.REQUEST_CROP: {
				setImage();
			}
		}
	}
	private void cropImage(Uri photoUri) {

		Log.d(TAG, "tempFile : " + tempFile);

		/**
		 *  갤러리에서 선택한 경우에는 tempFile 이 없으므로 새로 생성해줍니다.
		 */
		if(tempFile == null) {
			try {
				tempFile = createImageFile();
			} catch (IOException e) {
				Toast.makeText(this, "이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
				finish();
				e.printStackTrace();
			}
		}
		//크롭 후 저장할 Uri
		Uri savingUri = Uri.fromFile(tempFile);

		Crop.of(photoUri, savingUri).asSquare().start(this);
	}
	private void goToAlbum() {
		tempFile=null;
		isCamera = false;
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
		startActivityForResult(intent, PICK_FROM_ALBUM);
	}
	private void takePhoto() {
		tempFile=null;
		isCamera = true;
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		try {
			tempFile = createImageFile();
		} catch (IOException e) {
			Toast.makeText(this, "이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show();
			finish();
			e.printStackTrace();
		}
		if (tempFile != null) {
			Uri photoUri = FileProvider.getUriForFile(this, "com.example.wogus.chattingapp.fileprovider", tempFile);
			Log.d("처음URI:",":"+photoUri);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
			startActivityForResult(intent, PICK_FROM_CAMERA);
		}
	}
	/**
	 *  tempFile 을 bitmap 으로 변환 후 ImageView 에 설정한다.
	 */
	private void setImage() {

		ImageResizeUtils.resizeFile(tempFile, tempFile, 1280, true);
		BitmapFactory.Options options = new BitmapFactory.Options();
		Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
		ivPicture.setImageBitmap(originalBm);
		appInfo.getHmFriend().get(appInfo.getUserID()).setPicture(appInfo.getUserID());

		new uploadTask().execute(tempFile.getAbsolutePath());
		Log.d("파일경로:","파일경로:"+tempFile.getAbsolutePath());
		Log.d("비트맵:","비트맵:"+originalBm);
		/**
		 *  tempFile 사용 후 null 처리를 해줘야 합니다.
		 *  (resultCode != RESULT_OK) 일 때 tempFile 을 삭제하기 때문에
		 *  기존에 데이터가 남아 있게 되면 원치 않은 삭제가 이뤄집니다.
		 */
		tempFile = null;

	}
	/**
	 *  폴더 및 파일 만들기
	 */
	private File createImageFile() throws IOException {

		// 이미지 파일 이름 ( blackJin_{시간}_ )

		String imageFileName = appInfo.getUserID() + ".jpg";
		File storageDir = new File(Environment.getExternalStorageDirectory() + "/chattApp/profile/");
		if (!storageDir.exists()) storageDir.mkdirs();

		File image = new File(storageDir.getAbsolutePath(),imageFileName);
		Log.d("파일생성", "파일생성 : " + image.getAbsolutePath());

		return image;
	}

	/**
	 *  권한 설정
	 */
	private void tedPermission() {

		PermissionListener permissionListener = new PermissionListener() {
			@Override
			public void onPermissionGranted() {
				// 권한 요청 성공
				isPermission = true;

			}

			@Override
			public void onPermissionDenied(ArrayList<String> deniedPermissions) {
				// 권한 요청 실패
				isPermission = false;

			}
		};

		TedPermission.with(this)
				.setPermissionListener(permissionListener)
				.setRationaleMessage("퍼미션2")
				.setDeniedMessage("퍼미션1")
				.setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
				.check();

	}
	public int uploadFile(String sourceFileUri) {
		Log.d("파일업로드시작","파일업로드시작");
		int serverResponseCode = 0;
		String fileName = sourceFileUri;
		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;
		File sourceFile = new File(sourceFileUri);

		if (!sourceFile.isFile()) {
			Log.e("파일업로드", "파일이존재하지않음:"+sourceFileUri);
				return 0;
		}
		else{
			try {
				// open a URL connection to the Servlet
				FileInputStream fileInputStream = new FileInputStream(sourceFile);
				URL url = new URL(appInfo.getUrlIP()+"upload.php");
				// Open a HTTP  connection to  the URL
				conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true); // Allow Inputs
				conn.setDoOutput(true); // Allow Outputs
				conn.setUseCaches(false); // Don't use a Cached Copy
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Connection", "Keep-Alive");
				conn.setRequestProperty("ENCTYPE", "multipart/form-data");
				conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
				conn.setRequestProperty("uploaded_file", fileName);

				dos = new DataOutputStream(conn.getOutputStream());
				dos.writeBytes(twoHyphens + boundary + lineEnd);
				dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""+ fileName + "\"" + lineEnd);
				dos.writeBytes(lineEnd);

				// create a buffer of  maximum size
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				buffer = new byte[bufferSize];
				// read file and write it into form...
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				while (bytesRead > 0) {
					dos.write(buffer, 0, bufferSize);
					bytesAvailable = fileInputStream.available();
					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				}

				// send multipart form data necesssary after file data...
				dos.writeBytes(lineEnd);
				dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
				// Responses from the server (code and message)
				serverResponseCode = conn.getResponseCode();
				String serverResponseMessage = conn.getResponseMessage();
				Log.i("파일업로드", "응답 : "+ serverResponseMessage + ": " + serverResponseCode);
				if(serverResponseCode == 200){
					Log.d("파일업로드성공","파일업로드성공");
					String serverURL = appInfo.getUrlIP() + "updateUserPicture.php";
					String postParameters = "userID=" + appInfo.getUserID();
					RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
					String result =  requestHttpURLConnection.request(serverURL, postParameters);
					if(result.equals(appInfo.getTAG_TRUE()))
						Log.d("프로필사진 업데이트 성공","프로필사진 업데이트 성공");
					else
						Log.d( "프로필사진 업데이트 실패: ","실패:"+result);
				}

				//close the streams //
				fileInputStream.close();
				dos.flush();
				dos.close();
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
				Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
			} catch (Exception e) {
				e.printStackTrace();
				Log.e("Upload file to server ", "Exception : "	+ e.getMessage(), e);
			}
			return serverResponseCode;
		} // End else block
	}
	private class uploadTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

		}

		@Override
		protected String doInBackground(String... params) {
			return uploadFile(params[0])+"";
		}
	}
	public void call(){
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + friend.getPhone()));                // 전화번호 Uri정보 intent설정
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {                // 전화 권한있는지 확인
			ActivityCompat.requestPermissions(FriendInfoActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);                    // 권한 부여할 것인지 요청창 뜨게함
		} else {
			startActivity(intent);
		}
	}
}
