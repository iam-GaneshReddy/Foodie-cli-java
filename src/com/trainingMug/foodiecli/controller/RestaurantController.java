package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private RestaurantServiceImpl restaurantService;
    public RestaurantController(RestaurantServiceImpl restaurantService){
        this.restaurantService=restaurantService;
    }
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantExistException {
        restaurantService.addRestaurant(restaurant);
        return restaurant;
    }
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return this.restaurantService.getRestaurantById(id);
    }
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getRestaurantList();
    }
    public Restaurant updateRestaurant(Restaurant toBeUpdated) throws RestaurantNotFoundException {
        return restaurantService.updateRestaurant(toBeUpdated);
    }
    public Restaurant searchRestaurant(String id) throws RestaurantNotFoundException {
        return restaurantService.getRestaurantById(id);
    }
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        restaurantService.deleteRestaurant(id);
    }
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        return this.restaurantService.getDishItems(id);
    }
}
