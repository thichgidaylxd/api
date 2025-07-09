package com.example.restaurant.management.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    TABLE_EXISTED(HttpStatus.CONFLICT,"Table existed"),
    UNCATEGORIZED_EXCEPTION (HttpStatus.INTERNAL_SERVER_ERROR,"Uncategorized error"),
    TABLE_NOT_FOUND(HttpStatus.NOT_FOUND,"Table not found"),
    DISH_NOT_FOUND(HttpStatus.NOT_FOUND,"Dish not found"),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND,"Item not found"),
    INVOICE_NOT_FOUND(HttpStatus.NOT_FOUND,"Invoice not found"),
    ITEM_MUST_BE_NOT_EMPTY(HttpStatus.BAD_REQUEST,"Item must be not empty"),
    DISHTYPE_NOT_FOUND(HttpStatus.NOT_FOUND,"Dish type not found"),
    TABLE_HAVE_NOT_ITEMS(HttpStatus.NOT_FOUND,"Table haven't items"),
    TABLETYPE_NOT_FOUND(HttpStatus.NOT_FOUND,"Table type not found"),

    ;

    HttpStatus httpStatus;
    private String message;

}
