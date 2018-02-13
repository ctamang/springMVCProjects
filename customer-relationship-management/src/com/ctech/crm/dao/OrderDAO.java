package com.ctech.crm.dao;

import java.util.List;

import com.ctech.crm.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int id);

	
}
