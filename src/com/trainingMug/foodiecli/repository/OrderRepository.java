package com.trainingMug.foodiecli.repository;

import com.trainingMug.foodiecli.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orderList;

    public OrderRepository(){
        orderList=new ArrayList<>();
    }
    public Order save(Order order){
        orderList.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return this.orderList;
    }
    public Optional<Order> getOrderById(String id){
        return orderList.stream().filter(order->order.getId().equals(id)).findFirst();
    }

}
