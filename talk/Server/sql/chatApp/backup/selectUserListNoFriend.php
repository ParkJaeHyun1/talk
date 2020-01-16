<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);

include('dbConnect.php');


//POST 값을 읽어온다.
$memberList = json_decode($_POST['memberList'],JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);

$android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
$result = array();
foreach($memberList as $member){
    $memberID = $member;
    $stmt = $con->prepare("select id,name,picture,profile from user where id='$memberID'");
    $stmt->execute();
    $row=$stmt->fetch(PDO::FETCH_ASSOC);
    array_push($result,array('id'=>$row["id"],
        'name'=>$row["name"],
        'profile'=>$row["profile"],
        'picture'=>$row["picture"]));
}
echo json_encode($result,JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
?>
