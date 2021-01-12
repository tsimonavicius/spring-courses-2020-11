package com.codeacademy.backend.controller;

import com.codeacademy.backend.controller.dto.ProductDTO;
import com.codeacademy.backend.service.ProductService;
import io.swagger.annotations.Api;
import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = "This controller is responsible for product interactions :))")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    private ProductDTO getProduct(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    private List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    private ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productDTO));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private ProductDTO updateProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

}
