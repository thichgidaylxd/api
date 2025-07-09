package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.DishType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishTypeRepo extends JpaRepository<DishType, UUID> {
    DishType findByName(String name);
    void deleteByName(String name);
}
