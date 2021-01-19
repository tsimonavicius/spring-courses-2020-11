package com.money.paymentsystem.order;

import com.money.paymentsystem.order.dto.AddOrderRequest;
import com.money.paymentsystem.order.dto.OrderOverviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody @Validated AddOrderRequest request) {
        orderService.addOrder(request.getPrice());
    }

    @GetMapping
    public OrderOverviewDTO getOrdersOverview() {
        return orderService.getOverview();
    }
}
