package com.example.restaurant.management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Persistent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "table_order_id")
    private TableOrder tableOrder;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private BigDecimal sum;


    private Boolean paid = true;
    @PrePersist
    public void prePersist(){
        if(paid == null){
            setPaid(true);
        }
    }


    private LocalDateTime completedAt = LocalDateTime.now();
}
