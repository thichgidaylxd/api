package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {
}
