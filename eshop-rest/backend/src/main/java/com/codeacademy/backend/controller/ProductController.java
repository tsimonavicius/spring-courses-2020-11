package com.codeacademy.backend.controller;

import com.codeacademy.backend.controller.dto.ProductDTO;
import com.codeacademy.backend.service.ProductService;
import io.swagger.annotations.Api;
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
    private List<ProductDTO> getAllProduct(@PathVariable long id) {
        return new ArrayList<>(); // TODO implement
//        return productService.getProductById(id);
    }

    @PostMapping
    private ProductDTO addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PutMapping
    private ProductDTO updateProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

}
