package com.money.paymentsystem.order;

import com.money.paymentsystem.order.dto.OrderOverviewDTO;
import com.money.paymentsystem.order.jpa.Order;
import com.money.paymentsystem.order.jpa.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(BigDecimal price) {
        Order order = new Order();
        order.setPrice(price);
        order.setOrderNumber(getNextNumber());
        orderRepository.save(order);
    }

    public OrderOverviewDTO getOverview() {
        return orderRepository.getOrderOverview();
    }

    /**
     * Generates next order number based on the latest order in the database.
     */
    private long getNextNumber() {
        if (orderRepository.findAll().size() == 0) {
            return 1;
        }
        return orderRepository.getLastOrderNumber() + 1;
    }
}
