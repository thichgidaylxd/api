package com.example.restaurant.management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableOrderRequest {
    private String id;
    private String idBan;
    private LocalDateTime thoiGianTao;
}
