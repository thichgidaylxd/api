package com.example.restaurant.management.dto.ApiRe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiErrorResponse {
    private int code;
    private String status;
    private String message;
    private String path;
    private String timestamp;
}
