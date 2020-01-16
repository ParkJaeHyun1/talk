<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">

<head>

<style type="text/css">
.util_option{position:absolute;right:3px;top:0;}
.util_option .util_menu{position:relative;display:block;height:31px;float:left;padding:0 0 0 0;text-align:left;line-height:27px;line-height:26px\0;}
.util_option .util_mypage{letter-spacing:0;padding-right:13px;background:url(//www.saraminimage.co.kr/ui/top/util_arrow.png) no-repeat 100% 7px;}
.util_option .bounce{display:block;position:absolute;top:8px;right:0;width:13px;height:13px;background:url(//www.saraminimage.co.kr/ui/top/ico_new.png) 0 0 no-repeat;vertical-align:top;}
.util_option .name{padding:0 5px 0 0;}
.util_option .push_alarm{padding-right:0;text-decoration:none;}
.util_option .notif_gnb_cnt_box{width:80px;}
.util_option .last{padding-right:0;}
.util_option .company_logout{margin-right:0;padding-right:0;background:none;}
.membership-pop{position:absolute;left:1px;top:31px;z-index:20;width:117px;background:#fff;border:1px solid #a1a1a1;}
.membership-pop ul{margin:9px 0 12px 17px}
.membership-pop li{margin-left:auto;font-family: Malgun Gothic, "맑은 고딕", NanumGothic, "나눔고딕", sans-serif;text-align:left;line-height:23px;}
.membership-pop li a{color:#666;font-size:11px;letter-spacing:-1px;font-family: Malgun Gothic, "맑은 고딕", NanumGothic, "나눔고딕", sans-serif;text-decoration:none;}
.membership-pop li a:hover{text-decoration:underline;}

</style>



</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#logout').click(function() {
			$.ajax({
				url : "/phonefo/logout",
				success : function() {
					location.href = '/phonefo/main';

				}
			});
		});
	});
</script>

<body>

	<!-- Full Body Container -->


	<!-- Start Header Section -->
	<div class="hidden-header"></div>
	<header class="clearfix">

		<!-- Start Top Bar -->
		<div class="top-bar">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<!-- Start Contact Info -->
						<ul class="contact-details">
							<li><a href="#"><i class="fa fa-phone"></i> +12 345 678
									000</a></li>
							<li><a href="#"><i class="fa fa-envelope-o"></i>
									info@yourcompany.com</a></li>
						</ul>
						<!-- End Contact Info -->
					</div>
					<!-- .col-md-6 -->
					<div class="col-md-6">
						<!-- Start Social Links -->
						<ul class="social-list">

							<c:if test="${loginVO ==null}">
								<li><a href="/phonefo/login"
									class="btn-custom btn-small border-btn btn-gray">로그인</a></li>
								<li><a href="/phonefo/join"
									class="btn-custom btn-small border-btn btn-gray">회원가입</a></li>
							</c:if>
							<c:if test="${loginVO !=null}">
								<div class="util_option">
									<strong class="util_menu name"><font color="blue">${username}</font>님&nbsp</strong>
									<div id="person_header_btn" class="util_menu v_line"
										onmouseover="try{showSubTab('person_header_btn')}catch(e){}"
										onmouseout="try{hideSubTab('person_header_btn')}catch(e){}">
										<a href="/zf_user/member/persons/main" class="util_mypage">마이페이지</a>
										<div class="membership-pop"
											style="width: 110px; display: none;">
											<ul>
												<li><a
													href="/zf_user/member/resume-manage/select-template"><strong>이력서
															등록하기</strong></a></li>
												<li><a href="/zf_user/resume/resume-manage"><strong>내
															이력서 관리</strong></a></li>
												<li><a href="/zf_user/persons/apply-status-list"><strong>입사지원
															현황</strong></a></li>
												<li><a href="/zf_user/persons/person-update">개인정보
														수정</a></li>
												<li><a href="/zf_user/member/tailor-recruit">맞춤
														채용정보</a></li>
												<li><a href="/zf_user/persons/scrap-recruit">스크랩한
														채용공고</a></li>
												<li><a href="/zf_user/member/favor-company/list">관심기업정보</a></li>
											</ul>
										</div>
									</div>
									
									<a class="util_menu v_line" id="logout">로그아웃</a>
									<a href="javascript:void(0);" id="push-alarm"
										class="util_menu push_alarm last"
										onclick="gnb_notif_run.gnbNotifToggle()"></a>
								</div>




							</c:if>

						</ul>
						<!-- End Social Links -->
					</div>
					<!-- .col-md-6 -->
				</div>
				<!-- .row -->
			</div>
			<!-- .container -->
		</div>
		<!-- .top-bar -->
		<!-- End Top Bar -->

		<!-- Start  Logo & Naviagtion  -->
		<div class="navbar navbar-default navbar-top">
			<div class="container">
				<div class="navbar-header">
					<!-- Stat Toggle Nav Link For Mobiles -->
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<i class="fa fa-bars"></i>
					</button>
					<!-- End Toggle Nav Link For Mobiles -->
					<a class="navbar-brand" href="/phonefo/main"> <img alt=""
						src="/resources/images/phoneformation.png" width="200px">
					</a>
				</div>
				<div class="navbar-collapse collapse">
					<!-- Start Navigation List -->
					<ul class="nav navbar-nav navbar-right">
						<li><a class="active" href="">최신폰</a>
							<ul class="dropdown">
								<li><a class="active" href="/phonefo/information">삼성</a></li>
								<li><a href="">LG</a></li>
								<li><a href="homepage-2.html">애플</a></li>
							</ul></li>
						<li><a href="about.html">견적</a>
							<ul class="dropdown">
								<li><a href="/phonefo/secondHand">중고</a></li>
								<li><a href="about.html">수리</a></li>
							</ul></li>
						<li><a href="/phonefo/payment/skt">요금제</a>
							<ul class="dropdown">
								<li><a href="/phonefo/payment/skt">SKT</a></li>
								<li><a href="buttons.html">KT</a></li>
								<li><a href="testimonials.html">LG</a></li>
							</ul></li>
						<li><a href="portfolio-3.html">이벤트</a>
							<ul class="dropdown">
								<li><a href="/phonefo/boardlist?tno=1">KT</a></li>
								<li><a href="/phonefo/boardlist?tno=2">LGU+</a></li>
								<li><a href="/phonefo/boardlist?tno=3">SKT</a></li>
							</ul></li>
						<li><a href="blog.html">게시판</a>
							<ul class="dropdown">
								<li><a href="/phonefo/boardlist?tno=4">공지사항</a></li>
								<li><a href="/phonefo/boardlist?tno=5">자유게시판</a></li>
							</ul></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
					<!-- End Navigation List -->
				</div>
			</div>
		</div>
		<!-- End Header Logo & Naviagtion -->

	</header>

	<!-- Venue JS  -->

</body>
</html>