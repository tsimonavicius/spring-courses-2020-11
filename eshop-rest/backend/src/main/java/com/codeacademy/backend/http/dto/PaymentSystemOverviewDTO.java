package com.codeacademy.backend.http.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSystemOverviewDTO {

    private long ordersTotalCount;

    private BigDecimal ordersTotalPrice;
}
