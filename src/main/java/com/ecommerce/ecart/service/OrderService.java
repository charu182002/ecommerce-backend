package com.ecommerce.ecart.service;

import com.ecommerce.ecart.dto.OrderCreated;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecart.dto.CreateOrderRequest;
import com.ecommerce.ecart.dto.OrderItemDto;
import com.ecommerce.ecart.entity.Order;
import com.ecommerce.ecart.entity.OrderItem;
import com.ecommerce.ecart.entity.Product;
import com.ecommerce.ecart.repository.OrderRepository;
import com.ecommerce.ecart.repository.ProductRepository;



@Service
public class OrderService {
	
	  @Autowired
	  private ProductRepository prodRepo;
	  
	  @Autowired
	  private OrderRepository orderRepo;
	  
      public OrderCreated createOrder(CreateOrderRequest orderRequest)
      {
    	  Order order = new Order();
    	  order.setStatus("PENDING");
    	  double totalItemsAmount = 0;
    	  
    	  for(OrderItemDto item: orderRequest.getOrderItems())
    	  {
    		  OrderItem orderItem = new OrderItem();
    		  orderItem.setName(item.getName());
    		  orderItem.setPrice(item.getPrice());
    		  orderItem.setImage(item.getImage());
    		  orderItem.setQuantity(item.getQuantity());
    		  
    		  Product product = prodRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
    		  orderItem.setProduct(product);
    		  totalItemsAmount += item.getPrice() * item.getQuantity();
    		  
    		  order.getOrderItems().add(orderItem);
    	  }
    	  
    	  order.setTotalItemAmount(totalItemsAmount);
    	  double totalAmount = 0;
    	  double taxAmount = 10;
    	  totalAmount = totalItemsAmount + taxAmount;
    	  order.setTotalAmount(totalAmount);
    	  order.setTaxAmount(taxAmount);
    	  String orderNo = UUID.randomUUID().toString();
    	  order.setOrderNo(orderNo);
    	  orderRepo.save(order);
    	  return new OrderCreated(orderNo);
      }

	public Order getOrder(String orderNo) {
		return orderRepo.findByOrderNo(orderNo).orElseThrow(()-> new RuntimeException("No Order Found With Order No"));
		
	}
}
