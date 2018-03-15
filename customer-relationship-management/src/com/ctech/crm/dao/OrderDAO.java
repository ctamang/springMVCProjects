package com.ctech.crm.dao;

import java.util.List;

import com.ctech.crm.entity.Item;
import com.ctech.crm.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders(int id);

	public List<Item> getOrderDetails(int id);

	public void deleteOrder(int id);
	
}
