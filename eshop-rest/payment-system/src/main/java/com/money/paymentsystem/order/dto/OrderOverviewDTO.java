package com.money.paymentsystem.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
public class OrderOverviewDTO {

    private long ordersTotalCount;

    private BigDecimal ordersTotalPrice;

    private Instant createdAt = Instant.now();

    public OrderOverviewDTO(long ordersTotalCount, BigDecimal ordersTotalPrice) {
        this.ordersTotalCount = ordersTotalCount;
        this.ordersTotalPrice = ordersTotalPrice;
    }
}
