package com.example.questionPro.Service;

import com.example.questionPro.Dto.GroceryItemRequest;
import com.example.questionPro.Mapper.GroceryItemMapper;
import com.example.questionPro.Model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemMapper itemMapper;

    public List<GroceryItem> getAllGroceryItems() {
        return itemMapper.getAll();
    }

    public GroceryItem addGroceryItem(GroceryItemRequest itemRequest) {
        GroceryItem item = new GroceryItem();
        item.setName(itemRequest.getName());
        item.setPrice(itemRequest.getPrice());
        item.setQuantity(itemRequest.getQuantity());
        itemMapper.insert(item);
        return item;
    }

    public void removeGroceryItem(Long itemId) {
        itemMapper.delete(itemId);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        updatedItem.setId(itemId);
        itemMapper.update(updatedItem);
        return updatedItem;
    }

    public void manageInventory(Long itemId, int quantity) {
        itemMapper.manageInventory(itemId, quantity);
    }
}
