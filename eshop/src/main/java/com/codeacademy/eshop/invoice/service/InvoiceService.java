package com.codeacademy.eshop.invoice.service;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.invoice.model.Invoice;
import com.codeacademy.eshop.invoice.repository.InvoiceRepository;
import com.codeacademy.eshop.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private Company company;
    private CartService cartService;

    public InvoiceService(InvoiceRepository invoiceRepository, Company company, CartService cartService) {
        this.invoiceRepository = invoiceRepository;
        this.company = company;
        this.cartService = cartService;
    }

    public void createInvoice(Order createdOrder) {
        Invoice invoice = new Invoice();
        var products = createdOrder.getProducts();

        company.getCompanyName();

        CartPrice cartPrice = cartService.countTotalPrice(products);
    }
}
