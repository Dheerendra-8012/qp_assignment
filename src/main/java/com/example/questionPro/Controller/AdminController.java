package com.example.questionPro.Controller;

import com.example.questionPro.Dto.GroceryItemRequest;
import com.example.questionPro.Model.GroceryItem;
import com.example.questionPro.Service.GroceryItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/admin/grocery-items")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private GroceryItemService itemService;

    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItemRequest itemRequest) {
        // Implement logic to add a new grocery item
        try {
            GroceryItem groceryItemResponse = itemService.addGroceryItem(itemRequest);
            return new ResponseEntity<>(groceryItemResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("Error in addGroceryItem" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> viewGroceryItems() {
        try {
            List<GroceryItem> items = itemService.getAllGroceryItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error in viewGroceryItems" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
        try{
            // Implement logic to remove a grocery item by its ID
            itemService.removeGroceryItem(itemId);
            return new ResponseEntity<>("Item removed successfully", HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error in removeGroceryItem" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/{itemId}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        try{
            // Implement logic to update the grocery item details
            GroceryItem updated = itemService.updateGroceryItem(itemId, updatedItem);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error in updateGroceryItem" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/{itemId}/manage-inventory")
    public ResponseEntity<String> manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        try{
            // Implement logic to manage inventory levels for a grocery item
            itemService.manageInventory(itemId, quantity);
            return new ResponseEntity<>("Inventory managed successfully", HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error in updateGroceryItem" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
