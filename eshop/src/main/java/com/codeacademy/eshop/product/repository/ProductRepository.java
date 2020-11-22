package com.codeacademy.eshop.product.repository;

import com.codeacademy.eshop.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
