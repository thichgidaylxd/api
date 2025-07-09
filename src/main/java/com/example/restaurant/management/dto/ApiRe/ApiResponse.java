package com.example.restaurant.management.dto.ApiRe;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    @Builder.Default
    private int code = 200;

    @Builder.Default
    private String status = "success";

    private String message;
    private T data;
}
