package com.example.restaurant.management.entity;

import com.example.restaurant.management.Id.InvoiceDishId;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(InvoiceDishId.class)
@Table(name = "invoice_dishes")
public class InvoiceDish {

    @Id
    private UUID dishId;

    @Id
    private UUID invoiceId;

    private Integer quantity;
}