<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>




<script type="text/javascript">

	
						var idStatus=0;
						var pwdStatus=0;
						var pwd2Status=0;
						var usernameStatus=0;
						var email1Status=0;
						var email2Status=0;
						var birth1Status=0;
						var tel2Status=0;
						var tel3Status=0;
						var rootStatus=0;
	
	
	
	$(document)
			.ready(
					function() {		
						

						
					
					
						$('#userid').keyup(function() {
							$.ajax({
								url : "/phonefo/checkId",
								data : {
									userid : $("#userid").val()
								},
								success : function(result) {
									//출력할곳 정하기
									$('#checkId').html(result);
									if(result.indexOf('가능한')==-1)//가입불가 
										idStatus=-1;
									else
										idStatus=1;

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
									if(result.indexOf('비밀번호')==-1)//가입불가
										pwdStatus=-1;
									else
										pwdStatus=1;
						
								}
							});
						});

						$('#userpwd2').keyup(
										function() {
											var userpwd = $('#userpwd').val();
											var userpwd2 = $('#userpwd2').val();

											if (userpwd != userpwd2){
												$('#checkPwd2')
														.html(
																'<font color="red">비밀번호가 일치하지 않습니다.</font>');
												pwd2Status=-1;
											}else{
												$('#checkPwd2')
														.html(
																'<font color="blue">비밀번호가 일치합니다.</font>');
												pwd2Status=1;
											}
										});
						
						$('#username').keyup(function(){
							var regex=/^[a-zA-z가-힣]{2,12}$/;
							if(!regex.test($('#username').val())){
								$('#usernameCheck').html('<font color="red">2~12자의 한글, 영문만 사용 가능합니다.</font>');
								usernameStatus=-1;
							}else{
								$('#usernameCheck').html('');
								usernameStatus=1;
							}
						});
						
						$('#email1').keyup(function(){
							var regex=/^[a-zA-z0-9]{2,15}$/;
							if(!regex.test($('#email1').val())){
								$('#emailCheck1').html('<font color="red">이메일을 올바르게 입력해 주세요.</font>');
								email1Status=-1;
							}else{
								$('#emailCheck1').html('');
								email1Status=1;
							}
						});
						
						$('#email2').keyup(function(){
							var regex=/^[0-9a-zA-Z]*[.][a-zA-Z]{2,3}$/;
								
							if(!regex.test($('#email2').val())){
								$('#emailCheck1').html('<font color="red">이메일을 올바르게 입력해 주세요.</font>');
								email2Status=-1;
							}else{
								$('#emailCheck1').html('');
								email2Status=1;
							}
						});
						
					

						$('#selectEmail').change(function() {
							$('#email2').val($('#selectEmail').val());
							$('#emailCheck1').html('');
						});
						
						
						$('#tel2').keyup(function(){
							var reg=/^[0-9]{3,4}$/;
							if(!reg.test($('#tel2').val())){
								$('#telCheck').html('<font color="red">번호 형식이 올바르지 않습니다. </font>');
								tel2Status=-1;
							}else{
								$('#telCheck').html('');
								tel2Status=1;
							}
						});
						$('#tel3').keyup(function(){
							var reg=/^[0-9]{4}$/;
							if(!reg.test($('#tel3').val())){
								$('#telCheck').html('<font color="red">번호 형식이 올바르지 않습니다.</font>');
								tel3Status=-1;
							}else{
								$('#telCheck').html('');
								tel3Status=1;
							}
						});
						$('#birth1').change(function(){
							birth1Status=1;
						});

						$('#birth2').change(
								function() {
									if ($('#birth2').val() == 1) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value= '"+i+"'>" + i +"일</option>");
										}
									} else if ($('#birth2').val() == 2) {
										for (var i = 1; i < 29; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 3) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 4) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 5) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 6) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 7) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 8) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 9) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 10) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 11) {
										for (var i = 1; i < 31; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}

									} else if ($('#birth2').val() == 12) {
										for (var i = 1; i < 32; i++) {
											$('#birth3').append(
													"<option value='"+i+"'>" + i
															+ "일</option>");
										}
									}

								});

					});
	
	function check(){
		

		if( $('#userid').val()=='' || idStatus==-1){
			alert('아이디를 확인하세요');
			$('#userid').focus();
		}else if($('#userpwd').val()=='' || pwdStatus==-1){
			alert('비밀번호를 확인하세요');
			$('#userpwd').focus();
		}else if($('#userpwd2').val()=='' || pwd2Status==-1){
			alert('비밀번호를 확인하세요');
			$('#userpwd2').focus();
		}else if($('#username').val()=='' || usernameStatus==-1){
			alert('이름을 확인하세요');
			$('#username').focus();
		}else if($('#birth1').val()=='' || $('#birth2').val()=='' || $('#birth3').val()=='' || birth1Status==0){
			alert('생년월일을 확인하세요')
			$('#birth1').focus();
		}else if($('#email1').val()=='' || email1Status==-1){
			alert('이메일을 확인하세요');
			$('#email1').focus();
		}else if($('#email2').val()=='' || email2Status==-1){
			alert('이메일을 확인하세요');
			$('#email2').focus();
		}else if($('#tel2').val()=='' || tel2Status==-1){
			alert('휴대폰 번호를 확인하세요');
			$('#tel2').focus();
		}else if($('#tel3').val()=='' || tel3Status==-1){
			alert('휴대폰 번호를 확인하세요');
			$('#tel3').focus();
		}else if($('#root').val()==''){
			alert('선택사항을 골라 주세요');
			$('#root').focus();
		}else{
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
				<h1>개인회원가입</h1>
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

							<form action="/phonefo/insertMember" id="frm" method="post" name="frm">
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
													<col width="160">
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
																	placeholder="6~16자 영문, 숫자" title="아이디" />
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
																	placeholder="6~16자 영문, 숫자, 특수문자" title="비밀번호" />
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
														<td colspan="2" class="tLine"><hr>
															<div></div></td>
													</tr>

													<tr>
														<th><h3>이름</h3></th>
														<td><h3>
																<input type="text" name="username" class="tBox"
																	title="이름" id="username" maxlength="12" />
															</h3>
																<div id="usernameCheck"></div>
													</tr>
													<tr>
														<th><h3>생년월일</h3></th>
														<td><h3>
																<select class="tBox joinBx tBirth_yy" data-val="true"
																	data-val-number="SelectedBirthYearValue 필드는 숫자여야 합니다."
																	data-val-required="SelectedBirthYearValue 필드가 필요합니다."
																	id="birth1" name="birth1" title="생년월일 연도"><option
																		value="">년</option>
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
																</select> <select name="birth2" class="tBox joinBx tBirth_mm"
																	id="birth2" title="생년월일 월">
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
																</select> <select name="birth3" class="tBox joinBx tBirth_mm"
																	id="birth3" title="생년월일 일">
																	<option value="">일</option>
																</select>
																<p class="compul" id="txtBirth"></p>
																<input id="dev_birthChkStat" name="dev_birthChkStat"
																	type="hidden" value="" /></td>
													</tr>
													<tr>
														<th><h3>성별</h3></th>
														<td><input type="radio" name="gender" title="남자"
															id="male" value="남자" checked="checked"><label for="male">남자</label>
															<input type="radio" name="Gender" title="여자" id="female"
															value="여자"><label for="female">여자</label>
															<p class="compul" id="txtGender"></p></td>
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
																	style="width: 100px;"></h3>
																
																	<div id="telCheck"></div>
													</tr>
													<tr>
														<td colspan="2" class="tLine"><div></div>
															<hr></td>
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
									<br>
									<br>
									<br>
									<br>
									<br>
									<center>
									<button type="button" onclick="check()"><img alt="" src="/resources/images/join/join5.JPG"></button> 
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