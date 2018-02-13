package com.ctech.crm.service;

import java.util.List;

import com.ctech.crm.entity.Order;

public interface OrderService {

	public List<Order> getOrders(int id);
}
