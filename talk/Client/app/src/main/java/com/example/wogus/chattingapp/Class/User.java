package com.example.wogus.chattingapp.Class;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import com.example.wogus.chattingapp.R;

import java.io.Serializable;
/**
 * Created by wogus on 2019-07-26.
 */

public class User implements Serializable{

	private String id,name,profile,picture;

	public User(){}
	public User( String id,String name,String profile,String picture){
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.picture = picture;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPicture() {
		return picture;
	}
	public String getProfile() {
		return profile;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Bitmap getPictureBitMap(Context context){
		if(picture == null){
			Drawable drawable = context.getResources().getDrawable(R.drawable.default_profile_picture);
			return((BitmapDrawable)drawable).getBitmap();
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		return BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/chattApp/profile/" + picture, options);

	}
}
