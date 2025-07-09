package com.example.restaurant.management.repository;

import com.example.restaurant.management.dto.response.InvoiceResponse;
import com.example.restaurant.management.entity.Invoice;
import com.example.restaurant.management.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, UUID> {

    List<Invoice> findByTableOrder_Table_Id(UUID tableId);
}
