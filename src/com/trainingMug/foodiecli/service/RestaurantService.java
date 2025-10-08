package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.model.Restaurant;

public interface RestaurantService {
    public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantExistException;
}
