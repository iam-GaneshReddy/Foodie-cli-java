package com.trainingMug.foodiecli.model;

import java.util.Date;
import java.util.Objects;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dish> dishes;
    private double totalPrice;
    private Date orderDate;

    // Constructor


    public Order() {
    }

    // Getter for orderId
    public String getId() {
        return id;
    }

    // Setter for orderId
    public Order setId(String id) {
        this.id = id;
        return this;
    }

    // Getter for customer
    public Customer getCustomer() {
        return customer;
    }

    // Setter for customer
    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    // Getter for restaurant
    public Restaurant getRestaurant() {
        return restaurant;
    }

    // Setter for restaurant
    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    // Getter for dishes
    public List<Dish> getDishes() {
        return dishes;
    }

    // Setter for dishes
    public Order setDishes(List<Dish> dishes) {
        this.dishes = dishes;
        return this;
    }

    // Getter for totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    // Setter for totalPrice
    public Order setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    // Getter for orderDate
    public Date getOrderDate() {
        return orderDate;
    }

    // Setter for orderDate
    public Order setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    // Overriding hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, customer, restaurant, dishes, totalPrice, orderDate);
    }

    // Overriding equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return Double.compare(order.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, order.id) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(restaurant, order.restaurant) &&
                Objects.equals(dishes, order.dishes) &&
                Objects.equals(orderDate, order.orderDate);
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Order{" +
                " id ='" + id + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", dishes=" + dishes +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
