package com.ctech.crm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {

	private int id;
	
	private String itemId;
	
	private String itemDesc;
	
	private int quantity;
	
	private void OrderDetail() {
		
	}

	public OrderDetail(String itemId, String itemDesc, int quantity) {
		super();
		this.itemId = itemId;
		this.itemDesc = itemDesc;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
