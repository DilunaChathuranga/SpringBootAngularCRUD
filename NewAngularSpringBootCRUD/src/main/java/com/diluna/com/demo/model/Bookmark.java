package com.diluna.com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "bookmark")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bookmark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "url")
	private String url;
	@Column(name = "status")
	private String status;
	@Column(name = "expiry_date")
	private String expiry_date;
	
	
	public Bookmark() {}


	public Bookmark(int id, String name, String url, String status, String expiry_date) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.status = status;
		this.expiry_date = expiry_date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getExpiry_date() {
		return expiry_date;
	}


	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}


	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", name=" + name + ", url=" + url + ", status=" + status + ", expiry_date="
				+ expiry_date + "]";
	}

	
	
	

	
}
