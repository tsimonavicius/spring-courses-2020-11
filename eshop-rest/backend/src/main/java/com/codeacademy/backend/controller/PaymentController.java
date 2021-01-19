package com.codeacademy.backend.controller;

import com.codeacademy.backend.http.payment.dto.PaymentSystemOverviewDTO;
import com.codeacademy.backend.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/overview")
    private PaymentSystemOverviewDTO getOrderOverview() {
        return paymentService.getPaymentOverview();
    }
}
