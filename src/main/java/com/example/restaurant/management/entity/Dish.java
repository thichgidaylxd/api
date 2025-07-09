package com.example.restaurant.management.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "dish_type_id")
    private DishType dishType;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String unit;

    private String note;

    @Lob
    private byte[] image;

    private Boolean status = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}