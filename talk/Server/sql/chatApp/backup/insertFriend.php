<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$userID =  $_POST['userID'];
$friendID = $_POST['friendID'];
$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

$stmt = $con->prepare("insert into friend(userID,friendID) value ('$userID','$friendID')");
if($stmt->execute()){
    $stmt = $con->prepare("select chattingRoomNo from friend where friendID = '$userID' and userID = '$friendID'");
    $stmt->execute();
    if ($stmt->rowCount()> 0){
        $row=$stmt->fetch(PDO::FETCH_ASSOC);
        $no = $row["chattingRoomNo"];
        if($no != NULL){
          $stmt2 = $con->prepare("update friend set chattingRoomNo = '$no'");
          $stmt2->execute();
      }
    }
    echo 'TRUE';
}else
    echo 'FALSE';

?>
