package com.example.restaurant.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;

    public Customer(String name, String phone){
        this.name = name;
        this.phone =phone;
    }
    private String name;

    @Column(unique = true, nullable = false)
    private String phone;
}