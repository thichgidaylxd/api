package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.Dish;
import com.example.restaurant.management.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepo extends JpaRepository<Dish, UUID> {
    List<Dish> findAllByDishType_id(UUID dishTypeId);

}
