<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('sqlFunction.php');
include('dbConnect.php');


//POST 값을 읽어온다.
$chattingRoomNo =  $_POST['chattingRoomNo'];
$memberList = json_decode($_POST['memberList'],JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
insertChattingroom($chattingRoomNo,$memberList,$con);

?>
