package com.example.restaurant.management.controller;

import com.example.restaurant.management.dto.ApiRe.ApiResponse;
import com.example.restaurant.management.entity.TableType;
import com.example.restaurant.management.service.TableTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/tables/type")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TableTypeController {

    TableTypeService tableTypeService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;


    @GetMapping
    public ApiResponse<List<TableType>> findAllTable() {
        List<TableType> tableTypes = tableTypeService.findAll();

        // Push realtime về topic cụ thể cho client đang subscribe
        messagingTemplate.convertAndSend("/topic/tabletype-updates", tableTypes);

        return ApiResponse.<List<TableType>>builder()
                .data(tableTypes)
                .message("Danh sách loại bàn")
                .build();
    }

    @PostMapping
    public ApiResponse<TableType> addTableType(@RequestBody TableType tableType) {
        TableType newTableType = tableTypeService.createTaleType(tableType);

        messagingTemplate.convertAndSend("/topic/tabletype-added", newTableType);

        return ApiResponse.<TableType>builder()
                .data(newTableType)
                .message("Thêm loại bàn thành công")
                .build();
    }

    @DeleteMapping("/{tableTypeId}")
    public ApiResponse<TableType> deleteTable(@PathVariable UUID tableTypeId) {
        TableType deletedTableType = tableTypeService.findById(tableTypeId);
        tableTypeService.deleteById(tableTypeId);

        messagingTemplate.convertAndSend("/topic/tabletype-deleted", deletedTableType);

        return ApiResponse.<TableType>builder()
                .message("Xóa loại bàn thành công")
                .build();
    }
}
