package com.example.restaurant.management.dto.request.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TablesCreateRequest {
    private String name;
    private String tableTypeId;
    private String status = "Trống";
    private Integer maxPerson;
    private String note;
}

