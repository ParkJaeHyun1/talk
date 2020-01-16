<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$userID =  $_POST['userID'];
$friendID = $_POST['friendID'];
$friendNickName = $_POST['friendNickName'];

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
$result = array();
$stmt = $con->prepare("update friend set nickName = '$friendNickName' where userID = '$userID' and friendID = '$friendID'");
if($stmt->execute())
    echo 'TRUE';
else
    echo 'FALSE';

?>
