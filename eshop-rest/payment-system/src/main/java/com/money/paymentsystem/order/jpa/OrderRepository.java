package com.money.paymentsystem.order.jpa;

import com.money.paymentsystem.order.dto.OrderOverviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT max(o.orderNumber) FROM Order o")
    long getLastOrderNumber();

    @Query("SELECT new com.money.paymentsystem.order.dto.OrderOverviewDTO(count(o), sum(o.price)) FROM Order o")
    OrderOverviewDTO getOrderOverview();
}
