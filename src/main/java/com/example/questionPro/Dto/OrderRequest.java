package com.example.questionPro.Dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderItemRequest> items;

    // Getters and Setters

    @Override
    public String toString() {
        return "OrderRequest{" +
                "items=" + items +
                '}';
    }
}
