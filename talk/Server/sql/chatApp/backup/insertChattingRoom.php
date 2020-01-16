<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$type =  $_POST['type'];

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
$stmt = $con->prepare("insert into chattingRoom(type) value ($type)");

if($stmt->execute()){
    $stmt = $con->prepare("select max(no) as max from chattingRoom");
    $stmt->execute();

    $row=$stmt->fetch(PDO::FETCH_ASSOC);
    $max = $row['max'];
    echo $max;
}else
    echo 'FALSE';
?>
