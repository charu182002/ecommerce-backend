package com.ecommerce.ecart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecart.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	Optional<Order> findByOrderNo(String orderNo);

}
