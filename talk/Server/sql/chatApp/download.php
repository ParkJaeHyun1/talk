<?php
$dir = "uploads/";         // 파일이 저장되어 있는 폴더 설정



function goBack($msg=', $url=') {
   echo "";
}

//▶ 외부에서 접근시에 에러 출력하는 부분으로 테스트 하실 때에는 주석처리 하시는 것이 좋습니다..^^
/*
if(!$_SERVER["HTTP_REFERER"] || !ereg(str_replace(".","\\.",$_SERVER["HTTP_HOST"]), $_SERVER["HTTP_REFERER"])) {
   goBack("정상적인 방법으로 다운로드해 주세요.");
   exit;
}
*/

/*
이 부분에 DB 에서 다운로드할 파일정보를 읽어옮

예: $row = mysql_fetch_array(mysql_query("select real_file_name, new_file_name from 테이블명 where no = '$no'"));
테스트를 위해선 $row[0] 와 $row[1] 을 지정해서 테스트하세요.

$row[0] = "testfile.jpg";
$row[1] = "6548d22b85bdc59a2145e7a1ee9b0788";
*/

$real_name = stripslashes($row[0]);
$save_name = $dir.stripslashes($row[1]);

//▶ 만약 파일이 없을 경우 에러출력
if(!file_exists($save_name)) {
   goBack("다운로드할 파일을 찾을 수 없습니다.");
   exit;
} else {// 파일이 있으면 다운로드
   if(eregi("(MSIE 5.0|MSIE 5.1|MSIE 5.5|MSIE 6.0)", $_SERVER["HTTP_USER_AGENT"]) && !eregi("(Opera|Netscape)", $_SERVER["HTTP_USER_AGENT"])) {
      Header("Content-type: application/octet-stream");
      Header("Content-Length: ".filesize($save_name));
      Header("Content-Disposition: attachment; filename=".$real_name);
      Header("Content-Transfer-Encoding: binary");
      Header("Pragma: no-cache");
      Header("Expires: 0");
   } else {
      Header("Content-type: file/unknown");
      Header("Content-Length: ".filesize($save_name));
      Header("Content-Disposition: attachment; filename=".$real_name);
      Header("Content-Description: PHP3 Generated Data");
      Header("Pragma: no-cache");
      Header("Expires: 0");
   }
   $fp = fopen($save_name, "rb");
   if(!fpassthru($fp)) fclose($fp);
}
?>
