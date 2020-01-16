<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('sqlFunction.php');
include('dbConnect.php');


//POST 값을 읽어온다.
$type =  $_POST['type'];

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
echo insertChattingRoomType($type,$con);
?>
