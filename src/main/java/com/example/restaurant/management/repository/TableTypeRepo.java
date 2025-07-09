package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.TableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TableTypeRepo extends JpaRepository<TableType, UUID> {
}
