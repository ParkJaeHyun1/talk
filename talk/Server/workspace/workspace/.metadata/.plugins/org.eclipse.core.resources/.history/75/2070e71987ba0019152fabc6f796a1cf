package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.Message;

public class Sql {

	public ArrayList<String> selectChattingRoomMemberList(int no){
		ArrayList<String> memberList = new ArrayList<>();
		Connection con = Open.open();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" select userID  from chattingRoom");
		sql.append(" where chattingRoomNo  = ?");

		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,no);
			rs = pstmt.executeQuery();

			while(rs.next()) 
				memberList.add(rs.getString("userID"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close.close(con,pstmt,rs);
		}

		return memberList;

	}
	public int insertMsg(Message msg){

		boolean flag=false;
		Connection con = Open.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" insert into chattingMsg(senderID,chattingRoomNo,content,unreadUserNum,type ) values(?,?,?,?,?) ");
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, msg.getSenderID());
			pstmt.setInt(2,msg.getChattingRoomNo());
			pstmt.setString(3, msg.getContent());
			pstmt.setInt(4,msg.getUnreadUserNum() );
			pstmt.setString(5, msg.getType());
			if(pstmt.executeUpdate()>0){
				StringBuffer sql2 = new StringBuffer();
				sql2.append("select last_insert_id() as no");
				PreparedStatement pstmt2 = con.prepareStatement(sql2.toString());
				rs = pstmt2.executeQuery();
				rs.next();
				return rs.getInt("no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(con, pstmt);
		}
		return 0;
	}
	public boolean updateChattingRoomUnreadMsgNum(Message msg){
		boolean flag=false;
		Connection con = Open.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> chattingRoomMemberList = selectChattingRoomMemberList(msg.getChattingRoomNo());

		try {
			for(int i=0; i<chattingRoomMemberList.size();i++){
				if(!chattingRoomMemberList.get(i).equals(msg.getSenderID())){
					StringBuffer sql = new StringBuffer();
					sql.append(" update chattingRoom set unreadMsgNum  = (select unreadMsgNum from (select * from chattingRoom) c where userID = ? and chattingRoomNo = ?)+1, joinDate=joinDate where userID = ? and chattingRoomNo= ?" );
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, chattingRoomMemberList.get(i));
					pstmt.setInt(2,msg.getChattingRoomNo());
					pstmt.setString(3, chattingRoomMemberList.get(i));
					pstmt.setInt(4, msg.getChattingRoomNo());
					if(pstmt.executeUpdate()>0) 
						flag = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(con, pstmt);
		}
		return flag;
	}
	public boolean updateChattingMsgUnreadUserNum(Message msg){
		boolean flag=false;
		Connection con = Open.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" update chattingMsg set unreadUserNum   = unreadUserNum-1 where chattingRoomNo = ? and no>? and no<=?" );
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1,msg.getChattingRoomNo());
			pstmt.setInt(2,msg.getLastReadMsgNo());
			pstmt.setInt(3,msg.getRecentReadMsgNo());
			
			if(pstmt.executeUpdate()>0) flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(con, pstmt);
		}
		return flag;
	}
	public boolean updateLastReadMsgNo(Message msg){
		boolean flag=false;
		Connection con = Open.open();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("번호:"+msg.getRecentReadMsgNo());
		System.out.println("번호:"+msg.getChattingRoomNo());
		System.out.println("번호:"+msg.getSenderID());
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" update chattingRoom set lastReadMsgNo   = ? where chattingRoomNo = ? and userID=?" );
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setInt(1,msg.getRecentReadMsgNo());
			pstmt.setInt(2,msg.getChattingRoomNo());
			pstmt.setString(3,msg.getSenderID());
			
			if(pstmt.executeUpdate()>0) flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(con, pstmt);
		}
		return flag;
	}
}
