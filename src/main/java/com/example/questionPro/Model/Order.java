package com.example.questionPro.Model;

import com.example.questionPro.Enum.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private List<OrderItem> orderItemList;
    private double totalAmount;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String orderItems;


}
