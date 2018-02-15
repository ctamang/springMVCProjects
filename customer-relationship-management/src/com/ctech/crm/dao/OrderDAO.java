package com.ctech.crm.dao;

import java.util.List;

import com.ctech.crm.entity.Order;
import com.ctech.crm.entity.OrderDetail;

public interface OrderDAO {

	public List<Order> getOrders(int id);

	public List<OrderDetail> getOrderDetails(int id);
	
}
