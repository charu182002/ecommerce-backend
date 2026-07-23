package com.ecommerce.ecart.controller;

import com.ecommerce.ecart.dto.OrderCreated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecart.dto.CreateOrderRequest;
import com.ecommerce.ecart.entity.Order;
import com.ecommerce.ecart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
           
	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest)
	{
		OrderCreated orderCreated = orderService.createOrder(orderRequest);
		return ResponseEntity.ok().body(orderCreated);
	}
	
	
	@GetMapping("/{orderNo}")
	public ResponseEntity<?> getOrder(@PathVariable String orderNo)
	{
		Order order = orderService.getOrder(orderNo);
		return ResponseEntity.ok().body(order);
	}
}
