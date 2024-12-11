package com.example.fooddeliveryorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fooddeliveryorders.dao.OrderItemRepository;
import com.example.fooddeliveryorders.dao.OrderRepository;
import com.example.fooddeliveryorders.model.Order;
import com.example.fooddeliveryorders.model.OrderItem;
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		Order savedOrder = orderRepository.save(order);
		for(OrderItem item: order.getItems()) {
			item.setOrder(savedOrder);
			orderItemRepository.save(item);
		}
		return savedOrder;
	}

	@Override
	public Order editOrder(Order updateData) {
		// TODO Auto-generated method stub
		return orderRepository.findById(updateData.getId()).map(existingOrder -> {
            // Update the fields (only the ones provided)
            if (updateData.getCustomerName() != null) {            	
            	existingOrder.setCustomerName(updateData.getCustomerName());
            }
            if (updateData.getCustomerEmail() != null) {            	
            	existingOrder.setCustomerEmail(updateData.getCustomerEmail());
            }
            if (updateData.getCustomerPhone() != null) {            	
            	existingOrder.setCustomerPhone(updateData.getCustomerPhone());
            }            
            // Save the updated order
            return orderRepository.save(existingOrder);
        }).orElse(null); // If not found, return null
	}

	

}
