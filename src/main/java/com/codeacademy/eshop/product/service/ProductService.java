package com.codeacademy.eshop.product.service;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        // business logic goes here (in this class)!
        Product alwaysVisibleProduct = new Product();
        alwaysVisibleProduct.setDescription("Visada matomas produktas");
        alwaysVisibleProduct.setPrice(BigDecimal.valueOf(10000));
        alwaysVisibleProduct.setInStock(99999);
        alwaysVisibleProduct.setName("Sita privalo matyti visi!");

        List<Product> products = productRepository.getAll();
        products.add(alwaysVisibleProduct);
        return products;
    }

    public Product getProductById(long id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public void updateProductName(Product productFromModel) {
        productRepository.updateNameById(productFromModel.getName(), productFromModel.getId());
    }
}
