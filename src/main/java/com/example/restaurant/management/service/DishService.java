package com.example.restaurant.management.service;


import com.example.restaurant.management.entity.Dish;
import com.example.restaurant.management.entity.DishType;
import com.example.restaurant.management.exception.AppException;
import com.example.restaurant.management.exception.ErrorCode;
import com.example.restaurant.management.repository.DishRepo;
import com.example.restaurant.management.repository.DishTypeRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DishService {
    DishRepo dishRepo;
    DishTypeRepo dishTypeRepo;

    public List<Dish> findAll(){
        return dishRepo.findAll();
    }

    public List<Dish> findByDishType_Id(UUID dishTypeId){
        dishTypeRepo.findById(dishTypeId).orElseThrow(()->new AppException(ErrorCode.DISHTYPE_NOT_FOUND));
        return dishRepo.findAllByDishType_id(dishTypeId);
    }

    public Dish findById(UUID dishId){
        return dishRepo.findById(dishId)
                .orElseThrow(()-> new AppException(ErrorCode.DISH_NOT_FOUND));
    }


    public Dish createDish(Dish dish){
        dishTypeRepo.findById(dish.getDishType().getId())
                .orElseThrow(()->new AppException(ErrorCode.DISHTYPE_NOT_FOUND));
        return dishRepo.save(dish);
    }


    public void deleteDish(UUID dishId){
        dishRepo.deleteById(dishId);
    }

}
