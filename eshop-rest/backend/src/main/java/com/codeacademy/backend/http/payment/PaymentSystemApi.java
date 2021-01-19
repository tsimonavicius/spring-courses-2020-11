package com.codeacademy.backend.http.payment;

import com.codeacademy.backend.http.payment.dto.PaymentSystemOverviewDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;

@Component
public class PaymentSystemApi {


    private RestTemplateBuilder restTemplateBuilder;

    public PaymentSystemApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public void createOrder(@NotNull BigDecimal price) {
        HashMap<String, Object> request = new HashMap<>();
        request.put("price", price);

        getClient().postForObject("/orders", request, Void.class);
    }


    public PaymentSystemOverviewDTO getOverview() {
        return getClient().getForObject("/orders", PaymentSystemOverviewDTO.class);
    }

    private RestTemplate getClient() {
        return restTemplateBuilder
                .rootUri("http://localhost:8081/api")
                .build();
    }
}
