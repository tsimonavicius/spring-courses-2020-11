package com.codeacademy.eshop.invoice.model;

import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.order.model.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Order order;

    @NotNull
    private BigDecimal totalNetto;

    @NotNull
    private BigDecimal totalBrutto;

    @NotNull
    private BigDecimal totalVat;

    @Embedded
    private Company company;

}
