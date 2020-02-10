package com.sophos.poc.orden.model.shoppingcart;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = { "small", "medium", "big" })
@UserDefinedType("images")
public class GaleriaProductoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("small")
	private String small = null;

	@JsonProperty("medium")
	private String medium = null;

	@JsonProperty("big")
	private String big = null;

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getBig() {
		return big;
	}

	public void setBig(String big) {
		this.big = big;
	}

	public GaleriaProductoDTO(String small, String medium, String big) {
		super();
		this.small = small;
		this.medium = medium;
		this.big = big;
	}

	public GaleriaProductoDTO() {}

	

}
