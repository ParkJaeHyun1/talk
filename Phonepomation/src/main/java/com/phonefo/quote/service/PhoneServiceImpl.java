package com.phonefo.quote.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.phonefo.quote.domain.PhoneVO;
import com.phonefo.quote.persistence.PhoneDAO;


@Service
public class PhoneServiceImpl implements PhoneService{
	
	@Inject
	PhoneDAO dao;
	
	@Override
	public List<PhoneVO> samsung(String manufacture) throws Exception {
		
		return dao.samsung(manufacture);
	}
	
	
	
	
}
