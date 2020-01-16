package com.phonefo.quote.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonefo.quote.domain.PhoneVO;
import com.phonefo.quote.service.PhoneService;

@RestController
@RequestMapping("/phonefo")
public class QuoteRestController {
	
	@Inject
	PhoneService service;

	@RequestMapping("/samsung")
	public String samsung(String manufacture)throws Exception{
		
		System.out.println("선택한 제조사:"+manufacture);
		List<PhoneVO> list = service.samsung(manufacture);
		
		System.out.println("DB에서 뽑아낸 데이터:"+list.get(0).getName());
		
		return manufacture;
	}
	
}
