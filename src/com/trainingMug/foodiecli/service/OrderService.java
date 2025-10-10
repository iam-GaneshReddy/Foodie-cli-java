package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.OrderExistException;
import com.trainingMug.foodiecli.exceptions.OrderNotFoundException;
import com.trainingMug.foodiecli.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order save(Order order)throws OrderExistException;

    public List<Order> getOrders();

    public Order getById(String id)throws OrderNotFoundException;
}
