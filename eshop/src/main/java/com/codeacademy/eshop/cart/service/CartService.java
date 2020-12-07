package com.codeacademy.eshop.cart.service;

import com.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {

    /**
     * Returns total price of the given list
     */
    public BigDecimal countTotalPrice(List<Product> products) {
        // TODO: return object with prices
        // viso be pvm
        // viso pvm
        // viso su pvm

        BigDecimal totalPriceSimpleLoop = BigDecimal.ZERO;
        for (int i = 0; i < products.size(); i++) {
            BigDecimal price = products.get(i).getPrice();
            totalPriceSimpleLoop = totalPriceSimpleLoop.add(price);
        }

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : products) {
            BigDecimal price = product.getPrice();
            totalPrice = totalPrice.add(price);
        }

        return products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
