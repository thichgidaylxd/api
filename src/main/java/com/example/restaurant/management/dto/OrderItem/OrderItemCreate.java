package com.example.restaurant.management.dto.OrderItem;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemCreate {
    private UUID tableId;
    private UUID dishId;
    private int quantity;
    private String note;
}