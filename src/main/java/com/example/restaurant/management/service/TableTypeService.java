package com.example.restaurant.management.service;

import com.example.restaurant.management.entity.TableType;
import com.example.restaurant.management.exception.AppException;
import com.example.restaurant.management.exception.ErrorCode;
import com.example.restaurant.management.repository.TableTypeRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TableTypeService {

    TableTypeRepo tableTypeRepo;

    public List<TableType> findAll(){
        return tableTypeRepo.findAll();
    }

    public TableType findById(UUID id){
        return tableTypeRepo.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
    }

    public TableType createTaleType(TableType tableType){
        return tableTypeRepo.save(tableType);
    }

    public void deleteById(UUID tableTypeId){
        tableTypeRepo.deleteById(tableTypeId);
    }

}
