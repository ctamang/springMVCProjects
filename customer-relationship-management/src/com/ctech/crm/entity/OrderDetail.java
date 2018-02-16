package com.ctech.crm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="item_id")
	private String itemId;
	
	@Column(name="item_description")
	private String itemDesc;
	
	@Column(name="quantity")
	private int quantity;
	
	public OrderDetail() {
		
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

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", itemId=" + itemId + ", itemDesc=" + itemDesc + ", quantity=" + quantity
				+ "]";
	}

	
}
