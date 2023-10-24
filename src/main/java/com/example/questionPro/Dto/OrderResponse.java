package com.example.questionPro.Dto;

import com.example.questionPro.Enum.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private Long id;
    private List<OrderItemResponse> items;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;

}
