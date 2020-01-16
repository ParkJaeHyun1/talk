package com.phonefo.payment.domain;

public class SktVO {
	private String payment;
	private String	data;
	private String call;
	private String	sms;
	private int		fixed_month;
	private int		fares_month;
	private int		fares_24month;
	private int		discount;
	
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public int getFixed_month() {
		return fixed_month;
	}
	public void setFixed_month(int fixed_month) {
		this.fixed_month = fixed_month;
	}
	public int getFares_month() {
		return fares_month;
	}
	public void setFares_month(int fares_month) {
		this.fares_month = fares_month;
	}
	public int getFares_24month() {
		return fares_24month;
	}
	public void setFares_24month(int fares_24month) {
		this.fares_24month = fares_24month;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
}
