package com.app.imhungry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class ItemOrder {

	@Id
	@GeneratedValue
	private long id;
	private Order order;
	private String description;
	private Double price;
	
	protected ItemOrder() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	public Order getOrder() {
		return order;
	}

	public ItemOrder(long id, Order order, String description, Double price) {
		super();
		this.id = id;
		this.order = order;
		this.description = description;
		this.price = price;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


}
