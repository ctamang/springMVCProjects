package com.ctech.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctech.crm.dao.OrderDAO;
import com.ctech.crm.entity.Order;
import com.ctech.crm.entity.OrderDetail;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	@Transactional
	public List<Order> getOrders(int id) {
		
		return orderDAO.getOrders(id);
	}

	@Override
	public List<OrderDetail> getOrderDetails(int id) {
		
		return orderDAO.getOrderDetails(id);
	}
}
