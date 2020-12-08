package com.codeacademy.eshop.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @GetMapping
    public String previewOrder(@ModelAttribute("loggedInUser") String userName) {
        log.info("User {} previewed order", userName);
        return "order/preview";
    }
}