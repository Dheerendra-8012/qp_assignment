package com.example.questionPro.Mapper;

import com.example.questionPro.Enum.OrderStatus;
import com.example.questionPro.Model.Order;
import com.example.questionPro.Model.OrderItem;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO `order` (id, total_amount, status, order_date, order_items ) VALUES (#{id}, #{order.totalAmount}, #{order.status}, #{order.orderDate}, #{order.orderItems})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Order order);

    @Insert("INSERT INTO order_item (order_id, item_id, quantity) VALUES (#{orderId}, #{itemId}, #{quantity}")
    void insertOrderItem(@Param("orderId") Long orderId, @Param("itemId") Long itemId, @Param("quantity") int quantity);

    @Select("SELECT * FROM `order` WHERE id = #{id}")
    Order getOrderById(Long id);

    @Select("SELECT * FROM order_item WHERE order_id = #{orderId}")
    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    @Update("UPDATE `order` SET status = #{status} WHERE id = #{id}")
    void updateOrderStatus(@Param("id") Long orderId, @Param("status") OrderStatus status);

}
