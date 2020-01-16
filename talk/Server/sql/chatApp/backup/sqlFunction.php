<?php
function login($id,$password,$con){
//  include('dbConnect.php');
  $sql="select id from user where id='$id' and password='$password'";
  $stmt = $con->prepare($sql);
  $stmt->execute();
  if ($stmt->rowCount() != 0){
    return "TRUE";
  }
  else{
    return "FALSE";
  }
}

function selectChattingMemberList($chattingRoomNo,$con){

  $stmt = $con->prepare("select userID from chattingRoom where chattingRoomNo = '$chattingRoomNo'");
  $stmt->execute();
  $chattingMemberList = array();

  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
      array_push($chattingMemberList,array('userID'=>$row["userID"]));
  }

  return $chattingMemberList;
}

function selectChattingMsgList($chattingRoomNo,$userID,$con){
  $sql = "select no,type,senderID,content,sendMsgDate,unreadUserNum from chattingMsg where chattingRoomNo='$chattingRoomNo' and sendMsgDate>=
  (select joinDate from chattingRoom where chattingRoomNo ='$chattingRoomNo' and userID='$userID')";
  $stmt = $con->prepare($sql);
  $stmt->execute();
  $chattingMsgList = array();

  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
      array_push($chattingMsgList,array('userID'=>$row["userID"]));
  }

  return $chattingMemberList;
}

function selectChattingRoomList($userID,$con){

  $sql="select c1.chattingRoomNo,type,chattingRoomName ,unreadMsgNum,lastReadMsgNo from chattingRoom as c1,chattingRoomType as c2
  where userID='$userID' and c1.chattingRoomNo=c2.chattingRoomNo";
  $stmt = $con->prepare($sql);
  $stmt->execute();

  $chattingRoom = array();
  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
    array_push($chattingRoom,array('chattingRoomNo'=>$row["chattingRoomNo"],
        'type'=>$row["type"],
        'chattingRoomName'=>$row["chattingRoomName"],
        'unreadMsgNum'=>$row["unreadMsgNum"],
        'lastReadMsgNo'=>$row["lastReadMsgNo"],
        'chattingMemberList'=>selectChattingMemberList($row["chattingRoomNo"],$con),
        'chattingMsgList'=>selectChattingMsgList($chattingRoomNo,$userID,$con)($row["chattingRoomNo"],$userID,$con)
      ));
  }
  return $chattingRoom;
}

function selectChattingMemberNoFriendList($userID,$con){
  $chattingMemberNoFriend = array();
  $stmt = $con->prepare("select id,name,picture,profile
   from user
   where id IN(select DISTINCT c1.userID
                 from chattingRoom c1, chattingRoom c2
                  where c2.userID='$userID' and c2.chattingRoomNo  = c1.chattingRoomNo ) and
           id NOT IN(select friendID from friend where userID = '$userID')");
  $stmt->execute();

  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
      array_push($chattingMemberNoFriend,array('id'=>$row["id"],
          'name'=>$row["name"],
          'picture'=>$row["picture"],
          'profile'=>$row["profile"]));
  }
  return $chattingMemberNoFriend;
}

function selectFriendList($userID,$con){
  $result = array();
  $stmt = $con->prepare("select id,name,phone,picture,profile,chattingRoomNo from user where id='$userID'");
  $stmt->execute();

  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
      array_push($result,array('id'=>$row["id"],
          'name'=>$row["name"],
          'phone'=>$row["phone"],
          'picture'=>$row["picture"],
          'profile'=>$row["profile"],
          'chattingRoomNo'=>$row["chattingRoomNo"]));
  }

  $stmt = $con->prepare("select id,name,phone,nickName,picture,profile,friend.chattingRoomNo from user, friend where friend.userID='$userID' and friend.friendID=user.ID");
  $stmt->execute();

  while($row=$stmt->fetch(PDO::FETCH_ASSOC)){
      array_push($result,array('id'=>$row["id"],
          'name'=>$row["name"],
          'phone'=>$row["phone"],
          'nickName'=>$row["nickName"],
          'picture'=>$row["picture"],
          'profile'=>$row["profile"],
          'chattingRoomNo'=>$row["chattingRoomNo"]));
  }
  return $result;
}
?>
