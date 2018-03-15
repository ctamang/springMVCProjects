package com.ctech.crm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_desc")
	private String itemDesc;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="rate")
	private String rate;
	
	@ManyToMany
	@JoinTable(
			name="orderc_item",
			joinColumns=@JoinColumn(name="item_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
		  )
	private List<Order> order;
	
	public Item() {
		
	}

	public Item(String itemName, String itemDesc, String quantity, String rate) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.quantity = quantity;
		this.rate = rate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", quantity=" + quantity
				+ ", rate=" + rate + ", order=" + order + "]";
	}

	public void addOrder(Order theOrder) {
		
		if(order == null) {
			order = new ArrayList<>();
		}
		
		order.add(theOrder);
	}
	
	
}
