package com.codeacademy.eshop.invoice.service;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.invoice.model.Invoice;
import com.codeacademy.eshop.invoice.repository.InvoiceRepository;
import com.codeacademy.eshop.order.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /**
     * Creates the invoice for the given order.
     * This also takes the company details from the configuration properties.
     */
    public long createInvoice(Order createdOrder) {
        var products = createdOrder.getProducts();
        CartPrice cartPrice = cartService.countTotalPrice(products);
        long seqNr = getNextInvoiceSequence();
        Invoice invoice = new Invoice();
        invoice.setCompany(company);
        invoice.setOrder(createdOrder);
        invoice.setPrices(cartPrice);
        invoice.setSequenceNo(seqNr);
        invoice.setFullName(getFullInvoiceName(seqNr));
        return invoiceRepository.save(invoice).getId();
    }

    public Invoice findById(long id) {
        return invoiceRepository.getOne(id);
    }

    public Page<Invoice> getAllInvoices(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    public CartPrice getPriceByOrderId(long id) {
        return invoiceRepository.findByOrderId(id).getPrices();
    }


    /**
     * Find the last sequence of all invoices
     */
    private long getNextInvoiceSequence() {
        var invoices = invoiceRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        if (invoices.size() == 0) {
            return 1;
        }
        return invoices.get(0).getSequenceNo() + 1;
    }

    private String getFullInvoiceName(long sequenceNo) {
        return company.getSequenceName().concat("-00").concat(String.valueOf(sequenceNo));
    }
}
