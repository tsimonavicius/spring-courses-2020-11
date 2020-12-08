package com.codeacademy.eshop.order.controller;

import com.codeacademy.eshop.order.service.OrderService;
import com.codeacademy.eshop.product.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getAllOrders(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("ordersPage", orderService.getAllOrders(pageable));
        return "order/order-list";
    }

    @GetMapping("/{id}")
    public String getAllOrders(@PathVariable long id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("price", orderService.getOrderPrice(id));
        return "order/single-order";
    }

    @GetMapping("/preview")
    public String previewOrder(@ModelAttribute("loggedInUser") String userName,
                               @ModelAttribute("cartProducts") List<Product> cartProducts,
                               Model model
    ) {
        log.info("User {} placed an order", userName);
        long invoiceId = orderService.placeOrder(userName, cartProducts);
        model.addAttribute("invoiceId", invoiceId);
        return "order/success";
    }
}
