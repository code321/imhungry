package com.app.imhungry.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Authority {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String role;	

	protected Authority() {
	}

	public Authority(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
