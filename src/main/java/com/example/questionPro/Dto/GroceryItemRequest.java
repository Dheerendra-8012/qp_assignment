package com.example.questionPro.Dto;

import lombok.Data;

@Data
public class GroceryItemRequest {

    private String name;
    private double price;
    private int quantity;

}
