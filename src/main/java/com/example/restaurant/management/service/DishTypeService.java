package com.example.restaurant.management.service;


import com.example.restaurant.management.entity.DishType;
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
public class DishTypeService {
    DishTypeRepo dishTypeRepo;

    public List<DishType> findAll(){
        return dishTypeRepo.findAll();
    }

    public DishType findByName(String dishTypeName){
        return dishTypeRepo.findByName(dishTypeName);
    }

    public DishType createDishType(DishType dishType){
        return dishTypeRepo.save(dishType);
    }

    public DishType updateDishType(DishType dishType){
        return dishTypeRepo.save(dishType);
    }

    public void deleteById(UUID dishTypeId){
        dishTypeRepo.deleteById(dishTypeId);
    }

    public void deleteDishTypeByName(String dishTypeName){
        dishTypeRepo.deleteByName(dishTypeName);
    }

}
