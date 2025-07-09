package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface TablesRepo extends JpaRepository<Tables, UUID> {
     boolean existsByName(String name);

     @Modifying
     @Transactional
     @Query("UPDATE Tables t SET t.status = :status WHERE t.id = :tableId")
     void updateStatusById(@Param("tableId") UUID tableId, @Param("status") String status);

}
