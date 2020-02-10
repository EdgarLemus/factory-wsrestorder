package com.sophos.poc.orden.model.shoppingcart;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

@UserDefinedType("cart")
public class CarritoDetalleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("totalPrice")
	private Long totalPrice = null;
	
	@JsonProperty("totalCartCount")
	private Long totalCartCount = null;
	
	@JsonProperty("compareList")
	private Long compareList = null;
	
	@JsonProperty("wishList")
	private Long wishList = null;
	
	@JsonProperty("products")
	private List<ProductoDTO> products = null;

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getTotalCartCount() {
		return totalCartCount;
	}

	public void setTotalCartCount(Long totalCartCount) {
		this.totalCartCount = totalCartCount;
	}

	public Long getCompareList() {
		return compareList;
	}

	public void setCompareList(Long compareList) {
		this.compareList = compareList;
	}

	public Long getWishList() {
		return wishList;
	}

	public void setWishList(Long wishList) {
		this.wishList = wishList;
	}

	public List<ProductoDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductoDTO> products) {
		this.products = products;
	}

	public CarritoDetalleDTO() {}
	public CarritoDetalleDTO(Long totalPrice, Long totalCartCount, Long compareList, Long wishList,
			List<ProductoDTO> products) {
		super();
		this.totalPrice = totalPrice;
		this.totalCartCount = totalCartCount;
		this.compareList = compareList;
		this.wishList = wishList;
		this.products = products;
	}

	
}
