package com.example.restaurant.management.dto.response;


import com.example.restaurant.management.dto.OrderItem.OrderItemResponse;
import com.example.restaurant.management.entity.Customer;
import com.example.restaurant.management.entity.InvoiceDish;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceResponse {
    UUID invoiceId;
    String tableName;
    List<InvoiceDishRespone> invoiceDishRespones;
    Customer customer;
    String status;
}
