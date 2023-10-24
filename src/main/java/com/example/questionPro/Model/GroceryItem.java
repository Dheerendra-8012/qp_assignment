package com.example.questionPro.Model;

import lombok.Data;

@Data
public class GroceryItem {
    private Long id;
    private String name;
    private double price;
    private int quantity;

}
