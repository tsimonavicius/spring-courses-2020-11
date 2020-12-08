package com.codeacademy.eshop.cart.controller;

import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.product.service.ProductService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
@SessionAttributes({"cart"})
public class CartController {

    private ProductService productService;
    private CartService cartService;

    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @ModelAttribute("cart")
    public List<Product> cart() {
        return new ArrayList<>();
    }

    @GetMapping
    private String openCartList(@ModelAttribute("cart") List<Product> cart, Model model) {
        model.addAttribute("cartPrice", cartService.countTotalPrice(cart));
        model.addAttribute("totalProductsInStore", productService.getTotalProductsInStore());
        return "cart/cart-list";
    }

    @GetMapping("/add/{productId}")
    public String addProductToCart(@PathVariable long productId, @ModelAttribute("cart") List<Product> cart, Model model) {
        Product product = productService.getProductById(productId);
        cart.add(product);
        return "redirect:/product";
    }

    @GetMapping("/checkout")
    public String checkout(SessionStatus sessionStatus, RedirectAttributes redirectAttributes, @ModelAttribute("cart") List<Product> cart) {
        redirectAttributes.addFlashAttribute("cartProducts", cart);
        redirectAttributes.addFlashAttribute("loggedInUser", ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        redirectAttributes.addFlashAttribute("cartPrice", cartService.countTotalPrice(cart));

        sessionStatus.setComplete(); // killing session
        return "redirect:/order/preview";
    }
}
