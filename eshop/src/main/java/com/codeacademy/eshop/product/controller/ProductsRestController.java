package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductsRestController {

    private final ProductService productService;

    public ProductsRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/rest/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProductsAsJson() {
        return productService.getAllProducts(PageRequest.of(0, 10)).getContent();
    }

    @GetMapping(value = "/rest/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Product> getAllProductsAsXml() {
        return productService.getAllProducts(PageRequest.of(0, 10)).getContent();
    }
}
