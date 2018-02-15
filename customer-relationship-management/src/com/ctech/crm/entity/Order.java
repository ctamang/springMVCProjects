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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int orderId;
	
	@Column(name="order_date")
	private String date;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	public List<OrderDetail> orderDetails;

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

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", orderDetails=" + orderDetails + "]";
	}

	public void addOrderDetails(OrderDetail theOrderDetail) {
		
		if(theOrderDetail == null) {
			orderDetails = new ArrayList<>();
		}
		
		orderDetails.add(theOrderDetail);
	}
}
