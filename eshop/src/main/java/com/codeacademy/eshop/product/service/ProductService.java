package com.codeacademy.eshop.product.service;

import com.codeacademy.eshop.product.exception.ProductNotFoundException;
import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.repository.JdbcTemplateProductRepository;
import com.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * This class is responsible for our business logic
 */
@Service
public class ProductService {

    private JdbcTemplateProductRepository jdbcTemplateProductRepository;
    private ProductRepository productRepository;

    public ProductService(JdbcTemplateProductRepository jdbcTemplateProductRepository, ProductRepository productRepository) {
        this.jdbcTemplateProductRepository = jdbcTemplateProductRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        // business logic goes here (in this class)!
        Product alwaysVisibleProduct = new Product();
        alwaysVisibleProduct.setDescription("Visada matomas produktas");
        alwaysVisibleProduct.setPrice(BigDecimal.valueOf(10000));
        alwaysVisibleProduct.setInStock(99999);
        alwaysVisibleProduct.setName("Sita privalo matyti visi!");

//        List<Product> products = jdbcTemplateProductRepository.getAll();
        List<Product> products = productRepository.findAll();
        products.add(alwaysVisibleProduct);
        return products;
    }

    public Product getProductById(long id) {

        return productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    public void addProduct(Product product) {
        jdbcTemplateProductRepository.save(product);
    }

    public void deleteById(long id) {
        jdbcTemplateProductRepository.deleteById(id);
    }

    public void updateProductName(Product productFromModel) {
        jdbcTemplateProductRepository.updateNameById(productFromModel.getName(), productFromModel.getId());
    }
}