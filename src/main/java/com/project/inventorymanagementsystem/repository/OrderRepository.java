package com.project.inventorymanagementsystem.repository;

import com.project.inventorymanagementsystem.model.Order;
import com.project.inventorymanagementsystem.model.UserProduct;

import java.util.List;


public interface OrderRepository {
 Order addOrder(Order orderDetails);

 Order updateOrder(int orderId,Order orderDetails);

 List<Order> getAllOrders();

 Order getOrderById(int orderId);

// void deleteOrder(int orderId);
}
