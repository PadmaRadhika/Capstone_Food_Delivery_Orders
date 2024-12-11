package com.example.fooddeliveryorders.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddeliveryorders.model.Order;
import com.example.fooddeliveryorders.service.OrderService;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allow CORS from Angular app
@RequestMapping(value = "/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@PostMapping("/placeOrder")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody Order order) {		
		Order createdOrder = orderService.createOrder(order);
		Map<String, String> orderMap = new HashMap<>(); 
		orderMap.put("id", order.getId().toString());
		orderMap.put("totalAmount", order.getTotalAmount().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(orderMap);
    }
	
	@PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order updateData){
		Order updatedOrder = orderService.editOrder(updateData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
