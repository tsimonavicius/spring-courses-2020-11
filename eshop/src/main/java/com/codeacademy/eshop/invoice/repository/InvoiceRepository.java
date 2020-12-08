package com.codeacademy.eshop.invoice.repository;

import com.codeacademy.eshop.invoice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
