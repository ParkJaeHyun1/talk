package com.phonefo.quote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/phonefo")
public class QuoteController {

	@RequestMapping("/secondHand")
	public String quoteMain(Model model){
		

		model.addAttribute("body","./quote/secondHand.jsp");
		return "mainView";
	}
}
