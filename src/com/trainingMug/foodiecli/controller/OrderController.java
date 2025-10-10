package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.OrderExistException;
import com.trainingMug.foodiecli.exceptions.OrderNotFoundException;
import com.trainingMug.foodiecli.model.Order;
import com.trainingMug.foodiecli.service.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService){
        this.orderService=orderService;
    }

    public Order save(Order order) throws OrderExistException {
       return orderService.save(order);
    }
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    public Order getById(String id) throws OrderNotFoundException {
      return orderService.getById(id);
    }
}
