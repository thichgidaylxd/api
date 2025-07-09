package com.example.restaurant.management.util;

import com.example.restaurant.management.dto.OrderItem.OrderItemResponse;
import com.example.restaurant.management.dto.response.InvoiceDishRespone;
import com.example.restaurant.management.dto.response.InvoiceResponse;
import com.example.restaurant.management.entity.Dish;
import com.example.restaurant.management.entity.Invoice;
import com.example.restaurant.management.entity.InvoiceDish;
import com.example.restaurant.management.entity.OrderItem;
import com.example.restaurant.management.exception.AppException;
import com.example.restaurant.management.exception.ErrorCode;
import com.example.restaurant.management.repository.DishRepo;
import com.example.restaurant.management.repository.InvoiceDishRepo;


import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Builder {

    public static OrderItemResponse buildOrderItemResponse(OrderItem orderItem){
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .tableId(orderItem.getTableOrder().getTable().getId())
                .dishId(orderItem.getDish().getId())
                .dishName(orderItem.getDish().getName())
                .price(orderItem.getDish().getPrice())
                .unit(orderItem.getDish().getUnit())
                .image(orderItem.getDish().getImage())
                .quantity(orderItem.getQuantity())
                .note(orderItem.getNote())
                .status(orderItem.getStatus())
                .build();
    }

//    public static List<InvoiceDishRespone> toInvoiceDishResponse(List<Invoice> invoices){
//        List<InvoiceDishRespone> invoiceDishRespones;
//        for(Invoice invoice: invoices){
//            List<InvoiceDish> invoiceDishes = invoiceDishRepo.findByInvoice_Id(invoice.getId());
//            invoiceDishRespones = invoiceDishes.stream()
//                    .map(invoiceDish ->Builder.toInvoiceDishResponse(invoiceDish))
//                    .toList();
//        }
//
//    }

    public static List<InvoiceDishRespone> toInvoiceDishResponses(Invoice invoice, InvoiceDishRepo invoiceDishRepo, DishRepo dishRepo) {
        List<InvoiceDish> invoiceDishes = invoiceDishRepo.findByInvoiceId(invoice.getId());

        Map<UUID, Dish> dishMap = dishRepo.findAllById(
                invoiceDishes.stream().map(InvoiceDish::getDishId).toList()
        ).stream().collect(Collectors.toMap(Dish::getId, Function.identity()));

        return invoiceDishes.stream()
                .map(invoiceDish -> {
                    Dish dish = dishMap.get(invoiceDish.getDishId());
                    if (dish == null) throw new AppException(ErrorCode.DISH_NOT_FOUND);
                    return toInvoiceDishResponse(invoiceDish, dish);
                })
                .toList();
    }


    public static InvoiceDishRespone toInvoiceDishResponse(InvoiceDish invoiceDish, Dish dish) {
        return InvoiceDishRespone.builder()
                .invoiceId(invoiceDish.getInvoiceId())
                .dishId(invoiceDish.getDishId())
                .dishName(dish.getName())
                .price(dish.getPrice())
                .unit(dish.getUnit())
                .image(dish.getImage())
                .quantity(invoiceDish.getQuantity())
                .build();
    }


    public static InvoiceDish toInvoiceDish(OrderItem item, UUID invoiceId) {
        return InvoiceDish.builder()
                .dishId(item.getDish().getId())
                .invoiceId(invoiceId)
                .quantity(item.getQuantity())
                .build();
    }



}
