package com.sophos.poc.orden.model;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("billing")
public class Billing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String middleName;
	private String company;
	private String email;
	private String phone;
	private Country country;
	private String city;
	private String state;
	private String zip;
	private String address;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Billing() {}
	public Billing(String firstName, String lastName, String middleName, String company, String email, String phone,
			Country country, String city, String state, String zip, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.company = company;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.address = address;
	}
	


}
