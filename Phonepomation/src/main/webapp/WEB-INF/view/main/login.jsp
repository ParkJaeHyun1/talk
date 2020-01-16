<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
@charset "UTF-8";
/* WMG 10576 */


/* 로그인 레이어 */
.pop_login_layer {box-sizing:border-box;position:fixed;width:504px;height:405px;left:50%;top:50%;margin-left:-247px;background:#fff;z-index:9999;text-align:left;font-family:'맑은 고딕',dotum,sans-serif;background:url(//www.saraminimage.co.kr/ui/common/bg_shadow.png) 0 0 no-repeat;font-size:12px;}
.pop_login_layer.no_shadow {position:static;width:494px;height:395px;background:none;left:0;top:0;margin:0;}
.pop_login_layer .outer {box-sizing:border-box;padding:42px 50px 0 50px;width:494px;height:395px;border:1px solid #666666;position:relative;background:#fff;}
.pop_login_layer.no_shadow .outer {border:1px solid #fff;}
.pop_login_layer .inner {width:392px;}
.pop_login_layer legend {display:block;position:relative;text-align:center;font-size:20px;font-weight:bold;color:#444;letter-spacing:-2px;font-family:'맑은 고딕',dotum,sans-serif;width:392px;height:auto;line-height:inherit;text-indent:0 !important;visibility:visible;left:auto !important;}
.pop_login_layer legend strong {color:#425ad4;}

.pop_login_layer .setting:after {content: "."; display: block; height: 0px; clear: both; visibility: hidden;}
.pop_login_layer .setting {position:relative;margin-top:28px;margin-bottom:7px;height:20px;line-height:20px;display: inline-block;}
.pop_login_layer .setting {display: block;}
* html .pop_login_layer .setting {height: 1%;}
.pop_login_layer .setting { zoom:1; }
.pop_login_layer .setting label {float:left;display:block;letter-spacing:-1px;height:16px;line-height:16px;color:#666;vertical-align:top;margin-right:15px;font-family:'맑은 고딕',dotum,sans-serif;}
.pop_login_layer .setting input {float:left;display:block;vertical-align:top;margin-top:3px;*margin-top:-1px;margin-right:5px;font-family:'맑은 고딕',dotum,sans-serif;}
.pop_login_layer .setting .dsc_ly {display:block;position:absolute;bottom:30px;left:-12px;*left:-8px;z-index:10;width:272px;height:55px;}
.pop_login_layer .setting .dsc_ly .btn_ly_close {display:block;position:absolute;top:0;right:0;width:17px;height:17px;background:url(//www.saraminimage.co.kr/ui/common/btn_login_ly_close.png) 50% 50% no-repeat;border:0 none;cursor:pointer;text-indent:-100%;*text-indent:0;white-space:nowrap;overflow:hidden;font-size:0;line-height:0;text-shadow:none;color:transparent;}
.pop_login_layer .setting .dsc_ly .dsc_arr {display:block;position:absolute;top:53px;left:12px;width:13px;height:8px;background:url(//www.saraminimage.co.kr/ui/common/btn_login_ly_arr.png) 0 0 no-repeat;line-height:normal;}
.pop_login_layer .setting .dsc_ly .dsc_txt {margin:0;padding:6px 10px 7px;line-height:20px;background-color:#fff;border:1px solid #bababa;font-size:11px;color:#888;letter-spacing:-1px;}
.pop_login_layer .setting .dsc_ly .dsc_txt strong {font-weight:normal;color:#555;}
.pop_login_layer .setting .ssl_login_box {float:left;box-sizing:border-box;position:relative;display:block;overflow:hidden;padding-right:33px;width:60px;height:20px;line-height:16px;font-size:12px;color:#666;vertical-align:top;font-family:'맑은 고딕',dotum,sans-serif;}
.pop_login_layer .setting .ssl_login_hide {position:absolute;top:-25px;left:0;z-index:-1;width:0;height:0;line-height:0;}
.pop_login_layer .setting .ssl_login_box .label_type {position:absolute;top:2px;right:0;display:block;width:29px;height:16px;background:url(//www.saraminimage.co.kr/ui/common/btn_autologin2_off.png) 0 0 no-repeat;text-indent:-9999px;cursor:pointer;margin:0;padding:0;vertical-align:top;}
.pop_login_layer .setting .ssl_login_box .label_type.on {background:url(//www.saraminimage.co.kr/ui/common/btn_autologin2_on.png) 0 0 no-repeat;}
.login-form {position:relative;width:392px;height:85px;}
.login-form label{position:absolute;top:0;left:0;box-sizing:border-box;padding:8px 20px;width:294px;height:40px;line-height:23px;margin:0;color: #959595;font-family:'맑은 고딕',dotum,sans-serif;font-size: 14px;font-weight: bold;z-index:2;}
.login-form input {position:absolute;box-sizing:border-box;padding:8px 20px;width:293px;height:40px;line-height:23px;margin:0;border:none;font-family:'맑은 고딕',dotum,sans-serif;font-weight: bold;font-size: 14px;color: #444;letter-spacing: 0;background-color: transparent;outline:0;z-index:1;}
.login-form .id-input-box{box-sizing:border-box;position:absolute;left:0;top:0;width:294px;height:43px;border-left:1px solid #cdcdcd;border-top:1px solid #cdcdcd;border-bottom:1px solid #e4e4e4;}
.login-form .pw-input-box{box-sizing:border-box;position:absolute;left:0;top:43px;width:294px;height:42px;border-left:1px solid #cdcdcd;border-bottom:1px solid #cdcdcd;}
.login-form .btn-login {position:absolute;left:400px;top:0;width:98px;height:85px;border:none;color:#fff;background:#6b80f1;font-family:'맑은 고딕',dotum,sans-serif;font-size:16px;font-weight:bold;cursor:pointer;}
.pop_login_layer .signup-forgotten {overflow:hidden;margin:18px 0 29px;position:relative;width:100%;height:16px;;font-family:'맑은 고딕',dotum,sans-serif;font-size:13px;letter-spacing:-1px;}
.pop_login_layer .signup-forgotten .sign-up {float:left;margin-right:10px;color:#666;font-weight:bold;text-decoration:none;}
.pop_login_layer .signup-forgotten .forgotten {float:left;color:#666;text-decoration:none;}
.pop_login_layer .signup-forgotten span {float:left;position:relative;margin-right:8px;width:1px;height:16px;background:url(//www.saraminimage.co.kr/ui/common/bg_vline.png) no-repeat 0 50%;padding:0;line-height:16px;display:block;font-size:0;zoom:1;}
.pop_login_layer .signup-forgotten .service_info_txt{position:absolute;right:0;}
.pop_login_layer .signup-forgotten .service_info_txt img {vertical-align:top;margin-left:6px;margin-top:2px;}
.pop_login_layer .signup-forgotten .service_info_txt:hover{color:#555;}
.social_login_layer{display:inline-block;*display:inline;zoom:1;width:100%;}
.social_login_layer:after{content:'';clear:both;display:block;}
.social_login_layer li {position:relative;display:block;zoom:1;float:left;width:50%;height:38px;background-color:#fff;box-sizing:border-box;margin-bottom:6px;}
.social_login_layer a {display:block;zoom:1;height:38px;border:1px solid #dddddd;padding-left:50px;font-family:"맑은 고딕", sans-serif;font-size:12px;color:#666;letter-spacing:-1px;line-height:34px;*line-height:36px;box-sizing: border-box;text-decoration:none;}
.social_login_layer .sl_naver{background:url('//www.saraminimage.co.kr/ui/social_login/icon_sns_naver_m.png') 20px 12px no-repeat;margin-right:3px;}
.social_login_layer .sl_facebook{background:url('//www.saraminimage.co.kr/ui/social_login/icon_sns_facebook_m.png') 22px 9px no-repeat;margin-left:3px;}
.social_login_layer .sl_kakao{background:url('//www.saraminimage.co.kr/ui/social_login/icon_sns_kakao_m.png') 17px 9px no-repeat;margin-right:3px;}
.social_login_layer .sl_google{background:url('//www.saraminimage.co.kr/ui/social_login/icon_sns_google_m.png') 18px 9px no-repeat;margin-left:3px;}

.pop_login_layer .pop_login_layer_close {position:absolute;top:0;right:0;border:0;width:43px;height:43px;text-indent:-100%;*text-indent:0;white-space:nowrap;overflow:hidden;font-size:0;line-height:0;text-shadow:none;color:transparent;background:url(//www.saraminimage.co.kr/ui/common/btn_login_close.png) no-repeat 50% 50%;cursor:pointer;}
.pop_login_layer .login-form input:-webkit-autofill {
    -webkit-box-shadow: 0 0 0 1000px white inset !important;
}
.pop_login_layer_local {width:494px;height:278px;background:none;-webkit-box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.15);-moz-box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.15);box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.15);}
.pop_login_layer_local .outer {height:278px;}
.pop_login_layer_local .signup-forgotten {margin-bottom:0;}

/* WMG-9514 start */
#srch_wrap input[type='text'] {font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif !important;}
#header .quick-search {box-sizing:border-box;width:600px;border:2px solid #425bd5;background:#fff;position:absolute;top:-1px;left:0;text-align:left;z-index:910;letter-spacing:-1px;}  /* differ */
#header .quick-search h4 {margin:0;padding:0;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif !important;}
#header .quick-search p {margin:0;padding:0;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif !important;}
#header .quick-search a {text-decoration:none;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif !important;}
#header .quick-lists {height:258px;box-sizing:border-box;}
#header .quick-lists .list-keyword {box-sizing:border-box;width:155px;height:258px;border-right:1px solid #ddd;position:absolute;top:0;left:0;overflow-x:hidden;overflow-y:auto;_display:inline;}
#header .quick-lists .list-keyword h4 {font-size:12px;height:15px;line-height:15px;padding:10px 0 0 9px;font-weight:normal;color:#888;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;}
#header .quick-lists .list-keyword li {background-color:#fff;display:block;height:25px;line-height:25px;position:relative;box-sizing:border-box;width:100%;padding:0 9px;font-size:13px !important;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;_display:inline;}
#header .quick-lists .list-keyword .list-keyword-recent li {padding-right:25px;}
#header .quick-lists .list-keyword li.on {background-color:#f0f0f0;}
#header .quick-lists .list-keyword li.current {background-color:#f0f0f0;}
#header .quick-lists .list-keyword li.last {border-bottom:1px solid #eee;padding-bottom:3px;height:28px;}
#header .quick-lists .list-keyword li a {display:block;width:100%;color:#444;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;font-size:13px !important;}
#header .quick-lists .list-keyword li strong {font-weight:bold;color:#425bd5;}
#header .quick-lists .list-keyword li button.btn_delete {display:block;position:absolute;top:0;right:0;width:25px;height:25px;background:url(//www.saraminimage.co.kr/ui/common/header/btn_close_7x7.gif) 50% 50% no-repeat;border:none;cursor:pointer;}
#header .quick-lists .list-recruitment {width:441px;height:258px;position:absolute;top:0;left:155px;overflow-x:hidden;overflow-y:auto;}
#header .quick-lists .list-recruitment li {display:block;background:#fff;border-bottom:1px solid #eee;position:relative;box-sizing:border-box;width:100%;height:75px;padding:9px 56px 10px 116px;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;margin:0;_display:inline;}
#header .quick-lists .list-recruitment li.more {height:112px;border-bottom:none;padding:0;text-align:center;}
#header .quick-lists .list-recruitment li.more em {font-style:normal !important;}
#header .quick-lists .list-recruitment li.more p {text-align:center;line-height:18px;padding:17px 0 7px 0;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;font-size:13px;}
#header .quick-lists .list-recruitment li.more p strong {font-weight:bold;color:#425bd5;}
#header .quick-lists .list-recruitment li.more a.btn_more {display:block;width:135px;height:27px;line-height:25px;background:#6b80f1;color:#fff;margin:0 auto;border:none;padding:0;position:relative;top:0;left:0;cursor:pointer;}
#header .quick-lists .list-recruitment li.on {background:#f0f0f0;}
#header .quick-lists .list-recruitment li a.logo {width:94px;height:46px;display:block;position:absolute;top:12px;left:10px;background:#fff;cursor:pointer;}
#header .quick-lists .list-recruitment li a.logo img {width:84px;height:32px;display:block;position:absolute;top:7px;left:5px;}
#header .quick-lists .list-recruitment li a.logo span {padding:0 5px;width:84px;height:46px;line-height:46px;text-align:center;display:block;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;font-size:13px;font-weight:bold;color:#555;}
#header .quick-lists .list-recruitment li a.scrap {width:43px;height:18px;display:block;position:absolute;top:25px;right:8px;cursor:pointer;}
#header .quick-lists .list-recruitment li a.scrap img {width:43px;height:18px;display:block;}
#header .quick-lists .list-recruitment li a.link {display:block;height:54px;color:#666;font-size:12px;cursor:pointer;}
#header .quick-lists .list-recruitment li a.link span.subject {margin-top:1px;font-size:13px;color:#444;text-overflow:ellipsis;white-space:nowrap;overflow:hidden;width:100%;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif !important;font-weight:normal !important;}
#header .quick-lists .list-recruitment li a.link span.subject strong {font-weight:bold !important;color:#425bd5 !important;}
#header .quick-lists .list-recruitment li a.link span.corp {text-overflow:ellipsis;white-space:nowrap;overflow:hidden;width:100%;}
#header .quick-lists .list-recruitment li a.link span.corp strong {font-weight:bold !important;color:#425bd5 !important;}
#header .quick-lists .list-recruitment li a.link span.meta {color:#ebebeb;font-size:11px;letter-spacing:-1px;}
#header .quick-lists .list-recruitment li a.link span.meta em {color:#888;font-style:normal;}
#header .quick-lists .list-recruitment li span {line-height:18px;height:18px;display:block;}
#header .quick-lists .list-recruitment li span.dday {width:56px;font-size:11px;position:absolute;top:46px;right:0;text-align:center;}
#header .quick-lists .list-recruitment li span.dday.final {color:#fe1c1c;}
#header .quick-lists .list-recruitment .no-result {padding-top:110px;line-height:22px;color:#333;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;font-size:14px;text-align:center;letter-spacing:-1px;}
#header .quick-lists .list-recruitment .no-result strong {font-weight:bold;color:#425bd5;}
#header .quick-links {padding-left:74px;height:94px;position:relative;border-top:#ddd 1px solid;}
#header .quick-links h4 {position:absolute;left:10px;top:9px;color:#777777;font-weight:bold;height:24px;line-height:24px;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;font-size:13px;}
#header .quick-links ul {padding:9px 0 13px 0;}
#header .quick-links ul li {height:24px;line-height:24px;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;font-size:13px;letter-spacing:-1px;}
#header .quick-links ul li a.fcy:link, #header .quick-links ul li a.fcy:visited {color:#777;}
#header .quick-links ul li a.fcy:hover, #header .quick-links ul li a.fcy:active {color:#444;text-decoration:underline;}
#header .quick-links ul li a.fcy:hover strong, #header .quick-links ul li a.fcy:active strong {text-decoration:underline;}
#header .quick-links ul li a strong {font-weight:bold;color:#425bd5;}
#header .quick-utils {height:30px;border-top:1px solid #eee;background:#fafafa;position:relative;}
#header .quick-utils a {display:block;height:30px;line-height:30px;position:absolute;top:0;font-family:dotum, sans-serif;font-size:11px;letter-spacing:-1px;color:#777;cursor:pointer;}
#header .quick-utils a:hover, #header .quick-utils a:active {text-decoration:none;}
#header .quick-utils a.btn_onoff {left:0;width:81px;text-align:center;color::#777;text-decoration:none !important;}
#header .quick-utils a.btn_onoff strong {font-weight:normal;text-decoration:none !important;}
#header .quick-utils a.btn_onoff strong.btn_on {display:inline-block;}
#header .quick-utils a.btn_onoff strong.btn_off {display:none;}
#header .quick-utils a.btn_close {right:0;width:52px;background:url(//www.saraminimage.co.kr/ui/common/header/btn_close_7x7.gif) 25px 2px no-repeat;}
#header .quick-utils a.btn_close span {display:block;padding-right:23px;text-align:right;height:30px;line-height:30px;}
#header .quick-guide {display:none;height:130px;}
#header .quick-guide p {line-height:22px;padding-top:45px !important;font-family: Malgun Gothic, "맑은 고딕", dotum, sans-serif;font-size:13px;letter-spacing:-1px;text-align:center;}
#header .quick-guide a {font-weight:bold;color:#6b80f1;text-decoration:underline !important;}
#header .quick-search.off {width:406px;height:165px;} /* differ */
#header .quick-search.off .quick-guide {display:block;}
#header .quick-search.off .quick-lists {display:none;}
#header .quick-search.off .quick-links {display:none;}
#header .quick-search.off .quick-utils a.btn_onoff strong {color:#425bd5;}
#header .quick-search.off .quick-utils a.btn_onoff strong.btn_on {display:none;}
#header .quick-search.off .quick-utils a.btn_onoff strong.btn_off {display:inline-block;}
/* WMG-9514 end */

</style>

</head>


<script type="text/javascript">
	$(document).ready(function(){
		$("#login").click(function(){
			$.ajax({
				
				url:"/phonefo/confirm_member",
				data:{userid:$('#userid').val(),
					  userpwd:$('#userpwd').val()
				},
				success:function(result){
					if(result=='성공')
						location.href='/phonefo/main'
					else
						alert('아이디 또는 비밀번호가 일치하지 않습니다.');
					$('#userid').val('');
					$('#userpwd').val('');
					$('#userid').focus();
					
				}
			});
		});
		$("#login2").click(function(){
			$.ajax({
				
				url:"/phonefo/confirm_business_member",
				data:{userid:$('#userid2').val(),
					  userpwd:$('#userpwd2').val()
				},
				success:function(result){
					if(result=='성공')
						location.href='/phonefo/main'
					else
						alert('아이디 또는 비밀번호가 일치하지 않습니다.');
					$('#userid2').val('');
					$('#userpwd2').val('');
					$('#userid2').focus();
					
				}
			});
		});	
	});
</script>

<body>
<!-- Start Page Banner -->
    <div class="page-banner">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2>로그인</h2>
                    <p>일반회원/기업회원</p>
                </div>
                <div class="col-md-6">
                    <ul class="breadcrumbs">
                        <li><a href="#">홈</a>
                        </li>
                        <li>로그인</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End Page Banner -->
    
            <!-- Start content -->
        <div id="content">
            <div class="container">
                <div class="big-title text-center">
                    <h1> <span class="accent-color">PhoneFormation</span>에 오신것을 환영합니다.</h1>
                    <p class="title-desc">저희 PhoneFormation은 개인회원과 기업회원 로그인이 가능합니다.</p>
                </div>
             
                <div class="hr5 margin-40"></div>
                <h3 style="font: bold;">로그인이 필요한 서비스입니다.</h3>
                PhoneFormation 회원이 아니면 지금, <font color="blue">회원가입</font>을 해주세요.<br><br>
				
				 <!-- Nav Tabs -->
                            <ul class="nav nav-tabs" style="width: 600px;">
                                <li class="active" style="width: 300px;text-align: center;"><a href="#tab-1" data-toggle="tab">개인회원</a>
                                </li>
                                <li style="width: 300px;text-align: center;"><a href="#tab-2" data-toggle="tab"></i>기업회원</a>
                                </li>
                            </ul>

                            <!-- Tab panels -->
                            <div class="tab-content" style="width: 600px;">
                                <!-- Tab Content 1 -->
                                <div class="tab-pane fade in active" id="tab-1">
                                   	<br>
                                   	

			<!-- input box -->
            <div class="setting">
				<input id="autologin" name="autologin" type="checkbox" onclick="if (this.checked) { $('ly_autologin').show() } else { $('ly_autologin').hide() }">
				<label for="autologin"> 로그인 유지 </label>
				<div class="dsc_ly" id="ly_autologin" style="display:none;">
					<button class="btn_ly_close" type="button" onclick="$('ly_autologin').hide()">닫기</button>
					<span class="dsc_arr"></span>
					<p class="dsc_txt">
						<strong>[개인회원 전용]</strong><br>
						개인정보 보호를 위해 개인 PC에서만 이용해 주세요.
					</p>
				</div>
				<input id="id_save" name="id_save" type="checkbox" >
                <label for="id_save">아이디 저장</label>
                <span class="ssl_login_box">
                    보안
                    <input type="checkbox" id="ssl_login" title="보안접속" class="ssl_login_hide" checked="checked">
                    <label for="ssl_login" id="label_type" class="label_type on">보안접속</label>
                </span>
            </div>
			<div class="login-form" sty>
				<div class="id-input-box focus" style="width: 420px;">
	    			
	    			<input type="text" id="userid" name="userid" class="txt_tool" value="" placeholder="아이디">
	    		</div>
	    		<div class="pw-input-box" style="width: 420px;">
	    			<label id="password-label" for="password"></label>
	    			<input  placeholder="비밀번호" type="password" id="userpwd" name="userpwd" class="txt_tool" value="" maxlength="32" onkeyup="if(this.value.length==32) alert('비밀번호는 영문,숫자,특수문자 조합 6~32자 입니다.');"  onblur="if((0 < this.value.length && this.value.length < 4) || this.value.length > 32 ){ alert('비밀번호는 영문,숫자,특수문자 조합 6~32자 입니다.');}">
	    		</div>
	    		<button type="submit" class="btn-login" id="login" >로그인</button>
	    	</div>
	    	<br>
	    	<div>
	    	<p class="signup-forgotten">
	    		<a href="/phonefo/join" class="sign-up">회원가입</a>
	    		<span>l</span>
	    		<a href="/zf_user/helpdesk/idpw-find" class="forgotten">아이디/비밀번호 찾기</a>
	    		<span>l</span>
	    		<a href="/zf_user/help" class="service_info_txt">서비스 안내</a>
	    	</p>
	    	  <ul class="social_login_layer" style="display: inline-block;">
                        <li><a href="/zf_user/auth/sign-in-with?provider=naver.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_naver">네이버 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=facebook.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_facebook">페이스북 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=kakao.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_kakao">카카오 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=google.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_google">구글 로그인</a></li>
                    </ul>

	    	</div>




    								
    				

                                    </div>

                                <!-- Tab Content 2 -->
                                <div class="tab-pane fade" id="tab-2">
                                <br>
                                 			<!-- input box -->
            <div class="setting">
				<input id="autologin" name="autologin" type="checkbox" onclick="if (this.checked) { $('ly_autologin').show() } else { $('ly_autologin').hide() }">
				<label for="autologin"> 로그인 유지 </label>
				<div class="dsc_ly" id="ly_autologin" style="display:none;">
					<button class="btn_ly_close" type="button" onclick="$('ly_autologin').hide()">닫기</button>
					<span class="dsc_arr"></span>
					<p class="dsc_txt">
						<strong>[개인회원 전용]</strong><br>
						개인정보 보호를 위해 개인 PC에서만 이용해 주세요.
					</p>
				</div>
				<input id="id_save" name="id_save" type="checkbox" >
                <label for="id_save">아이디 저장</label>
                <span class="ssl_login_box">
                    보안
                    <input type="checkbox" id="ssl_login" title="보안접속" class="ssl_login_hide" checked="checked">
                    <label for="ssl_login" id="label_type" class="label_type on">보안접속</label>
                </span>
            </div>
			<div class="login-form" sty>
				<div class="id-input-box focus" style="width: 420px;">
	    			
	    			<input type="text" id="userid2" name="userid2" class="txt_tool" value="" placeholder="아이디">
	    		</div>
	    		<div class="pw-input-box" style="width: 420px;">
	    			<label id="password-label" for="password"></label>
	    			<input  placeholder="비밀번호" type="password" id="userpwd2" name="userpwd2" class="txt_tool" value="" maxlength="32" onkeyup="if(this.value.length==32) alert('비밀번호는 영문,숫자,특수문자 조합 6~32자 입니다.');"  onblur="if((0 < this.value.length && this.value.length < 4) || this.value.length > 32 ){ alert('비밀번호는 영문,숫자,특수문자 조합 6~32자 입니다.');}">
	    		</div>
	    		<button type="submit" class="btn-login" id="login2">로그인</button>
	    	</div>
	    	<br>
	    	<div>
	    	<p class="signup-forgotten">
	    		<a href="/phonefo/join" class="sign-up">회원가입</a>
	    		<span>l</span>
	    		<a href="/phonefo/join" class="forgotten">아이디/비밀번호 찾기</a>
	    		<span>l</span>
	    		<a href="/phonefo/join" class="service_info_txt">서비스 안내</a>
	    	</p>
	    		    	  <ul class="social_login_layer" style="display: inline-block;">
                        <li><a href="/zf_user/auth/sign-in-with?provider=naver.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_naver">네이버 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=facebook.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_facebook">페이스북 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=kakao.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_kakao">카카오 로그인</a></li>
                        <li><a href="/zf_user/auth/sign-in-with?provider=google.com&amp;display=popup&url=%2Fzf_user%2Fauth%3Furl%3D%252Fzf_user%252F" target="_blank" onclick="window.open(this.href, '_blank', 'width=480,height=640'); return false;" class="sl_google">구글 로그인</a></li>
                    </ul>

	    	</div>
                                 
                                </div>
                            </div>
                            <!-- End Tab Panels -->
               
               </div>
            </div>
   
        <!-- End content -->


</body>
</html>