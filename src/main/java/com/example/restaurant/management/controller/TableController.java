package com.example.restaurant.management.controller;

import com.example.restaurant.management.dto.ApiRe.ApiResponse;
import com.example.restaurant.management.entity.Tables;
import com.example.restaurant.management.service.TableService;
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
@RequestMapping("/tables")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TableController {

    TableTypeService tableTypeService;
    TableService tableService;
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public ApiResponse<List<Tables>> getAllTable() {

        List<Tables> allTables = tableService.findAll();
        messagingTemplate.convertAndSend("/topic/tables", allTables);

        return ApiResponse.<List<Tables>>builder()
                .data(allTables)
                .message("Danh sách bàn")
                .build();
    }


//    // Get tableorder by id
//    @GetMapping("/{id}/items")
//    ApiResponse<List<OrderItemRequest>> getTableByName(@PathVariable String id){
//        ApiResponse<List<OrderItemRequest>> apiResponse = new ApiResponse<>();
//        apiResponse.setData(orderItemService.findItemsByTableId(id));
//        return apiResponse;
//    }



    @PostMapping
    public ApiResponse<Tables> addTable(@RequestBody Tables table) {
        Tables newTable = tableService.createTable(table);

        messagingTemplate.convertAndSend("/topic/table-added", newTable);

        return ApiResponse.<Tables>builder()
                .data(newTable)
                .message("Thêm bàn thành công")
                .build();
    }

    @DeleteMapping("/{tableId}")
    public ApiResponse<Tables> deleteTable(@PathVariable UUID tableId) {
        Tables deletedTable = tableService.findById(tableId);

        tableService.deleteTable(tableId);

        messagingTemplate.convertAndSend("/topic/table-deleted", deletedTable);

        return ApiResponse.<Tables>builder()
                .message("Bàn đã xóa thành công")
                .build();
    }
}
