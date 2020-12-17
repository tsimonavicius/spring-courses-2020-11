package com.codeacademy.eshop.invoice.model;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.order.model.Order;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Order order;

    @Embedded
    private CartPrice prices;

    @Embedded
    private Company company;

    private long sequenceNo;

    @NotBlank
    private String fullName; // ESH-0001

    @CreationTimestamp
    private LocalDateTime createdAt;

}
