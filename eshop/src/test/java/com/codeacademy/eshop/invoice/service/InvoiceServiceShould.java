package com.codeacademy.eshop.invoice.service;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.invoice.model.Invoice;
import com.codeacademy.eshop.invoice.repository.InvoiceRepository;
import com.codeacademy.eshop.order.model.Order;
import com.codeacademy.eshop.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceShould {

    private static final long INVOICE_ID = 123L;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private CartService cartService;

    private Company company;

    private InvoiceService invoiceService;

    @BeforeEach
    void init() {
        company = Company.builder()
                .name("name")
                .number(123)
                .vat(321L)
                .iban("LT0000000000001")
                .address("address")
                .sequenceName("SN")
                .build();

        invoiceService = new InvoiceService(invoiceRepository, company, cartService);
    }

    @Test
    void return_id_of_new_invoice() {
        // given
        Invoice invoice = new Invoice();
        invoice.setId(INVOICE_ID);
        when(invoiceRepository.save(any())).thenReturn(invoice);

        // when
        long invoiceId = invoiceService.createInvoice(new Order());

        // then
        assertEquals(INVOICE_ID, invoiceId);
    }

}
