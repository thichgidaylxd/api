package com.example.restaurant.management.Id;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDishId implements Serializable {
    private UUID dishId;
    private UUID menuId;
}
