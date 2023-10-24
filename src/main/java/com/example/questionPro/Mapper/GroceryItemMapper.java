package com.example.questionPro.Mapper;

import com.example.questionPro.Model.GroceryItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroceryItemMapper {
    @Select("SELECT * FROM grocery_item")
    List<GroceryItem> getAll();

    @Insert("INSERT INTO grocery_item (name, price, quantity) VALUES (#{name}, #{price}, #{quantity})")
    void insert(GroceryItem item);

    @Delete("DELETE FROM grocery_item WHERE id = #{id}")
    void delete(Long id);

    @Update("UPDATE grocery_item SET name = #{name}, price = #{price}, quantity = #{quantity} WHERE id = #{id}")
    void update(GroceryItem item);

    @Update("UPDATE grocery_item SET quantity = quantity + #{quantity} WHERE id = #{id}")
    void manageInventory(Long id, int quantity);

    @Select("SELECT * FROM grocery_item where id = #{id}")
    GroceryItem getGroceryItemById(Long id);
}
