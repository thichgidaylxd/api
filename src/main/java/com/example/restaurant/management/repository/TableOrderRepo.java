package com.example.restaurant.management.repository;

import com.example.restaurant.management.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableOrderRepo extends JpaRepository<TableOrder, UUID> {
    TableOrder findByTable_IdAndStatusNot(UUID tableId, String status);
    TableOrder findByTable_IdAndStatus(UUID tableId,String status);
    List<TableOrder> findByTableId(UUID tableId);


}
