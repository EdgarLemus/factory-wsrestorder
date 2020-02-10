package com.sophos.poc.orden.model.shoppingcart;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import com.fasterxml.jackson.annotation.JsonProperty;

@UserDefinedType("comments")
public class ComentarioProductoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("comment")
	private String comment = null;

	@JsonProperty("user")
	private String user = null;

	@JsonProperty("creationDate")
	private String creationDate = null;

	@JsonProperty("rating")
	private Long rating = null;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public ComentarioProductoDTO(String comment, String user, String creationDate, Long rating) {
		super();
		this.comment = comment;
		this.user = user;
		this.creationDate = creationDate;
		this.rating = rating;
	}

	
	public ComentarioProductoDTO() {}

	

}
