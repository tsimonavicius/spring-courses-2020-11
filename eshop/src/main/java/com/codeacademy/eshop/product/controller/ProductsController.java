package com.codeacademy.eshop.product.controller;

import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * This class is responsible for mapping our request, validating it, interacting with model
 */
@Slf4j
@Controller
@RequestMapping("/public/product")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(@PageableDefault(size = 5) Pageable pageable, Model model, HttpSession httpSession) {
        model.addAttribute("cart", httpSession.getAttribute("cart"));
        model.addAttribute("productsPage", productService.getAllProducts(pageable));
        return "product/product-list";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable long id, Model model) {
        log.info("getSingleProduct({})", id);

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
        log.info("addProduct({})", product);

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
