package com.example.restaurant.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "table_orders")
public class TableOrder {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Tables table;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private String status;


    @PrePersist
    public void prePersist() {
        if (status == null || status.isBlank()) {
            status = "Ordering";
        }
    }

}
