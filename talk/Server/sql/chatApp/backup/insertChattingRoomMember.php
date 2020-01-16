<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$chattingRoomNo =  $_POST['chattingRoomNo'];
$memberList = json_decode($_POST['memberList'],JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

foreach($memberList as $member){
    $memberID = $member;
    $stmt = $con->prepare("insert into chattingRoomMember(userID,chattingRoomNo ) value ('$memberID','$chattingRoomNo')");
    $stmt->execute();
}
?>
