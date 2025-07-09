package com.example.restaurant.management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
    private String id;
    private BigDecimal tong;
    private Boolean thanhToan;
    private LocalDateTime hoanThanhLuc;
}
