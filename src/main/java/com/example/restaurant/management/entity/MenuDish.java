package com.example.restaurant.management.entity;

import com.example.restaurant.management.Id.MenuDishId;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(MenuDishId.class)
@Table(name = "menus_dishes")
public class MenuDish {

    @Id
    private UUID dishId;

    @Id
    private UUID menuId;
}