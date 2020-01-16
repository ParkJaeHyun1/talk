<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('dbConnect.php');
include('sqlFunction.php');

//POST 값을 읽어온다.
$userID =  $_POST['userID'];
$searchID = $_POST['searchID'];
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
$result = selectUser($searchID,$userID,$con);

echo json_encode($result,JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
?>
