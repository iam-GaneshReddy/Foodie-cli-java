package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.service.RestaurantServiceImpl;

public class RestaurantController {
    private RestaurantServiceImpl restaurantService;
    public RestaurantController(RestaurantServiceImpl restaurantService){
        this.restaurantService=restaurantService;
    }
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantExistException {
        restaurantService.addRestaurant(restaurant);
        return restaurant;
    }
}
