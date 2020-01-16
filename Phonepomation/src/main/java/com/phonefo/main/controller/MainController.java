package com.phonefo.main.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonefo.main.domain.B_MemberVO;
import com.phonefo.main.domain.MemberVO;
import com.phonefo.main.service.MainService;



@Controller
@RequestMapping("/phonefo")
public class MainController {
	@Inject
	MainService service;

	//메인화면 띄우기
	@RequestMapping("/main")
	public String test(Model model){

		model.addAttribute("body","./main/body.jsp");
		
		return "mainView";
	}
	
	//회원가입(개인,기업 선택 페이지 띄우기)
	@RequestMapping("/join")
	public String join(Model model){
		
		model.addAttribute("body", "./main/join.jsp");
		
		return "mainView";
	}
	
	//로그인폼 띄우기
	
	@RequestMapping("/login")
	public String login(Model model){
		
		model.addAttribute("body","./main/login.jsp");
		
		return "mainView";
	}
	
	
	//일반회원가입폼
	@RequestMapping("/general_member")
	public String general(Model model){
		
		model.addAttribute("body", "./main/general_member_form.jsp");
		return "mainView";
	}
	//기업회원 가입폼
	@RequestMapping("/business_member")
	public String business(Model model){
		
		model.addAttribute("body", "./main/business_member_form.jsp");
		return "mainView";
	}
	//일반회원가입하기
	@RequestMapping("/insertMember")
	public String insertMember(String userid,String userpwd,String username,String gender,int root,
			String birth1,String birth2,String birth3
			,String email1,String email2,String tel1,String tel2,
			String tel3,Model model)throws Exception{
		
		MemberVO dto=new MemberVO();
		
		String birth=birth1+"/"+birth2+"/"+birth3;
		String email=email1+"@"+email2;
		String tel=tel1+"-"+tel2+"-"+tel3;
		dto.setUserid(userid);
		dto.setUserpwd(userpwd);
		dto.setUsername(username);
		dto.setGender(gender);
		dto.setBirth(birth);
		dto.setEmail(email);
		dto.setTel(tel);
		dto.setRoot(root);
		dto.setStatus(1);//1:일반회원 2:기업회원 3:관리자
		
		service.insertMember(dto);
		
		model.addAttribute("body","./main/body.jsp");
		
		
		return "mainView";
	}
	
	//기업회원 가입하기
	@RequestMapping("/insertMember_b")
	public String insertB_member(String userid,String userpwd,String tel1,String tel2,String tel3,
			String email1,String email2,String businessNum1,String businessNum2,String businessNum3,String companyName,String leader,String address,
					int root,Model model)throws Exception{
		

		String email=email1+"@"+email2;
		String tel=tel1+"-"+tel2+"-"+tel3;
		String businessNum=businessNum1+"-"+businessNum2+"-"+businessNum3;
		
		B_MemberVO vo=new B_MemberVO();
		vo.setUserid(userid);
		vo.setUserpwd(userpwd);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setBusinessNum(businessNum);
		vo.setCompanyName(companyName);
		vo.setLeader(leader);
		vo.setAddress(address);
		vo.setRoot(root);
		
		

		service.insertMemberB(vo);
		model.addAttribute("body", "./main/body.jsp");
		return "mainView";
		
		
	}
	

	
	
	

	
	
}
