package com.codeacademy.eshop.order.controller;

import com.codeacademy.eshop.order.service.OrderService;
import com.codeacademy.eshop.product.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String previewOrder(@ModelAttribute("loggedInUser") String userName,
                               @ModelAttribute("cartProducts") List<Product> cartProducts
    ) {
        log.info("User {} placed an order", userName);
        orderService.placeOrder(userName, cartProducts);
        return "order/preview";
    }
}