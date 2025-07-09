package com.example.restaurant.management.controller;


import com.example.restaurant.management.dto.ApiRe.ApiResponse;
import com.example.restaurant.management.dto.response.InvoiceResponse;
import com.example.restaurant.management.service.InvoiceService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InvoiceController {
    InvoiceService invoiceService;


    @GetMapping("/{tableId}")
    public ApiResponse<Object> findByTableId(@PathVariable UUID tableId){
        List<InvoiceResponse> invoice = invoiceService.findByTableId(tableId);
        return ApiResponse.builder()
                .data(invoice)
                .message("Danh sách hóa đơn theo bàn")
                .build();
    }

    @PostMapping("/{tableId}")
    public ApiResponse<InvoiceResponse> createInvoice(@PathVariable UUID tableId){
        InvoiceResponse invoice = invoiceService.createInvoice(tableId);
        return ApiResponse.<InvoiceResponse>builder()
                .data(invoice)
                .message("Tạo hóa đơn thành công")
                .build();
    }

//    @GetMapping("/{tableId}")
//    public ApiResponse<InvoiceResponse> findInvoiceByTableId(@PathVariable UUID tableId){
//
//    }

}
