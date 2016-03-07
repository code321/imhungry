package com.app.imhungry.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Order {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	//private User user;
	//private Cook cook;
	private Date date;

	protected Order() {
	}

	public Order(long id, /*User user, Cook cook,*/ Date date) {
		super();
		this.id = id;
	//	this.user = user;
	//	this.cook = cook;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	/*
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Cook getCook() {
		return cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}
*/
}
