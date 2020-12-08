package com.codeacademy.eshop.order.repository;

import com.codeacademy.eshop.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
