package com.example.fooddeliveryorders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryorders.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
