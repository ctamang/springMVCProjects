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

//import com.ctech.hibernate.entity.Course;

@Entity
@Table(name="orderc")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int orderId;
	
	@Column(name="order_date")
	private String date;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="order_id")
//	public List<OrderDetail> orderDetails;

	@ManyToMany
	@JoinTable(
			name="orderc_item",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="item_id")
		  )
	private List<Item> items;
	
	public Order() {
		
	}
	
	public Order(String date) {
		super();
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

//	public List<OrderDetail> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", items=" + items
				+ "]";
	}

//	public void addOrderDetails(OrderDetail theOrderDetail) {
//		
//		if(theOrderDetail == null) {
//			orderDetails = new ArrayList<>();
//		}
//		
//		orderDetails.add(theOrderDetail);
//	}
	
	public void addItems(Item theItem) {
		if(items == null) {
			items = new ArrayList<>();
		}
		
		items.add(theItem);
	}
}
