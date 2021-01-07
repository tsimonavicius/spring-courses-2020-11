package com.codeacademy.backend.controller;

import com.codeacademy.backend.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = "This controller is responsible for product interactions :))")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<String> getAllProducts() {
        return List.of("Produktas1", "Producktas2");
    }

    @PostMapping("/{name}")
    private String addProduct(@PathVariable @ApiParam("produkto pavadinimas") String name) {
        return name;
    }
}
