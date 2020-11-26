package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.service.ProductService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String getAllProducts(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("productsPage", productService.getAllProducts(pageable));
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
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model) {
        product.setName(product.getName().trim());
        if (bindingResult.hasErrors()) {
            return "product/new-product";
        }
        long savedProductId = productService.addProduct(product).getId();
        return "redirect:/product/" + savedProductId;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
