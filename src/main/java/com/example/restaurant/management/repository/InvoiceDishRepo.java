package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.InvoiceDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvoiceDishRepo extends JpaRepository<InvoiceDish, UUID> {
    List<InvoiceDish> findByInvoiceId(UUID invoiceId);
}
