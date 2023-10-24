package com.example.questionPro.Dto;

import lombok.Data;

@Data
public class OrderItemResponse {
    private Long itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private double subTotal;

    @Override
    public String toString() {
        return "OrderItemResponse{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
