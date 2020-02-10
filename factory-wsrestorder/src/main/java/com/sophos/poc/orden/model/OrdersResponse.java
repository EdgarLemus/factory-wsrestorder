package com.sophos.poc.orden.model;

import java.io.Serializable;

public class OrdersResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String approvalCode;

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public OrdersResponse(String approvalCode) {
		super();
		this.approvalCode = approvalCode;
	}
	
	
}
