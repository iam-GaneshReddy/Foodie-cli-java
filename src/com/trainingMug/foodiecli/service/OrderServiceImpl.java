package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.OrderExistException;
import com.trainingMug.foodiecli.exceptions.OrderNotFoundException;
import com.trainingMug.foodiecli.model.Order;
import com.trainingMug.foodiecli.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    @Override
    public Order save(Order order) throws OrderExistException {
        Optional<Order> orderOptional = orderRepository.getOrderById(order.getId());
        if(orderOptional.isPresent())
            throw new OrderExistException("Enter details already found");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public Order getById(String id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.getOrderById(id);
        if(orderOptional.isEmpty())
            throw new OrderNotFoundException("Entered"+id+"is not found");
        return orderOptional.get();
    }
}
