package com.codeacademy.eshop.invoice.service;

import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.invoice.model.Invoice;
import com.codeacademy.eshop.invoice.repository.InvoiceRepository;
import com.codeacademy.eshop.order.model.Order;
import com.codeacademy.eshop.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceShould {

    private static final long INVOICE_ID = 123L;
    private static final Invoice SAVED_INVOICE = Invoice.builder()
            .id(INVOICE_ID)
            .build();

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private CartService cartService;

    @Captor
    private ArgumentCaptor<Invoice> invoiceCaptor;

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

        when(invoiceRepository.save(any())).thenReturn(SAVED_INVOICE);
    }

    @Test
    void return_id_of_new_invoice() {
        // when
        long invoiceId = invoiceService.createInvoice(new Order());

        // then
        assertEquals(INVOICE_ID, invoiceId);
    }


    @Test
    void create_new_invoice_when_no_invoices_exists() {

        // given
        Order orderWithProducts = new Order();
        orderWithProducts.setProducts(List.of(new Product()));

        Invoice expectedInvoice = Invoice.builder()
                .sequenceNo(1L)
                .fullName("SN-001")
                .order(orderWithProducts)
                .build();

        // when
        invoiceService.createInvoice(orderWithProducts);

        // then
        verify(invoiceRepository).save(invoiceCaptor.capture());

        Invoice actualInvoice = invoiceCaptor.getValue();
        assertInvoiceEquals(expectedInvoice, actualInvoice);
    }

    private void assertInvoiceEquals(Invoice expected, Invoice actual) {
        assertOrderEquals(expected.getOrder(), actual.getOrder());

        assertThat(actual.getSequenceNo()).isEqualTo(expected.getSequenceNo());
        assertThat(actual.getFullName()).isEqualTo(expected.getFullName());
        assertThat(actual.getCreatedAt()).isEqualTo(expected.getCreatedAt());
    }

    private void assertOrderEquals(@NotNull Order expected, @NotNull Order actual) {

        assertThat(actual.getProducts()).hasSize(expected.getProducts().size());
        // should assert all the fields...
    }
}
