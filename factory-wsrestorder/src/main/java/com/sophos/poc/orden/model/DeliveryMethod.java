package com.sophos.poc.orden.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

@UserDefinedType("deliveryMethod")
public class DeliveryMethod implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String value;
	private String name;
	@JsonProperty(value="desc")
	private String description;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DeliveryMethod() {}
	public DeliveryMethod(String value, String name, String description) {
		super();
		this.value = value;
		this.name = name;
		this.description = description;
	}

}
