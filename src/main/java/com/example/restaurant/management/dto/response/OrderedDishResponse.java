package com.example.restaurant.management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderedDishResponse {
    private UUID id;
    private String dishName;
    private Integer quantity;
    private BigDecimal price;
    private String dishTypeName;
    private Boolean status;
    private String note;
}