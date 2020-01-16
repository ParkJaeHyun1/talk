package com.phonefo.admin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phonefo.admin.domain.PageMaker;
import com.phonefo.admin.domain.SearchCriteria;
import com.phonefo.admin.service.AdminService;

@Controller
@RequestMapping("/phonefo")
public class AdminController {

	@Inject
	private AdminService service;

	@RequestMapping("/adminMember")//관리자 멤버
	public String memberListPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("list", service.memberSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.memberSearchCount(cri));
		model.addAttribute("pageMaker", pageMaker);

		model.addAttribute("body", "./admin/adminMember.jsp");

		return "mainView";
	}

	@RequestMapping("/adminOno")//관리자 1대1
	public String admin_onoBoard(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		

			model.addAttribute("list", service.onoSearchCriteria(cri));

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.onoSearchCount(cri));
			model.addAttribute("pageMaker", pageMaker);

			model.addAttribute("body", "./admin/adminOno.jsp");

			return "mainView";
		}
}
