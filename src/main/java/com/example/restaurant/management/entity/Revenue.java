package com.example.restaurant.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "revenue")
public class Revenue {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate date;
    private BigDecimal totalAmount;
    private Integer invoiceCount;
    private Integer dishSoldCount;
}