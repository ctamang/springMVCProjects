package com.ctech.crm.service;

import java.util.List;

import com.ctech.crm.entity.Order;
import com.ctech.crm.entity.OrderDetail;

public interface OrderService {

	public List<Order> getOrders(int id);
	
	public List<OrderDetail> getOrderDetails(int id);
	
	public void deleteOrder(int id);
}
