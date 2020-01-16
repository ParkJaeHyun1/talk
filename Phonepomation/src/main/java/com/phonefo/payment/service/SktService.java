package com.phonefo.payment.service;

import java.util.List;

import com.phonefo.payment.domain.SktVO;

public interface SktService {
	
	public List<SktVO> payment_signiture(String payment) throws Exception;
	public List<SktVO> payment_signiture_master(String payment) throws Exception;
	public List<SktVO> payment_signiture_classic(String payment) throws Exception;

}
