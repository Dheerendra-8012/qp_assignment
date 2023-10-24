package com.example.questionPro.Controller;

import com.example.questionPro.Dto.OrderItemRequest;
import com.example.questionPro.Model.GroceryItem;
import com.example.questionPro.Service.GroceryItemService;
import com.example.questionPro.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.questionPro.Model.Order;

import java.util.List;

public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private GroceryItemService itemService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/grocery-items")
    public ResponseEntity<List<GroceryItem>> viewAvailableGroceryItems() {
        try{
            List<GroceryItem> items = itemService.getAllGroceryItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error in viewAvailableGroceryItems" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/orders")
    public ResponseEntity<Order> bookGroceryItems(@RequestBody List<OrderItemRequest> orderItems) {
        try{
            // Implement logic to create an order with the specified items
            Order order = orderService.createOrder(orderItems);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("Error in bookGroceryItems" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
