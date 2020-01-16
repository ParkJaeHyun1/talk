<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('dbConnect.php');
include('sqlFunction.php');

//POST 값을 읽어온다.
$userID =  $_POST['userID'];
$chattingRoomName = $_POST['chattingRoomName'];
$chattingRoomNo = (int)$_POST['chattingRoomNo'];

echo updateChattingRoomName($chattingRoomName,$userID,$chattingRoomNo,$con);
?>
