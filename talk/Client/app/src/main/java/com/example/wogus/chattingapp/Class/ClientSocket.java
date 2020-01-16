package com.example.wogus.chattingapp.Class;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by wogus on 2019-08-08.
 */

public class ClientSocket {
	private Socket socket;
	private DataInputStream is;
	private DataOutputStream os;

	private boolean isSetting;

	public Socket getSocket() {
		return socket;
	}
	public DataInputStream getIs() {
		return is;
	}
	public void setIs(DataInputStream is){
		this.is = is;
	}
	public DataOutputStream getOs() {
		return os;
	}
	public void setOs(DataOutputStream os){
		this.os = os;
	}

	public ClientSocket(final String ip, final int port){
		isSetting = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					socket = new Socket(InetAddress.getByName(ip), port) ;
					is = new DataInputStream(socket.getInputStream());
					os = new DataOutputStream(socket.getOutputStream());
					Log.d("에러","에러:소켓연결성공:"+os);
				}catch (IOException e) {
					Log.d("에러","에러:소켓연결실패:"+e);
				}
				isSetting = false;
			}//run method..
		}).start(); //Thread 실행..
	}


	public void waitForSocketConnecting(){
		while (isSetting){	}
	}
	public void sendMsgToServer(final String msg){
		waitForSocketConnecting();
		if(os==null)
			return;   //서버와 연결되어 있지 않다면 전송불가..

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					os.writeUTF(msg);  //서버로 메세지 보내기.UTF 방식으로(한글 전송가능...)
					os.flush();        //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드..
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//run method..
		}).start();
	}
}
