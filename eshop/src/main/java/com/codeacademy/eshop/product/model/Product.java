package com.codeacademy.eshop.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * This object is required to represent our database object
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    @NotBlank(message = "Produkto pavadinimas neturi būti tuščias!")
    @Size(min = 5, max = 200, message = "{product.name.size}")
    private String name;

    @Column(name = "in_stock")
    @NotNull(message = "{product.stock.not.empty}")
    @Min(value = 5, message = "In stock must be greater or equal to {value}. Provided stock was ${validatedValue} product${validatedValue > 1 ? 's' : ''}")
    private Integer inStock;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "description")
    @Size(min = 5, message = "The length of this field has to be greater than {min}, user input: ${validatedValue.length()}!")
    private String description;
}
