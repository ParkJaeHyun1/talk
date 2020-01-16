<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>




<script type="text/javascript">
$(document).ready(function(){
	
	/*셀렉트박스*/
	
	
	var manufacture = $("select#manufacture");
    
	manufacture.change(function(){
        var select_name = $(this).children("option:selected").text();
        $(this).siblings("label").text(select_name);
        
    });    
	var machine = $("select#machine");
    
	machine.change(function(){
        var select_name = $(this).children("option:selected").text();
        $(this).siblings("label").text(select_name);
        
    });
	var capacity = $("select#capacity");
    
	capacity.change(function(){
        var select_name = $(this).children("option:selected").text();
        $(this).siblings("label").text(select_name);
        
    });
	
	$('#manufacture').change(function(){
		if($('#manufacture').val()=='samsung'){		
		
			$.ajax({
				url:"/phonefo/samsung",
				data:{"manufacture":"samsung"},
				success:function(result){
					
				}
				
			});	
		
			
			
		}else if($('#manufacture').val()=='lg'){
			
		$("option[value=Galaxy6]").remove();
		$("option[value=Galaxy5]").remove();


		}else{

		}
	});

	});

</script>
<style type="text/css">
[class*="entypo-"] {
	font-family: "entypo", sans-serif;
	text-decoration: none;
}

/* 로딩바&스피너 **************************************************************************/
.fade {
	transition: all 300ms linear 700ms;
	-webkit-transform: translate3d(0, 0, 0);
	-moz-transform: translate3d(0, 0, 0);
	-ms-transform: translate3d(0, 0, 0);
	-o-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
	opacity: 1;
}

.fade.out {
	opacity: 0;
}

#nprogress {
	pointer-events: none;
}

#nprogress .bar {
	background: #F0582A;
	position: fixed;
	z-index: 1000;
	top: 0;
	left: 0;
	width: 100%;
	height: 2px;
}
/* 블러 이펙트 */
#nprogress .peg {
	display: block;
	position: absolute;
	right: 0px;
	width: 100px;
	height: 100%;
	box-shadow: 0 0 10px #F0582A, 0 0 5px #F0582A;
	opacity: 1.0;
	-webkit-transform: rotate(3deg) translate(0px, -4px);
	-ms-transform: rotate(3deg) translate(0px, -4px);
	transform: rotate(3deg) translate(0px, -4px);
}

#nprogress .spinner {
	display: block;
	position: fixed;
	z-index: 1000;
	top: 15px;
	right: 15px;
}

#nprogress .spinner-icon {
	width: 18px;
	height: 18px;
	box-sizing: border-box;
	border: solid 2px transparent;
	border-top-color: #F0582A;
	border-left-color: #F0582A;
	border-radius: 50%;
	-webkit-animation: nprogress-spinner 400ms linear infinite;
	animation: nprogress-spinner 400ms linear infinite;
}

.nprogress-custom-parent {
	overflow: hidden;
	position: relative;
}

.nprogress-custom-parent #nprogress .spinner, .nprogress-custom-parent #nprogress .bar
	{
	position: absolute;
}

@
-webkit-keyframes nprogress-spinner { 0% {
	-webkit-transform: rotate(0deg);
}

100%
{
-webkit-transform




:


 


rotate




(360
deg


);
}
}
@
keyframes nprogress-spinner { 0% {
	transform: rotate(0deg);
}

100%
{
transform




:


 


rotate




(360
deg


);
}
}

/* 상단 메뉴 **************************************************************************/
.top_banner {
	float: left;
	position: relative;
	width: 100%;
	height: 115px;
	background:
		url(http://phonesada.co.kr/service/img/main/top_banner_bg.png) center;
}

.top_banner_box {
	position: relative;
	width: 100%;
	height: 0px;
}

.top_banner_img {
	position: absolute;
	width: 100%;
	text-align: center;
}

.top_banner_close {
	position: absolute;
	width: 100%;
	top: -115px;
}

.top_banner ul {
	width: 100%;
}

.top_banner ul li:first-child {
	float: left;
	position: relative;
	width: 50%;
	background: #FBE300;
	height: 115px;
}

.top_banner ul li {
	float: left;
	position: relative;
	width: 50%;
	background: #FF7B05;
	height: 115px;
}

.btn_top_banner_close {
	position: relative;
	width: 1200px;
	margin: 0 auto;
}

.btn_top_banner_close .test {
	position: absolute;
	right: 30px;
	top: 30px;
}

.logo_wrap {
	float: left;
	position: relative;
	width: 100%;
	background: url(http://phonesada.co.kr/service/img/main/top_logo_bg.png);
	border-bottom: 1px solid #000;
	padding: 20px;
}

.logo_box {
	position: relative;
	width: 1200px;
	margin: 0 auto;
}

.logo {
	text-align: center;
}

.logo_left_menu {
	position: absolute;
	top: 15px;
	left: 20px;
}

.logo_left_right_menu_01 {
	position: absolute;
	top: 15px;
	right: 20px;
}

.logo_left_right_menu_02 {
	position: absolute;
	top: 15px;
	right: 220px;
}

.top_menu_wrap {
	float: left;
	position: relative;
	width: 100%;
	background: url(http://phonesada.co.kr/service/img/main/menu_bg.png);
	border-top: 1px solid #555555;
}

.menu_wrap {
	position: relative;
	width: 1200px;
	margin: 0 auto;
}

.menu_wrap .menu {
	float: left;
	position: relative;
	width: 800px;
}

.menu_wrap .menu li {
	float: left;
	display: inline-block;
	padding: 20px 0;
	color: #fff;
	font-size: 19px;
	font-weight: 600;
	width: 160px;
	text-align: center;
	cursor: pointer;
}

.menu_wrap .menu_etc {
	float: left;
	position: relative;
	width: 400px;
}

.menu_wrap .menu_etc li {
	float: right;
	display: inline-block;
	padding: 20px 0;
	color: #fff;
	font-size: 19px;
	font-weight: 600;
	width: 160px;
	text-align: center;
}

/*.menu_any_box_default						{ width:70%; position: absolute; right:175px; -webkit-transition:all 0.45s ease-in-out; -moz-transition:all 0.45s ease-in-out; -o-transition:all 0.45s ease-in-out; -ms-transition:all 0.45s ease-in-out; transition:all 0.45s; }
.menu_any_box								{ width:70%; position: absolute; right:0; -webkit-transition:all 0.45s ease-in-out; -moz-transition:all 0.45s ease-in-out; -o-transition:all 0.45s ease-in-out; -ms-transition:all 0.45s ease-in-out; transition:all 0.45s; }*/

/* 컨텐츠 *****************************************************************************/
.container {
	width: 100%;
	overflow: hidden;
}

.visual_wrap {
	float: left;
	position: relative;
	width: 100%;
	background: url(http://phonesada.co.kr/service/img/main/v_bg.png);
	height: 383px;
}

.visual_box {
	width: 1200px;
	margin: 0 auto;
	text-align: center;
}

.visual_box	img {
	padding-top: 47px;
}

.content_wrap {
	float: left;
	position: relative;
	width: 100%;
	padding: 140px 0 0 0;
}

.content_box {
	position: relative;
	width: 1200px;
	margin: 0 auto;
}

.step_box {
	text-align: center;
}

.step_box li {
	padding-top: 50px;
}

.local_map {
	width: 1160px;
	height: 400px;
	margin: 0 auto;
	border: 3px solid #FF7B05;
	border-radius: 5px 5px 0 0;
	-moz-border-radius: 5px 5px 0 0;
	-webkit-border-radius: 5px 5px 0 0;
}

.service_center {
	position: relative;
	top: 0;
	left: 0;
	z-index: 100;
}

.service_center ul {
	position: absolute;
	top: 200px;
	left: -220px;
	z-index: 100;
}

.service_center ul li {
	padding-bottom: 10px;
}

.fade_view {
	display: none;
	width: 100%;
	overflow: hidden;
}

/* 버튼 스타일 */
.button_type_01 {
	display: block;
	margin: 0 auto;
	border: none;
	background: none;
	color: #fff;
	vertical-align: middle;
	position: relative;
	z-index: 1;
	border: 1px solid;
	border-radius: 5px;
	margin-top: 20px;
}

.button_type_02 {
	display: block;
	margin: 20px 0;
	border: none;
	background: none;
	color: inherit;
	vertical-align: middle;
	position: relative;
	z-index: 1;
	border: 1px solid;
	border-radius: 5px;
	-webkit-backface-visibility: hidden;
	-moz-osx-font-smoothing: grayscale;
}

.button {
	float: left;
	display: block;
	margin: 20px 0;
	border: none;
	background: none;
	color: inherit;
	vertical-align: middle;
	position: relative;
	z-index: 1;
	border: 1px solid;
	border-radius: 5px;
	-webkit-backface-visibility: hidden;
	-moz-osx-font-smoothing: grayscale;
}

.button--winona {
	overflow: hidden;
	padding: 0;
	-webkit-transition: border-color 0.3s, background-color 0.3s;
	transition: border-color 0.3s, background-color 0.3s;
	-webkit-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
	transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
}

.button--winona::after {
	content: attr(data-text);
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	opacity: 0;
	color: ##000;
	font-weight: 700;
	letter-spacing: -1px;
	-webkit-transform: translate3d(0, 25%, 0);
	transform: translate3d(0, 25%, 0);
}

.button--winona>span {
	display: block;
	font-weight: 700;
	letter-spacing: -1px;
}

.button--winona::after, .button--winona>span {
	padding: 15px 30px;
	-webkit-transition: -webkit-transform 0.3s, opacity 0.3s;
	transition: transform 0.3s, opacity 0.3s;
	-webkit-transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
	transition-timing-function: cubic-bezier(0.2, 1, 0.3, 1);
}

.button--winona:hover {
	border-color: #000;
	background-color: rgba(0, 0, 0, 0.1);
}

.button--winona:hover::after {
	opacity: 1;
	-webkit-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

.button--winona:hover>span {
	opacity: 0;
	-webkit-transform: translate3d(0, -25%, 0);
	transform: translate3d(0, -25%, 0);
}

.qna {
	margin-left: 10px;
}

.contact_wrap {
	float: left;
	position: relative;
	width: 100%;
}

.contact_wrap .contact_box {
	width: 1200px;
	margin: 0 auto;
}

.contact_wrap .contact_box .main_title {
	text-align: center;
	background: url(http://phonesada.co.kr/service/img/main/title_line.png)
		center;
	margin-top: 80px;
}

.main_title span {
	background: #fff;
	font-size: 35px;
	padding: 20px;
	font-weight: 600;
}

.main_title_ment {
	font-size: 18px;
	color: #9DA3A9;
	padding-top: 20px;
	text-align: center;
}

/* 하단 사업자 */
.copyright {
	float: left;
	position: relative;
	width: 100%;
	padding: 30px 0;
	background: #373737;
	color: #CECECE;
	font-size: 13px;
	margin-top: 50px;
}

.copyright ul {
	width: 1200px;
	margin: 0 auto;
}

.copyright ul li:first-child {
	float: left;
	position: relative;
	width: 340px;
	text-align: center;
}

.copyright ul li {
	float: left;
	position: relative;
	width: 860px;
}

.scrollup {
	position: fixed;
	bottom: 8px;
	right: 8px;
	width: 40px;
	background: url( http://phonesada.co.kr/service/img/main/icon_top.png )
		no-repeat center top;
	padding: 8px 13px;
	height: 40px;
	background-color: rgba(0, 0, 0, 0.5);
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: none;
	-webkit-transition: all 0.45s ease-in-out;
	-moz-transition: all 0.45s ease-in-out;
	-o-transition: all 0.45s ease-in-out;
	-ms-transition: all 0.45s ease-in-out;
	transition: all 0.45s ease-in-out;
	cursor: pointer;
}

.scrollup:hover {
	background-color: rgba(240, 88, 42, 1);
	background-position: center -40px;
}

.btn_counsel {
	background: #FF7B05;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	border: 1px solid #F0582A;
	cursor: pointer;
	color: #fff;
	font-size: 23px;
	padding: 20px;
	font-weight: 700;
	width: 50%;
}

.btn_counsel:hover {
	background-image: -webkit-gradient(linear, left top, left bottom, from(#8B8B8B),
		to(#8B8B8B));
	background-image: -webkit-linear-gradient(top, #8B8B8B, #8B8B8B);
	background-image: -moz-linear-gradient(top, #8B8B8B, #8B8B8B);
	background-image: -ms-linear-gradient(top, #8B8B8B, #8B8B8B);
	background-image: -o-linear-gradient(top, #8B8B8B, #8B8B8B);
	background-image: linear-gradient(to bottom, #8B8B8B, #8B8B8B);
	border: 1px solid #777777;
	color: #fff;
}

.btn_address {
	position: relative;
	height: 38px;
	background: #676D74;
	padding: 0 10px;
	color: #fff;
	border: 0px;
}

/******셀렉트 박스 *******/
td div {
	margin: 0 auto;
	width: 0px;
}

div#select_box {
	float: left;
	position: relative;
	width: 250px;
	height: 38px;
	background:
		url(http://phonesada.co.kr/service/img/main/select_arrow.png) #F8F8F8
		230px center no-repeat;
	border: 1px solid #E3E3E3;
}

div#select_box label {
	position: absolute;
	color: #666666;
	top: 7px;
	left: 12px;
	letter-spacing: 1px;
}

div#select_box select#color {
	width: 100%;
	height: 30px;
	min-height: 30px;
	line-height: 30px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0);
}
div#select_box select#manufacture {
	width: 100%;
	height: 30px;
	min-height: 30px;
	line-height: 30px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0);
}
div#select_box select#machine {
	width: 100%;
	height: 30px;
	min-height: 30px;
	line-height: 30px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0);
}
div#select_box select#capacity {
	width: 100%;
	height: 30px;
	min-height: 30px;
	line-height: 30px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0);
}

label.label_text {
	color: #727272;
	padding: 0 5px;
}

div#select_box_01 {
	float: left;
	position: relative;
	width: 150px;
	height: 38px;
	background:
		url(http://phonesada.co.kr/service/img/main/select_arrow.png) #F8F8F8
		130px center no-repeat;
	border: 1px solid #E3E3E3;
}

div#select_box_01 label {
	position: absolute;
	color: #666666;
	top: 7px;
	left: 12px;
	letter-spacing: 1px;
}

div#select_box_01 select#color {
	width: 100%;
	height: 30px;
	min-height: 30px;
	line-height: 30px;
	padding: 0 10px;
	opacity: 0;
	filter: alpha(opacity = 0);
}

input {
	position: relative;
	height: 38px;
	border: 1px solid #E3E3E3;
	background: #F8F8F8;
	padding: 0 10px;
}

textarea {
	position: relative;
	height: 100px;
	border: 1px solid #E3E3E3;
	background: #F8F8F8;
	padding: 10px;
}
/* 테이블 css */
table {
	text-align: left;
	margin-bottom: 20px;
}

.t_b_title {
	background: #FF7B05;
	color: #fff;
	font-weight: 600;
	font-size: 18px;
	text-align: center;
}

.t_b_title_01 {
	background: #676D74;
	color: #fff;
	font-weight: 600;
	font-size: 18px;
	text-align: center;
}

.t_s_title {
	background: #F3F3F3;
	color: #000;
	font-weight: 600;
	font-size: 15px;
}

/*라디오버튼*/
input[type=radio].css-checkbox {
	position: absolute;
	z-index: -1000;
	left: -1000px; overflow;
	clip: rect(0, 0, 0, 0);
	height: 1px;
	width: 1px;
	margin: -1px;
	padding: 0;
	border: 0;
}

input[type=radio].css-checkbox+label.radio-label {
	padding-left: 50px;
	height: 38px;
	display: inline-block;
	line-height: 36px;
	background-repeat: no-repeat;
	background-position: 0 0;
	vertical-align: middle;
	cursor: pointer;
}

label.radio-label1 {
	padding-left: 50px;
	height: 38px;
	display: inline-block;
	line-height: 36px;
	background-repeat: no-repeat;
	background-position: 0 0;
	vertical-align: middle;
	cursor: pointer;
}

input[type=radio].css-checkbox:checked+label.radio-label {
	background-position: 0 -38px;
}

label.radio-label {
	background-image:
		url(http://phonesada.co.kr/service/img/main/icon_radio.png);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/*체크박스*/
input[type=checkbox].css-checkbox {
	position: absolute;
	z-index: -1000;
	left: -1000px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	height: 1px;
	width: 1px;
	margin: -1px;
	padding: 0;
	border: 0;
}

input[type=checkbox].css-checkbox+label.checkbox-label {
	padding-left: 50px;
	height: 38px;
	display: inline-block;
	line-height: 38px;
	background-repeat: no-repeat;
	background-position: 0 0;
	vertical-align: middle;
	cursor: pointer;
}

input[type=checkbox].css-checkbox:checked+label.checkbox-label {
	background-position: 0 -38px;
}

label.checkbox-label {
	background-image:
		url(http://phonesada.co.kr/service/img/main/icon_checkbox.png);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/** 주소검색 박스 ***/
#mask {
	display: none;
	background: #000;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	opacity: 0.9;
	z-index: 999;
}

.popup {
	display: none;
	background: #fff;
	width: 500px;
	padding: 5px;
	border: 1px solid #000;
	float: left;
	font-size: 12px;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #000;
	-moz-box-shadow: 0px 0px 20px #000; /* Firefox */
	-webkit-box-shadow: 0px 0px 20px #000; /* Safari, Chrome */
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari, Chrome */
}

.pop_title {
	font-size: 17px;
	font-weight: 700;
	color: #FF7B05;
	padding: 10px;
	border-bottom: 1px solid #E3E3E3;
}

.btn_pop_close {
	position: absolute;
	margin: -27px 0 0 450px;
}

.pop_contact {
	width: 100%;
	padding: 15px 10px;
}

.pop_contact li {
	text-align: center;
}

.pop_contact span {
	font-size: 13px;
	font-weight: 600;
}

.add_input_box {
	padding: 20px 0;
	border-bottom: 1px solid #E3E3E3;
}

.pop_add_list {
	width: 100%;
	height: 180px;
	overflow-y: scroll;
	overflow-x: hidden;
	padding: 0 20px;
	margin-bottom: 20px;
}

.pop_add_list li {
	border-bottom: 1px solid #E3E3E3;
	padding: 10px 0;
}
</style>
</head>

<body>
<div class="page-banner">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2>중고폰 견적</h2>
					<p>정상해지 공기계</p>
				</div>
				<div class="col-md-6">
					<ul class="breadcrumbs">
						<li><a href="#">홈</a></li>
						<li>회원가입</li>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<div class="big-title text-center">
		<h1>중고폰 견적</h1>
		<p class="title-desc">아래의 내용에 따라 기입해 주시기 바랍니다.</p>
		<hr>
	</div>
	<div align="center">
		<img alt="" src="/resources/images/quote/tel..JPG">
	</div>
	<br>
	<br>
	<!-- 폼 양식 시작 -->


	<table width="1160px" border="0" cellspacing="1" cellpadding="10"
		bgcolor="#DADBDB" align="center">
		<tr>
			<td width="310px" height="60px" class="t_b_title">매각 선택</td>
			<td bgcolor="#FFFFFF"><input type="radio" name="radid_01"
				id="radio1" class="css-checkbox" checked="checked" /> <label
				for="radio1" class="radio-label">방문</label>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="radio" name="radid_01"
				id="radio2" class="css-checkbox" /> <label for="radio2"
				class="radio-label">택배</label></td>
		</tr>
	</table>

	<table width="1160px" border="0" cellspacing="1" cellpadding="10"
		bgcolor="#DADBDB" align="center">
		<tr>
			<td width="150" rowspan="7" valign="middle" class="t_b_title">휴대폰<br />정보
				입력
			</td>
			<td width="160" height="60" class="t_s_title">제조사</td>
			<td bgcolor="#FFFFFF">
				<div id="select_box">
					<label for="color" id="selec">제조사 선택</label> 
					<select id="manufacture"
						name="category">
						<option value="">제조사 선택</option>
						<option value="samsung">삼성</option>
						<option value="lg">LG</option>
						<option value="apple">애플</option>
					</select>
				</div> &nbsp&nbsp&nbsp
			</td>
		</tr>
		<tr>
			<td height="60" class="t_s_title">기기명</td>
			<td bgcolor="#FFFFFF">
				<div id="select_box">
					<label for="color">기기명 선택</label> <select id="machine"
						name="category">
					</select>
				</div> &nbsp&nbsp&nbsp
		</tr>
		<tr>
			<td height="60" class="t_s_title">용량</td>
			<td bgcolor="#FFFFFF">
				<div id="select_box">
					<label for="color">제조사 선택</label> <select id="capacity"
						name="category">
						<option value="">제조사 선택</option>
						<option value="kt">16GB</option>
						<option value="LGU+">32GB</option>
					</select>
				</div> &nbsp&nbsp&nbsp
		</tr>
		<tr>
			<td height="60" class="t_s_title">구매년월</td>
			<td bgcolor="#FFFFFF">
				<div id="select_box">
					<label for="color">년</label> <select id="color" name="date">
						<option value="2016">2016년</option>
						<option value="2015">2015년</option>
						<option value="2014">2014년</option>
						<option value="2013">2013년</option>
						<option value="2012">2012년</option>
						<option value="2011">2011년</option>
						<option value="2010">2010년</option>
						<option value="2009">2009년</option>
						<option value="2008">2008년</option>
						<option value="2007">2007년</option>
						<option value="2006">2006년</option>
						<option value="2005">2005년</option>
						<option value="2004">2004년</option>
						<option value="2003">2003년</option>
						<option value="2002">2002년</option>
						<option value="2001">2001년</option>
						<option value="2000">2000년</option>
						<option value="1999">1999년</option>
						<option value="1998">1998년</option>
						<option value="1997">1997년</option>
						<option value="1996">1996년</option>
						<option value="1995">1995년</option>
						<option value="1994">1994년</option>
						<option value="1993">1993년</option>
						<option value="1992">1992년</option>
						<option value="1991">1991년</option>
						<option value="1990">1990년</option>
						<option value="1989">1989년</option>
						<option value="1988">1988년</option>
						<option value="1987">1987년</option>
						<option value="1986">1986년</option>
						<option value="1985">1985년</option>
						<option value="1984">1984년</option>
						<option value="1983">1983년</option>
						<option value="1982">1982년</option>
						<option value="1981">1981년</option>
						<option value="1980">1980년</option>
						<option value="1979">1979년</option>
						<option value="1978">1978년</option>
						<option value="1977">1977년</option>
						<option value="1976">1976년</option>
						<option value="1975">1975년</option>
						<option value="1974">1974년</option>
						<option value="1973">1973년</option>
						<option value="1972">1972년</option>
						<option value="1971">1971년</option>
						<option value="1970">1970년</option>
						<option value="1969">1969년</option>
						<option value="1968">1968년</option>
						<option value="1967">1967년</option>
						<option value="1966">1966년</option>
						<option value="1965">1965년</option>
						<option value="1964">1964년</option>
						<option value="1963">1963년</option>
						<option value="1962">1962년</option>
						<option value="1961">1961년</option>
						<option value="1960">1960년</option>
						<option value="1959">1959년</option>
						<option value="1958">1958년</option>
						<option value="1957">1957년</option>
						<option value="1956">1956년</option>
						<option value="1955">1955년</option>
						<option value="1954">1954년</option>
						<option value="1953">1953년</option>
						<option value="1952">1952년</option>
						<option value="1951">1951년</option>
						<option value="1950">1950년</option>
						<option value="1949">1949년</option>
						<option value="1948">1948년</option>
						<option value="1947">1947년</option>
						<option value="1946">1946년</option>
						<option value="1945">1945년</option>
						<option value="1944">1944년</option>
						<option value="1943">1943년</option>
						<option value="1942">1942년</option>
						<option value="1941">1941년</option>
						<option value="1940">1940년</option>
						<option value="1939">1939년</option>
						<option value="1938">1938년</option>
						<option value="1937">1937년</option>
						<option value="1936">1936년</option>
						<option value="1935">1935년</option>
						<option value="1934">1934년</option>
						<option value="1933">1933년</option>
						<option value="1932">1932년</option>
					</select>
				</div>
				<div id="select_box">
					<label for="color">월</label> <select id="color" name="date">
						<option value="">월</option>
						<option value="01">01월</option>
						<option value="02">02월</option>
						<option value="03">03월</option>
						<option value="04">04월</option>
						<option value="05">05월</option>
						<option value="06">06월</option>
						<option value="07">07월</option>
						<option value="08">08월</option>
						<option value="09">09월</option>
						<option value="10">10월</option>
						<option value="11">11월</option>
						<option value="12">12월</option>
					</select>
				</div>
			</td>
		</tr>
		<tr>
			<td height="60" class="t_s_title">전원상태</td>
			<td bgcolor="#FFFFFF">
			<input type="radio" name="radid_02" id="radio3" class="css-checkbox" checked="checked" />
			 <label for="radio3" class="radio-label">작동</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			 <input type="radio" name="radid_02" id="radio4" class="css-checkbox" /> 
			 <label for="radio4" class="radio-label">미작동</label></td>

			</td>
		</tr>
		<tr>
			<td height="60" class="t_s_title">액정상태</td>
		<td bgcolor="#FFFFFF">
			<input type="radio" name="radid_03" id="radio5" class="css-checkbox" checked="checked" />
			 <label for="radio5" class="radio-label">파손</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			 
			 <input type="radio" name="radid_03" id="radio6" class="css-checkbox" /> 
			 <label for="radio6" class="radio-label">기스심함</label>
			 
			 <input type="radio" name="radid_03" id="radio7" class="css-checkbox" />
			 <label for="radio7" class="radio-label">기스보통</label>
			 
			 <input type="radio" name="radid_03" id="radio8" class="css-checkbox" />
			 <label for="radio8" class="radio-label">기스없음</label>
		</td>

		</tr>
		<tr>
			<td height="60" class="t_s_title">기기상태</td>
		<td bgcolor="#FFFFFF">
			 
			 <input type="radio" name="radid_04" id="radio9" class="css-checkbox" checked="checked"/> 
			 <label for="radio9" class="radio-label">기스심함</label>
			 
			 <input type="radio" name="radid_04" id="radio10" class="css-checkbox" />
			 <label for="radio10" class="radio-label">기스보통</label>
			 
			 <input type="radio" name="radid_04" id="radio11" class="css-checkbox" />
			 <label for="radio11" class="radio-label">기스없음</label>
		</td>

		</tr>
		
	</table>
		<table width="1160px" border="0" align="center" cellpadding="10" cellspacing="1">
	<br><br><br><br>
	<tr>
		<td height="60" align="center" ><button class="btn_counsel">견적보기</button></td>
	</tr>
</table>
<br><br><br>
</body>
</html>