package com.example.questionPro.Service;

import com.example.questionPro.Dto.OrderItemRequest;
import com.example.questionPro.Enum.OrderStatus;
import com.example.questionPro.Mapper.GroceryItemMapper;
import com.example.questionPro.Mapper.OrderMapper;
import com.example.questionPro.Model.GroceryItem;
import com.example.questionPro.Model.Order;
import com.example.questionPro.Model.OrderItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GroceryItemMapper groceryItemMapper;

    public Order createOrder(List<OrderItemRequest> orderItems) throws NotFoundException, JsonProcessingException {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(0.0); // Initialize total amount to 0

        List<OrderItem> orderItemList = new ArrayList<>();
        for (OrderItemRequest itemRequest : orderItems) {
            Long itemId = itemRequest.getItemId();
            int quantity = itemRequest.getQuantity();

            GroceryItem groceryItem = groceryItemMapper.getGroceryItemById(itemId);

            if (groceryItem != null) {

                double itemSubTotal = groceryItem.getPrice() * quantity;
                order.setTotalAmount(order.getTotalAmount() + itemSubTotal);

                OrderItem orderItem = new OrderItem();
                orderItem.setGroceryItem(groceryItem);
                orderItem.setQuantity(quantity);
                orderItem.setSubTotal(itemSubTotal);

                orderItemList.add(orderItem);
            } else {
                throw new NotFoundException("this item no longer exit");
            }
        }

        order.setOrderItemList(orderItemList);
        String orderItemsString = objectMapper.writeValueAsString(orderItemList);
        order.setOrderItems(orderItemsString);
        order.setStatus(OrderStatus.CREATED);
        orderMapper.insert(order);

        return order;
    }
}
