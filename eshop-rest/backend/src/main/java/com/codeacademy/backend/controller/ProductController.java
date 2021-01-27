package com.codeacademy.backend.controller;

import com.codeacademy.backend.controller.dto.ProductDTO;
import com.codeacademy.backend.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "This controller is responsible for product interactions :))")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PatchMapping("/{id}")
    public ProductDTO updateProductDescription(@PathVariable long id, @RequestBody ProductDTO productDTO) {
        return productService.updateProductDescription(id, productDTO);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.createProduct(productDTO));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductDTO updateProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

}
