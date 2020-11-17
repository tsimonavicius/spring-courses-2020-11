package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.exception.ProductNotFoundException;
import com.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductsController {

    private List<Product> products = new ArrayList<>();

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", products);
        return "product/product-list";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable long id, Model model) {
        model.addAttribute("product", getProductById(id));
        return "product/single-product";
    }

    @GetMapping("/new")
    public String getNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/new-product";
    }

    @GetMapping("/edit-name/{id}")
    public String getNewProductForm(@PathVariable long id,  Model model) {
        Product product = getProductById(id);
        model.addAttribute("product", product);
        return "product/edit-product-name";
    }

    @PostMapping("/edit-name")
    public String updateProductName(@ModelAttribute("product") Product product, Model model) {
        Product oldProduct = getProductById(product.getId());
        products.remove(oldProduct); // hacky, we should modify existing one
        products.add(product);
        model.addAttribute("products", products);
        return "product/product-list";
    }

    @PostMapping
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        long newId = 1;
        if (!products.isEmpty()) {
            // set new id to be +1 from the last product in our list
            newId = products.get(products.size() - 1).getId() + 1;
        }
        product.setId(newId);
        products.add(product);
        model.addAttribute("products", products);
        return "product/product-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        Product product = getProductById(id);
        products.remove(product);
        model.addAttribute("products", products);
        return "product/product-list";
    }

    // find product by the given ID or throw exception that this product was not found!
    private Product getProductById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }
}
