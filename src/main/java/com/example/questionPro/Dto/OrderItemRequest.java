package com.example.questionPro.Dto;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long itemId;
    private int quantity;

}
