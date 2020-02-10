package com.sophos.poc.orden.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import com.sophos.poc.orden.model.shoppingcart.CarritoDetalleDTO;

public class Orders implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public Orders() {}
	
	@PrimaryKey
	private String id;
	private String idSession;
	private Date createDate;
	private Billing billing;
	private Delivery delivery;
	private Map<String, String> payment;
	private String approvalCode;
	private CarritoDetalleDTO cart;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Map<String, String> getPayment() {
		return payment;
	}
	public void setPayment(Map<String, String> payment) {
		this.payment = payment;
	}
	public String getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	public CarritoDetalleDTO getCart() {
		return cart;
	}
	public void setCart(CarritoDetalleDTO cart) {
		this.cart = cart;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	public String getIdSession() {
		return idSession;
	}
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
	public Orders(String id, String idSession, Date createDate, Billing billing, Delivery delivery,
			Map<String, String> payment, String approvalCode, CarritoDetalleDTO cart) {
		super();
		this.id = id;
		this.idSession = idSession;
		this.createDate = createDate;
		this.billing = billing;
		this.delivery = delivery;
		this.payment = payment;
		this.approvalCode = approvalCode;
		this.cart = cart;
	}

}
