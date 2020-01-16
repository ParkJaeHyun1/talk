<?php

error_reporting(E_ALL);
ini_set('display_errors', 1);
include('dbConnect.php');
include('sqlFunction.php');

//POST 값을 읽어온다.
$id =  $_POST['id'];
echo checkID($id,$con);
?>
