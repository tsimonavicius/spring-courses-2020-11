package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This class is responsible for mapping our request, validating it, interacting with model
 */
@Controller
@RequestMapping("/product")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/product-list";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/single-product";
    }

    @GetMapping("/new")
    public String getNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/new-product";
    }

    @GetMapping("/edit-name/{id}")
    public String getNewProductForm(@PathVariable long id,  Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/edit-product-name";
    }

    @PostMapping("/edit-name")
    public String updateProductName(@ModelAttribute("product") Product product) {
        productService.updateProductName(product);
        return "redirect:/product";
    }

    @PostMapping
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "forward:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
