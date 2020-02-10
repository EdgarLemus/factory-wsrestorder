package com.sophos.poc.orden.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Encript implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	private String id;
	private String rqUID;
	private String channel;
	private String ipAddr;
	private String idSession;
	private String data;
	private Date createDate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRqUID() {
		return rqUID;
	}
	public void setRqUID(String rqUID) {
		this.rqUID = rqUID;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getIdSession() {
		return idSession;
	}
	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Encript() {}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Encript(String id, String rqUID, String channel, String ipAddr, String idSession, String data,
			Date createDate) {
		super();
		this.id = id;
		this.rqUID = rqUID;
		this.channel = channel;
		this.ipAddr = ipAddr;
		this.idSession = idSession;
		this.data = data;
		this.createDate = createDate;
	}
	

}
