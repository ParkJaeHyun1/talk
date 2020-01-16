<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$userID =  $_POST['userID'];
$searchID = $_POST['searchID'];
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
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

echo json_encode($result,JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
?>