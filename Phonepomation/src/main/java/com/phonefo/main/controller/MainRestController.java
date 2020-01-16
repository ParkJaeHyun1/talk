package com.phonefo.main.controller;

import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;
import com.phonefo.main.service.MainService;

@RestController
@RequestMapping("/phonefo")
public class MainRestController {
	@Inject
	MainService service;
	
	//일반회원  아이디 중복검사
	@RequestMapping("/checkId")
	public String checkId(String userid)throws Exception{
		
		boolean result=service.checkId(userid);
		
		if(result==false){
			return "<font color='red'>이미 존재하는 아이디 입니다.</font>";
		}else if(result==true){
			if(!Pattern.matches("^[a-zA-Z0-9]{5,15}$", userid))
				return "<font color='red'>5~15자의 영소문자, 숫자만 사용 가능합니다.</font>";
			else
				return "<font color='blue'>사용 가능한 아이디 입니다</font>";
		}
		return "";
	}
	//기업  아이디 중복검사
	@RequestMapping("/checkBId")
	public String checkBId(String userid)throws Exception{
		
		boolean result=service.checkBId(userid);
		
		if(result==false){
			return "<font color='red'>이미 존재하는 아이디 입니다.</font>";
		}else if(result==true){
			if(!Pattern.matches("^[a-zA-Z0-9]{5,15}$", userid))
				return "<font color='red'>5~15자의 영소문자, 숫자만 사용 가능합니다.</font>";
			else
				return "<font color='blue'>사용 가능한 아이디 입니다</font>";
		}
		return "";
	}
	//패스워드 유효성 검사(일반,기업)
	@RequestMapping("/checkPwd")
	public String checkPwd(String userpwd)throws Exception{
		System.out.println(userpwd);
		if(!Pattern.matches("^[a-zA-Z0-9`~!@#$%^&*()-_=+]{5,15}$", userpwd)){
			return "<font color='red'>5~15자의 영문, 숫자, 특수문자만 사용 가능합니다.</font>";
		}else if(Pattern.matches("^[a-zA-Z0-9]{5,7}$", userpwd)){
			return "<font color='blue'>사용하실 수 있는 비밀번호입니다. (안전도 등급 낮음)</font>";	
		}else {
			return "<font color='blue'>사용하실 수 있는 비밀번호입니다. (안전도 등급 높음)</font>";
		}

	}
	
	//일반회원 로그인
	@RequestMapping("/confirm_member")
	public String confirm_member(String userid,String userpwd,HttpSession session)throws Exception{
		
		boolean result=false;
		result = service.check_general_member(userid, userpwd);
		
		if(result==true){
			MemberVO vo= service.getVO(userid);
			session.setAttribute("userid", userid);
			session.setAttribute("username", vo.getUsername());
			session.setAttribute("loginVO", vo);
			
			return "성공";
		}else{
			return "실패";
		}
		
	}
	//기업회원 로그인
	@RequestMapping("/confirm_business_member")
	public String confirm_business_member(String userid,String userpwd,HttpSession session)throws Exception{
		
		boolean result=false;
		result = service.check_business_member(userid, userpwd);

		
		if(result==true){
			B_MemberVO vo= service.getBVO(userid);
			session.setAttribute("userid", userid);
			session.setAttribute("username", vo.getCompanyName());
			session.setAttribute("loginVO", vo);
			return "성공";
		}else{
			return "실패";
		}
		
	}
	//로그아웃
	@RequestMapping("/logout")
	public void logout(HttpSession session){
		session.invalidate();
	
	}
}

