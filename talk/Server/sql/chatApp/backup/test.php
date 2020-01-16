<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('dbConnect.php');
include('sqlFunction.php');

//POST 값을 읽어온다.
$userID =  'test';
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

$chattingRoom = selectChattingRoomList($userID,$con);
echo json_encode($chattingRoom,JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
?>
