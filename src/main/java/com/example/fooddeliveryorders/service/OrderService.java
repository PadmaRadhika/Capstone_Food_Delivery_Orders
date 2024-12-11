package com.example.fooddeliveryorders.service;

import com.example.fooddeliveryorders.model.Order;

public interface OrderService {
	public Order createOrder(Order order);
	public Order editOrder(Order updateData);	
}
