package com.example.questionPro.Dto;

import lombok.Data;

@Data
public class GroceryItemResponse {

    private Long id;
    private String name;
    private double price;
    private int quantity;

    @Override
    public String toString() {
        return "GroceryItemResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
