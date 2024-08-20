package com.project.inventorymanagementsystem.controller;

import com.project.inventorymanagementsystem.model.Order;
import com.project.inventorymanagementsystem.model.UserProduct;
import com.project.inventorymanagementsystem.service.OrderJpaService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController{
    @Autowired
    OrderJpaService orderJpaService;


    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order orderDetails){
        return orderJpaService.addOrder(orderDetails);
    }

    @PutMapping("/orders/{orderId}")
    public Order updateOrder(@PathVariable("orderId") int orderId,@RequestBody Order orderDetails) {
        return orderJpaService.updateOrder(orderId,orderDetails);
    }

    @GetMapping("/orders")
    public ArrayList<Order> getOrders(){
        return orderJpaService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrderById(@PathVariable("orderId") int orderId){
        return orderJpaService.getOrderById(orderId);
    }

//    @DeleteMapping("/orders/{orderId}")
//    public void deleteOrder(@PathVariable("orderId") int orderId){
//        orderJpaService.deleteOrder(orderId);
//    }
}
