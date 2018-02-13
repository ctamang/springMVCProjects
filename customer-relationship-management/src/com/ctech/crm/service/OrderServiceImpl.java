package com.ctech.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ctech.crm.dao.OrderDAO;
import com.ctech.crm.entity.Order;

public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	@Transactional
	public List<Order> getOrders(int id) {
		
		orderDAO.getOrders(id);
		return null;
	}
}
