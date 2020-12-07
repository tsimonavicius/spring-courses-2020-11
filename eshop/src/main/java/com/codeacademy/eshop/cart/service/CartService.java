package com.codeacademy.eshop.cart.service;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.product.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.codeacademy.eshop.util.MoneyUtil.VAT;

@Service
public class CartService {


    /**
     * Returns total price of the given list
     */
    public CartPrice countTotalPrice(List<Product> products) {
//        BigDecimal totalPriceSimpleLoop = BigDecimal.ZERO;
//        for (int i = 0; i < products.size(); i++) {
//            BigDecimal price = products.get(i).getPrice();
//            totalPriceSimpleLoop = totalPriceSimpleLoop.add(price);
//        }
//
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for (Product product : products) {
//            BigDecimal price = product.getPrice();
//            totalPrice = totalPrice.add(price);
//        }


        BigDecimal totalNetto = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalBrutto = totalNetto.multiply(BigDecimal.valueOf(VAT));
        BigDecimal totalVat = totalBrutto.subtract(totalNetto);

        CartPrice cartPrice = new CartPrice();
        cartPrice.setTotalBrutto(totalBrutto.setScale(2, RoundingMode.HALF_DOWN));
        cartPrice.setTotalNetto(totalNetto.setScale(2, RoundingMode.HALF_DOWN));
        cartPrice.setTotalVat(totalVat.setScale(2, RoundingMode.HALF_DOWN));
        return cartPrice;
    }
}
