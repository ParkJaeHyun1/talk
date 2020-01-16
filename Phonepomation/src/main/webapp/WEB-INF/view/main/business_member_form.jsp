<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>




<script type="text/javascript">
	var idStatus = 0;
	var pwdStatus = 0;
	var pwd2Status = 0;
	var usernameStatus = 0;
	var email1Status = 0;
	var email2Status = 0;
	var tel2Status = 0;
	var tel3Status = 0;
	var rootStatus = 0;

	$(document)
			.ready(
					function() {

						$('#userid').keyup(function() {
							$.ajax({
								url : "/phonefo/checkBId",
								data : {
									userid : $("#userid").val()
								},
								success : function(result) {
									//출력할곳 정하기
									$('#checkId').html(result);
									if (result.indexOf('가능한') == -1)//가입불가 
										idStatus = -1;
									else
										idStatus = 1;

								}
							});
						});

						$('#userpwd').keyup(function() {
							$.ajax({
								url : "/phonefo/checkPwd",
								data : {
									userpwd : $('#userpwd').val()
								},
								success : function(result) {
									$('#checkPwd').html(result);
									if (result.indexOf('비밀번호') == -1)//가입불가
										pwdStatus = -1;
									else
										pwdStatus = 1;

								}
							});
						});

						$('#userpwd2')
								.keyup(
										function() {
											var userpwd = $('#userpwd').val();
											var userpwd2 = $('#userpwd2').val();

											if (userpwd != userpwd2) {
												$('#checkPwd2')
														.html(
																'<font color="red">비밀번호가 일치하지 않습니다.</font>');
												pwd2Status = -1;
											} else {
												$('#checkPwd2')
														.html(
																'<font color="blue">비밀번호가 일치합니다.</font>');
												pwd2Status = 1;
											}
										});

						$('#username')
								.keyup(
										function() {
											var regex = /^[a-zA-z가-힣]{2,12}$/;
											if (!regex.test($('#username')
													.val())) {
												$('#usernameCheck')
														.html(
																'<font color="red">2~12자의 한글, 영문만 사용 가능합니다.</font>');
												usernameStatus = -1;
											} else {
												$('#usernameCheck').html('');
												usernameStatus = 1;
											}
										});

						$('#email1')
								.keyup(
										function() {
											var regex = /^[a-zA-z0-9]{2,15}$/;
											if (!regex.test($('#email1').val())) {
												$('#emailCheck1')
														.html(
																'<font color="red">이메일을 올바르게 입력해 주세요.</font>');
												email1Status = -1;
											} else {
												$('#emailCheck1').html('');
												email1Status = 1;
											}
										});

						$('#email2')
								.keyup(
										function() {
											var regex = /^[0-9a-zA-Z]*[.][a-zA-Z]{2,3}$/;

											if (!regex.test($('#email2').val())) {
												$('#emailCheck1')
														.html(
																'<font color="red">이메일을 올바르게 입력해 주세요.</font>');
												email2Status = -1;
											} else {
												$('#emailCheck1').html('');
												email2Status = 1;
											}
										});

						$('#selectEmail').change(function() {
							$('#email2').val($('#selectEmail').val());
							$('#emailCheck1').html('');
						});

						$('#tel2')
								.keyup(
										function() {
											var reg = /^[0-9]{3,4}$/;
											if (!reg.test($('#tel2').val())) {
												$('#telCheck')
														.html(
																'<font color="red">번호 형식이 올바르지 않습니다. </font>');
												tel2Status = -1;
											} else {
												$('#telCheck').html('');
												tel2Status = 1;
											}
										});
						$('#tel3').keyup(
										function() {
											var reg = /^[0-9]{4}$/;
											if (!reg.test($('#tel3').val())) {
												$('#telCheck')
														.html(
																'<font color="red">번호 형식이 올바르지 않습니다.</font>');
												tel3Status = -1;
											} else {
												$('#telCheck').html('');
												tel3Status = 1;
											}
										});
						
						$('#businessNum1').keyup(function(){
							
							var reg=/^[0-9]{3}$/;
							if(!reg.test($('#businessNum1').val())){
								$('#certifyCheck').html('<font color="red">올바르지 않는 사업자등록 번호입니다.</font>');
							}else{
								$('#certifyCheck').html('');
							}
						});
						$('#businessNum2').keyup(function(){
							
							var reg=/^[0-9]{2}$/;
							if(!reg.test($('#businessNum2').val())){
								$('#certifyCheck').html('<font color="red">올바르지 않는 사업자등록 번호입니다.</font>');
							}else{
								$('#certifyCheck').html('');
							}
						});
						$('#businessNum3').keyup(function(){
							
							var reg=/^[0-9]{5}$/;
							if(!reg.test($('#businessNum3').val())){
								$('#certifyCheck').html('<font color="red">올바르지 않는 사업자등록 번호입니다.</font>');
							}else{
								$('#certifyCheck').html('');
							}
						});
						

						$('#birth2').change(
								function() {
									if ($('#birth2').val() == 1) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value="+i+">" + i
															+ "일</option>");
										}
									} else if ($('#birth2').val() == 2) {
										for (var i = 1; i < 29; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 3) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 4) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 5) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 6) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 7) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 8) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 9) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 10) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value="+i+">" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 11) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 12) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value=''>" + i
															+ "일</option>");
										}
									}

								});

					});

	function check() {

		if ($('#userid').val() == '' || idStatus == -1) {
			alert('아이디를 확인하세요');
			$('#userid').focus();
		} else if ($('#userpwd').val() == '' || pwdStatus == -1) {
			alert('비밀번호를 확인하세요');
			$('#userpwd').focus();
		} else if ($('#userpwd2').val() == '' || pwd2Status == -1) {
			alert('비밀번호를 확인하세요');
			$('#userpwd2').focus();
		} else if ($('#username').val() == '' || usernameStatus == -1) {
			alert('이름을 확인하세요');
			$('#username').focus();
		} else if ($('#birth1').val() == '' || $('#birth2').val() == ''
				|| $('#birth3').val() == '') {
			alert('생년월일을 확인하세요')
			$('#birth1').focus();
		} else if ($('#email1').val() == '' || email1Status == -1) {
			alert('이메일을 확인하세요');
			$('#email1').focus();
		} else if ($('#email2').val() == '' || email2Status == -1) {
			alert('이메일을 확인하세요');
			$('#email2').focus();
		} else if ($('#tel2').val() == '' || tel2Status == -1) {
			alert('휴대폰 번호를 확인하세요');
			$('#tel2').focus();
		} else if ($('#tel3').val() == '' || tel3Status == -1) {
			alert('휴대폰 번호를 확인하세요');
			$('#tel3').focus();
		} else if ($('#root').val() == '') {
			alert('선택사항을 골라 주세요');
			$('#root').focus();
		} else {
			document.frm.submit();
			alert("회원 가입이 완료 되었습니다!!");
		}
	}
</script>







<body>
	<!-- Start Page Banner -->
	<div class="page-banner">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2>회원가입</h2>
					<p>일반회원/기업회원</p>
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
	<!-- End Page Banner -->

	<!-- Start content -->
	<div id="content">
		<div class="container">
			<div class="big-title text-center">
				<h1>기업회원가입</h1>
				<p class="title-desc">아래의 내용에 따라 기입해 주시기 바랍니다.</p>
			</div>
			<div class="hr5 margin-40"></div>

			<!-- Start Services Icons -->
			<div class="row">


				<!-- Start content -->
				<div id="content">
					<div class="container">


						<!-- Start Services Icons -->
						<div class="row">

							<form action="/phonefo/insertMember_b" id="frm" method="post"
								name="frm">
								<input id="dev_Ident_e" name="UserIdentE" type="hidden" value="" /><input
									id="dev_certGubun" name="CertPathType" type="hidden"
									value="GGREG" /><input id="dev_db_name" name="DbName"
									type="hidden" value="GG" /><input id="dev_u_ident"
									name="UserIdent" type="hidden" value="" /><input
									id="dev_cert_idx" name="CertIndex" type="hidden" value="" /><input
									id="MemberType" name="MemberType" type="hidden" value="M" />

								<!--// 회원가입폼 -->
								<div class="inner">

									<div class="step3">
										<div class="tbLeave tbJoin">
											<table>
												<colgroup>
													<col width="180">
													<col width="1000">
												</colgroup>
												<tbody>
													<tr>
														<td colspan="2" class="tLine"><div></div></td>
													</tr>
													<tr>
														<th><h3>아이디</h3></th>
														<td><h3>
																<input type="text" name="userid" id="userid"
																	class="tBox tPwd" maxlength="16"
																	placeholder="5~15자 영문, 숫자" title="아이디" />
															</h3>

															<p class="compul"></p> <!-- <input id="checkId" name="dev_idchkStat" type="hidden" value="sdsdsd" /></td> -->
															<div id="checkId" style="font: red"></div>
													</tr>
													<tr>

														<th><h3>비밀번호</h3> <a href="javascript:;"><span
																class="iconPwdQues"></span></a></th>
														<td><h3>
																<input type="password" name="userpwd" class="tBox tPwd"
																	id="userpwd" maxlength="16"
																	placeholder="5~15자 영문, 숫자, 특수문자" title="비밀번호" />
															</h3>
															<div id="checkPwd"></div>

															<p class="compul" id="PwdSafeResult"></p> <input
															id="dev_pwdchkStat" name="dev_pwdchkStat" type="hidden"
															value="" /></td>
													</tr>
													<tr>
														<th><h3>비밀번호 확인</h3></th>
														<td><h3>
																<input type="password" name="userpwd2" id="userpwd2"
																	class="tBox tPwd" maxlength="16" title="비밀번호확인" />
															</h3>
															<div id="checkPwd2"></div>
													</tr>
													<tr>
														<th><h3>휴대폰 번호</h3></th>
														<td><h3>
																<select name="tel1" class="tBox joinBx tPhone" id="tel1"
																	title="휴대폰 번호">
																	<option value="010">010</option>
																	<option value="011">011</option>
																	<option value="016">016</option>
																	<option value="017">017</option>
																	<option value="018">018</option>
																	<option value="019">019</option>
																</select> - <input type="text" name="tel2" id="tel2"
																	maxlength="4" title="휴대폰 번호" style="width: 100px;">
																- <input type="text" name="tel3" id="tel3" maxlength="4"
																	class="tBox tPhone" title="휴대폰 번호"
																	style="width: 100px;">
															</h3>

															<div id="telCheck"></div>
													</tr>
													<tr>
														<th><h3>이메일</h3></th>
														<td><h3>
																<input type="text" name="email1" class="tBox tEmail"
																	id="email1" maxlength="25" title="이메일아이디"
																	style="width: 200px;"> <span>@</span> <input
																	type="text" name="email2" class="tBox tEmail"
																	id="email2" maxlength="25" title="이메일계정"
																	style="width: 200px;" onfocus="$mship.reg.emailChk1()">
																<select name="selectEmail" class="tBox joinBx tEmail"
																	id="selectEmail" title="이메일 서비스업체 선택">
																	<option value="">Select</option>
																	<option value="naver.com">naver.com</option>
																	<option value="hanmail.net">hanmail.net</option>
																	<option value="nate.com">nate.com</option>
																	<option value="daum.net">daum.net</option>
																	<option value="hotmail.com">hotmail.com</option>
																	<option value="dreamwiz.com">dreamwiz.com</option>
																	<option value="gmail.com">gmail.com</option>
																	<option value="">직접입력</option>
																</select>
															</h3>
															<div id="emailCheck1"></div>
													</tr>

													<tr>
														<td colspan="2" class="tLine"><hr>
															<div></div></td>
													</tr>
													<tr>
														<th><h3>사업자등록번호</h3></th>
														<td><h3>
																<input type="text" name="businessNum1" id="businessNum1" maxlength="3"
																	title="휴대폰 번호" style="width: 100px;"> - <input
																	type="text" name="businessNum2" id="businessNum2" maxlength="2"
																	title="휴대폰 번호" style="width: 100px;"> - <input
																	type="text" name="businessNum3" id="businessNum3" maxlength="5"
																	class="tBox tPhone" title="휴대폰 번호"
																	style="width: 100px;">
																<button class="btn btn-default btn-lg" id="certify">
																	<small><font style="font-weight: bold;">인증</font></small>
																</button>
															</h3>
															<div id="certifyCheck"></div>
													</tr>
													<tr>
														<td></td>
														<td width="700">
															<p class="busi_txt" style="color: #79ABFF;">
																※ 사업자등록번호 도용 방지를 위해 기업인증을 시행하고 있습니다.<br> ※ 지점·지사의
																경우, 해당 지점·지사의 사업자등록번호를 입력해 주세요.<br> ※ 인증이 되지 않을 경우
																고객센터(T.1588-9351)로 문의해 주세요.
															</p>
														</td>
													</tr>
													<tr>
														<th><h3>회사/점포명</h3></th>
														<td><h3>
																<input type="text" name="companyName" id="companyName"
																	class="tBox tPwd" maxlength="16" />
															</h3>

															<p class="compul"></p> <!-- <input id="checkId" name="dev_idchkStat" type="hidden" value="sdsdsd" /></td> -->
															<div id="checkId" style="font: red"></div>
													</tr>
													<tr>
														<th><h3>대표자명</h3></th>
														<td><h3>
																<input type="text" name="leader" id="leader"
																	class="tBox tPwd" maxlength="16" />
															</h3>

															
															</td>
													</tr>
													<tr>
														<th><h3>주소</h3></th>
																							<td><h3>
																<input type="text" name="address" id="address"
																	class="tBox tPwd" maxlength="16" />
							<button class="btn btn-default btn-lg">
																	<small><font style="font-weight: bold;">검색</font></small>
																</button>
															</h3>

															
															</td>
													</tr>

													<tr>
														<td colspan="2" class="tLine"><hr>
															<div></div></td>
													</tr>


													<tr>
														<td colspan="2" class="howAlbamon"><h3>
																<span class="select" style="color: #78838e">[선택]</span>
																PhoneFormation을 어떻게 알게 되셨나요? <select
																	class="tBox joinBx tHow" id="root" name="root"
																	style="width: 350px;" title="알바몬을 어떻게 알게 되셨나요"><option
																		value="">선택하세요</option>
																	<option value="1">주요 포털사이트 검색</option>
																	<option value="2">앱스토어 검색</option>
																	<option value="3">라디오광고</option>
																	<option value="4">TV광고</option>
																	<option value="5">뉴스(신문, 인터넷 등)</option>
																	<option value="6">모바일(온라인) 광고 배너</option>
																	<option value="7">친구 및 지인 소개</option>
																	<option value="8">인터넷 커뮤니티 및 게시판</option>
																	<option value="9">극장광고</option>
																	<option value="10">기타(버스, 지하철, 판촉물 등)</option>
																</select>
															</h3></td>
													</tr>
													<tr>
														<td colspan="2" class="tLine"><div></div></td>
													</tr>
												</tbody>
											</table>
											<div class="tooltip" style="display: none;">
												<p>안전한 비밀번호 사용법</p>
												<ul>
													<li>1. 6~16자의 영문 대소문자, 숫자, 특수기호 사용</li>
													<li>2. 3자 이상 연속 영문/숫자 조합 사용불가</li>
													<li>3. 아이디와 동일한 비밀번호를 사용하지 마세요.</li>
													<li>4. 키보드의 연속 패턴은 사용하지 마세요.</li>
													<li>5. 개인정보를 포함하는 비밀번호를 사용하지 마세요.</li>
													<li>6. 비밀번호는 주기적으로 변경하세요.</li>
												</ul>
												<div class="btnClose">
													<a href="#"></a>
												</div>
											</div>
										</div>
									</div>
									<div class="info_confirm" id="boxJoinConfirm"
										style="display: none;">입력한 정보를 다시 확인해주세요.</div>
									<br> <br> <br> <br> <br>
									<center>
										<button type="button" onclick="check()">
											<img alt="" src="/resources/images/join/join5.JPG">
										</button>
									</center>
								</div>
								<!-- 회원가입폼 끝 //-->
							</form>
						</div>
						<!-- 회원가입 끝 //-->






					</div>
				</div>
				<!-- End Clients Carousel -->







			</div>
		</div>
		<!-- End Clients Carousel -->

	</div>

</body>
</html>