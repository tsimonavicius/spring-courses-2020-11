package com.codeacademy.backend.service;

import com.codeacademy.backend.http.PaymentSystemApi;
import com.codeacademy.backend.http.dto.PaymentSystemOverviewDTO;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentSystemApi paymentSystemApi;

    public PaymentService(PaymentSystemApi paymentSystemApi) {
        this.paymentSystemApi = paymentSystemApi;
    }

    public PaymentSystemOverviewDTO getPaymentOverview() {
        return paymentSystemApi.getOverview();
    }
}
