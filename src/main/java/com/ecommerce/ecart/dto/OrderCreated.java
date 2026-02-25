package com.ecommerce.ecart.dto;

public class OrderCreated {

	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderCreated(String orderNo) {
		super();
		this.orderNo = orderNo;
	}
	
	
}
