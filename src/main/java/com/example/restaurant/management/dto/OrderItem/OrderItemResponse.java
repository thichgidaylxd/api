package com.example.restaurant.management.dto.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemResponse {
    private UUID id;
    private UUID tableId;//
    private UUID dishId;//
    private String dishName;
    private BigDecimal price;
    private String unit;
    private byte[] image;
    private Integer quantity;//
    private String note;//
    private String status;
}
