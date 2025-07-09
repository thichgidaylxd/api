package com.example.restaurant.management.controller;


import com.example.restaurant.management.dto.ApiRe.ApiResponse;
import com.example.restaurant.management.entity.Dish;
import com.example.restaurant.management.service.DishService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dishes")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DishController {

    DishService dishService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    //   /?dishTypeId=
    @GetMapping
    public ApiResponse<List<Dish>> findByDishTypeId(@RequestParam(required = false) UUID dishTypeId){
        List<Dish> dishes = (dishTypeId!=null)
                ? dishService.findByDishType_Id(dishTypeId)
                : dishService.findAll();
        return ApiResponse.<List<Dish>>builder()
                .data(dishes)
                .message((dishTypeId!=null)
                        ? "Món theo loại món"
                        : "Tất cả món")
                .build();
    }

    @PostMapping
    public ApiResponse<Dish> createDish(@RequestBody Dish dish){
        Dish newDish = dishService.createDish(dish);
        messagingTemplate.convertAndSend("/topic/dish-added",newDish);
        return ApiResponse.<Dish>builder()
                .data(newDish)
                .message("thêm món thành công")
                .build();
    }

    @PutMapping("/{dishId}")
    public ApiResponse<Dish> updateDish(@RequestBody Dish dish){
        Dish newDish = dishService.createDish(dish);
        messagingTemplate.convertAndSend("/topic/dish-updated",newDish);
        return ApiResponse.<Dish>builder()
                .data(newDish)
                .message("Cập nhật món thành công")
                .build();
    }


    @DeleteMapping("/{dishId}")
    public ApiResponse<Dish> deleteDish(@PathVariable UUID dishId){
        dishService.deleteDish(dishId);
        return ApiResponse.<Dish>builder()
                .message("Món đã xóa thành công")
                .build();
    }


}
