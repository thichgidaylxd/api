package com.example.restaurant.management.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishRequest {
    private String id;
    private String ten;
    private BigDecimal gia;
    private String donViTinh;
    private String moTa;
    private Boolean trangThai;
}
