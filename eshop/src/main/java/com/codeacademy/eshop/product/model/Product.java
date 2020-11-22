package com.codeacademy.eshop.product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * This object is required to represent our database object
 */
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "in_stock")
    private Integer inStock;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;
}
