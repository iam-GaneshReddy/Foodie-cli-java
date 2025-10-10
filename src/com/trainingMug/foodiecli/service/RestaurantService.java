package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingMug.foodiecli.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantExistException;
    public List<Restaurant> getRestaurantList();
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotFoundException;
    public Restaurant getRestaurantById(String id)throws RestaurantNotFoundException;
    public void deleteRestaurant(String id) throws RestaurantNotFoundException;
}
