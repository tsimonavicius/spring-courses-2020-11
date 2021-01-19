package com.money.paymentsystem.order;

import com.money.paymentsystem.order.dto.OrderOverviewDTO;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestParam @NotNull BigDecimal price) {
        orderService.addOrder(price);
    }

    @GetMapping
    public OrderOverviewDTO getOrdersOverview() {
        return orderService.getOverview();
    }
}
