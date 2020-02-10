package com.sophos.poc.orden.model.shoppingcart;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

@UserDefinedType("cart")
public class CarritoDTO implements Serializable {

	private static final long serialVersionUID = 8419422065004282815L;

	@Id
	@JsonProperty("idSession")
	private String idSession = null;
	
	@JsonProperty("cart")
	private CarritoDetalleDTO cart = null;

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSesion) {
		this.idSession = idSesion;
	}

	public CarritoDetalleDTO getCart() {
		return cart;
	}

	public void setCart(CarritoDetalleDTO cart) {
		this.cart = cart;
	}
	
	public CarritoDTO() {}
	
	
	
}
