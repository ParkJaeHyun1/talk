package com.phonefo.payment.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phonefo.payment.service.SktService;

@Controller
@RequestMapping("/phonefo")
public class SktController {
	
	@Inject
	private SktService service; 

	
	@RequestMapping("/payment/skt")
	public String payment(Model model) throws Exception{

		model.addAttribute("body","./payment/skt.jsp");
		
		return "mainView";
	}
	
	@RequestMapping("/payment/skt/signiture_master")
	public String skt_signiture_master(String payment, Model model) throws Exception{
		
		model.addAttribute("body", "./payment/skt_signiture_master.jsp");
		
		model.addAttribute("signiture", service.payment_signiture(payment));
		model.addAttribute("signiture_master", service.payment_signiture_master(payment));
		model.addAttribute("signiture_classic", service.payment_signiture_classic(payment));
		
		return "mainView";
	}
	
	@RequestMapping("/payment/skt/signiture_classic")
	public String skt_signiture_classic(String payment, Model model) throws Exception{
		
		model.addAttribute("body", "./payment/skt_signiture_master.jsp");
		
		model.addAttribute("signiture", service.payment_signiture(payment));
		model.addAttribute("signiture_master", service.payment_signiture_master(payment));
		model.addAttribute("signiture_classic", service.payment_signiture_classic(payment));
		
		return "mainView";
	}
}
