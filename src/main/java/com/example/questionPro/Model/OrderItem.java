package com.example.questionPro.Model;

import lombok.Data;

@Data
public class OrderItem {
    private Long id;
    private GroceryItem groceryItem;
    private int quantity;
    private double subTotal;

    // Getters and Setters

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", groceryItem=" + groceryItem +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
