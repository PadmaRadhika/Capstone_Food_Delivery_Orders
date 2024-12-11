package com.example.fooddeliveryorders.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddeliveryorders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
