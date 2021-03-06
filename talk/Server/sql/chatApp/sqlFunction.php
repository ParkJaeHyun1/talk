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
      array_push($chattingMsgList,array(
      'no'=>$row["no"],
      'type'=>$row["type"],
      'senderID'=>$row["senderID"],
      'content'=>$row["content"],
      'sendMsgDate'=>$row["sendMsgDate"],
      'unreadUserNum'=>$row["unreadUserNum"]));
  }

  return $chattingMsgList;
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
        'chattingMsgList'=>selectChattingMsgList($row["chattingRoomNo"],$userID,$con)
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

function selectUser($searchID,$userID,$con){
  $result = array();

  $stmt = $con->prepare("select id, name,picture from user where id='$searchID'");
  $stmt->execute();

  $row=$stmt->fetch(PDO::FETCH_ASSOC);
  $result =  array('id'=>$row['id'],'name'=>$row['name'],'picture'=>$row['picture']);

  $stmt = $con->prepare("select userID from friend where userID='$userID' and friendID='$searchID'");
  $stmt->execute();

  if ($stmt->rowCount() == 0)                     // 해당 유저와 친구 아님
      $result["isFriend"]= false;
  else
      $result["isFriend"]= true;

  return $result;
}

function insertFriend($userID,$friendID,$con){
  $stmt = $con->prepare("insert into friend(userID,friendID) value ('$userID','$friendID')");
  if($stmt->execute()){
      $stmt = $con->prepare("select chattingRoomNo from friend where friendID = '$userID' and userID = '$friendID'");
      $stmt->execute();
      if ($stmt->rowCount()> 0){
          $row=$stmt->fetch(PDO::FETCH_ASSOC);
          $no = $row["chattingRoomNo"];
          if($no != NULL){
            $stmt2 = $con->prepare("update friend set chattingRoomNo = '$no' where userID='$userID' and friendID='$friendID'");
            $stmt2->execute();
        }
      }
      return 'TRUE';
  }
  return 'FALSE';
}

function selectFriend($userID,$friendID,$con){
  $stmt = $con->prepare("select id,name,phone,nickName,picture,profile,friend.chattingRoomNo from user, friend
  where friend.userID='$userID' and friend.friendID='$friendID' and user.ID='$friendID'");
  $stmt->execute();

  $row=$stmt->fetch(PDO::FETCH_ASSOC);
  $result = array('id'=>$row["id"],
      'name'=>$row["name"],
      'phone'=>$row["phone"],
      'nickName'=>$row["nickName"],
      'picture'=>$row["picture"],
      'profile'=>$row["profile"],
      'chattingRoomNo'=>$row["chattingRoomNo"]);
  return $result;
}

function updateFriendNickName($userID,$friendID,$friendNickName,$con){
  $stmt = $con->prepare("update friend set nickName = '$friendNickName' where userID = '$userID' and friendID = '$friendID'");
  if($stmt->execute())
      return 'TRUE';
  return 'FALSE';
}

function updateUserName($userID,$name,$con){
  $stmt = $con->prepare("update user set name = '$name' where id = '$userID'");
  if($stmt->execute())
      return 'TRUE';
  return 'FALSE';
}

function updateLastReadMsgNo($lastReadMsgNo,$userID,$chattingRoomNo,$con){
  $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
  $stmt = $con->prepare("update chattingRoom set lastReadMsgNo = '$lastReadMsgNo', joinDate=joinDate where userID = '$userID' and chattingRoomNo = '$chattingRoomNo'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function ExitChattingRoom($chattingRoomNo,$userID,$con){
  $stmt = $con->prepare("delete from chattingRoom where chattingRoomNo = '$chattingRoomNo' and userID = '$userID'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function insertChattingroom($chattingRoomNo,$memberList,$con){
  foreach($memberList as $member){
      $memberID = $member;
      $stmt = $con->prepare("insert into chattingRoom(userID,chattingRoomNo ) value ('$memberID','$chattingRoomNo')");
      $stmt->execute();
  }
}
function insertChattingRoomType($type,$con){
  $stmt = $con->prepare("insert into chattingRoomType(type) value ($type)");

  if($stmt->execute()){
      $stmt = $con->prepare("select max(chattingRoomNo ) as max from chattingRoomType");
      $stmt->execute();

      $row=$stmt->fetch(PDO::FETCH_ASSOC);
      $max = $row['max'];
      return $max;
  }else
      return 'FALSE';
}
function updateChattingroomUnreadMsgNum($unreadMsgNum,$userID,$chattingRoomNo,$con){
  $stmt = $con->prepare("update chattingRoom set unreadMsgNum  = '$unreadMsgNum', joinDate=joinDate where userID = '$userID' and chattingRoomNo= '$chattingRoomNo'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function updateFriendChattingroomNo($chattingRoomNo,$userID,$friendID,$con){
  $stmt = $con->prepare("update friend set chattingRoomNo = '$chattingRoomNo' where userID = '$userID' and friendID = '$friendID'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function updateChattingRoomJoinDate($chattingRoomNo,$userID,$con){
  $stmt = $con->prepare("update chattingRoom set unreadMsgNum  = 0,chattingRoomName  =NULL,lastReadMsgNo =0 where userID = '$userID' and chattingRoomNo= '$chattingRoomNo'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function deleteFriend($friendID,$userID,$con){
  $stmt = $con->prepare("delete from friend where friendID  = '$friendID' and userID = '$userID'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}

function updateChattingRoomName($chattingRoomName,$userID,$chattingRoomNo,$con){
  $stmt = $con->prepare("update chattingRoom set chattingRoomName   = '$chattingRoomName ', joinDate=joinDate where userID = '$userID' and chattingRoomNo= '$chattingRoomNo'");
  if($stmt->execute())
      return 'TRUE';
  else
      return 'FALSE';
}
function checkID($id,$con){
//  include('dbConnect.php');
  $sql="select id from user where id='$id'";
  $stmt = $con->prepare($sql);
  $stmt->execute();
  if ($stmt->rowCount() == 0){
    return "TRUE";
  }
  else{
    return "FALSE";
  }
}
function memberJoin($id,$password,$name,$phone,$con){
    $stmt = $con->prepare("insert into user(id,password,name,phone) value ('$id','$password','$name','$phone')");
    if($stmt->execute())
        return 'TRUE';
    else
        return 'FALSE';
}
function updateUserPicture($userID,$con){
  $stmt = $con->prepare("update user set picture = '$userID.jpg' where id = '$userID'");
  if($stmt->execute())
      return 'TRUE';
  return 'FALSE';
}
function updateProfile($userID,$profile,$con){
  $stmt = $con->prepare("update user set profile = '$profile' where id = '$userID'");
  if($stmt->execute())
      return 'TRUE';
  return 'FALSE';
}
?>
