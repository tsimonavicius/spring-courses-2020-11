package com.codeacademy.eshop.order.model;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.user.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToMany
    private List<Product> products = new ArrayList<>();

    @NotNull
    @ManyToOne
    private User user;
}
