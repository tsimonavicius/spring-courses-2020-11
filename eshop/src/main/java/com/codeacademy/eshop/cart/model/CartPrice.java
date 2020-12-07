package com.codeacademy.eshop.cart.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartPrice {
    private BigDecimal totalBrutto; // su pvm
    private BigDecimal totalNetto; // be pvm
    private BigDecimal totalVat; // viso pvm
}
