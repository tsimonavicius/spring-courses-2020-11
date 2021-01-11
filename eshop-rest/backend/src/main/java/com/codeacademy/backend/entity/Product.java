package com.codeacademy.backend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer inStock;

    @Column(nullable = false)
    private BigDecimal price;

//    @ManyToOne
//    private UploadedFile uploadedFile;

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();
}
