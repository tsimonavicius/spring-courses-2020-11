package com.codeacademy.eshop.product.service;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getProductNames() {
        return productRepository.getProductNames();
    }

    public Product getProductByIdJdbcTemplate(int id) {
        return productRepository.getProductByIdJdbcTemplate(id);
    }

    public Product getProductByIdPreparedStatement(int id) {
        return productRepository.getProductByIdPreparedStatement(id);
    }

    public int countOfProductsByName(String name) {
        return productRepository.countOfProductsByName(name);
    }
}
