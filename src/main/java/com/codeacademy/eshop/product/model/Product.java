package com.codeacademy.eshop.product.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * This object is required to represent our database object
 */
@Getter
@Setter
public class Product {

    private long id;

    private String name;

    private Integer inStock;

    private BigDecimal price;

    private String description;
}