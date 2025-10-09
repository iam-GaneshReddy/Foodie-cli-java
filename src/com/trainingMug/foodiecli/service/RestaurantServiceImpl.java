package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.repository.RestaurantRepository;
import com.trainingMug.foodiecli.util.Factory;

import java.util.ArrayList;
import java.util.List;
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
    @Override
    public List<Restaurant> getRestaurantList() {
        return restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.getRestaurantById(restaurantToBeUpdated.getId());
        if(optionalRestaurant.isEmpty())
            throw new RestaurantNotFoundException("Enter the Existed Restaurant Id"+restaurantToBeUpdated.getId()+"Not Found");
      return restaurantRepository.updateRestaurant(restaurantToBeUpdated);
    }

    @Override
    public Restaurant searchRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> optional=restaurantRepository.getRestaurantById(id);
        if(optional.isEmpty())
            throw new RestaurantNotFoundException("Enter the correct Id"+id+"Not Found");
        return optional.get();
    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantOptional=restaurantRepository.getRestaurantById(id);
        if(restaurantOptional.isEmpty())
            throw new RestaurantNotFoundException("Enter the correct Id"+id+"Not Found");
      restaurantRepository.deleteRestaurant(restaurantOptional.get());
    }
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.getRestaurantById(id);
        if(restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant Not Found with this Id  :" + id);
        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
        DishService dishService = Factory.getDishServiceImpl();
        for(String dishId : dishIds){
            Dish dish = dishService.getByDishId(dishId);
            dishList.add(dish);
        }
        return dishList;
    }
}
