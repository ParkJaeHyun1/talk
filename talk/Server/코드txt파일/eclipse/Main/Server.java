package Main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import mysql.Sql;


public class Server {

	final int PORT=10001;
	
	private final static String TAG_LoginMsg  = "8";
	private final static String TAG_LogoutMsg  = "9";
	private final static String TAG_ChattingMsg ="7";
	private final static String TAG_ReadChattingMsg ="6";
	private final static String TAG_InviteMsg ="5";
	private final static String TAG_EixtChattingRoomMsg ="4";
	ServerSocket serversocket;
	HashMap<String, DataOutputStream> hmClients;

	public Server(){
		hmClients = new HashMap<String,DataOutputStream>();
		Collections.synchronizedMap(hmClients);
	}
	public void StartServer(){
		Socket socket;
		try {
			//서버소켓 생성.
			serversocket=new ServerSocket(PORT);
			while(true){
				socket = serversocket.accept(); 
				new MultiThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MultiThread extends Thread{
		Socket socket ;
		String id;
		DataInputStream is;
		DataOutputStream os;

		public MultiThread(Socket socket){
			System.out.println("소켓생성");
			this.socket = socket;
			try{
				is = new DataInputStream(socket.getInputStream());
				os = new DataOutputStream(socket.getOutputStream());
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	
		private void sendMsg(final String receiverID ,final Message msg){
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						DataOutputStream os = hmClients.get(receiverID);
						if(os == null){
							System.out.println("보내기실패:"+receiverID);
						}
						else{
							System.out.println("보내기성공:"+receiverID);
							os.writeUTF(msg.msgToString()); //클라이언트로 메세지 보내기.UTF 방식으로(한글 전송가능...)
							os.flush();   //다음 메세지 전송을 위해 연결통로의 버퍼를 지워주는 메소드..
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start(); //Thread 실행..
		}
		private void sendChattingMsg(Message msg){
			Sql sql = new Sql();
			ArrayList<String> memberIDlist = sql.selectChattingRoomMemberList(msg.getChattingRoomNo());
			for(String id : memberIDlist)
				sendMsg(id,msg);
		}
		private void login(String id){
			this.id = id;
			hmClients.put(id, os);
			System.out.println(id+"접속:"+os);
		}
		private void logout(){
			hmClients.remove(id);
			is = null;
		}
		@Override
		public void run(){
			while(is != null){
				try{
					String str = is.readUTF();
					System.out.println("수신메세지:"+str);
					Message msg = new Message();
					msg.StringToMsg(str);
					Sql sql = new Sql();
					switch (msg.getType()) {
					case TAG_EixtChattingRoomMsg:
					case TAG_InviteMsg:
						msg.setCal(Calendar.getInstance());
						sql.insertMsg(msg);
						sendChattingMsg(msg);
						break;
					case TAG_LogoutMsg:
						logout();
						break;
					case TAG_LoginMsg:
						login(msg.getSenderID());
						break;
					case TAG_ChattingMsg:
						msg.setCal(Calendar.getInstance());
						int msgNo = sql.insertMsg(msg);
						msg.setNo(msgNo);
						sql.updateChattingRoomUnreadMsgNum(msg);
						sendChattingMsg(msg);
						break;
					case TAG_ReadChattingMsg:
						sql.updateChattingMsgUnreadUserNum(msg);
						sendChattingMsg(msg);
						break;
					default:
						break;
					}
				}catch(IOException e){
					logout();
					e.printStackTrace();
					break;
				}
			}
		}

	}
}
