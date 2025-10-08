package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.repository.RestaurantRepository;

import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{
    private RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository=restaurantRepository;
    }
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantExistException {
        Optional<Restaurant> optionalRestaurant=restaurantRepository.
                getRestaurantById(restaurant.getId());
        if(optionalRestaurant.isPresent())
            throw new RestaurantExistException("Restaurant already Exist"+restaurant.getId());
        return this.restaurantRepository.addRestaurant(restaurant);

    }

}
