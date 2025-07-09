package com.example.restaurant.management.dto.OrderItem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemUpdateStatus {
    private UUID uuid;
    private String status;
}
