package com.example.restaurant.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "table_type_id")
    private TableType tableType;

    @Column(unique = true, nullable = false)
    private String name;

    private String status = "Trống";
    private Integer maxPerson;
    private String note;
}
