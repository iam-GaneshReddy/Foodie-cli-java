package com.trainingMug.foodiecli.util;

import com.trainingMug.foodiecli.controller.CustomerController;
import com.trainingMug.foodiecli.controller.DishController;
import com.trainingMug.foodiecli.controller.RestaurantController;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.repository.CustomerRepository;
import com.trainingMug.foodiecli.repository.DishRepository;
import com.trainingMug.foodiecli.repository.RestaurantRepository;
import com.trainingMug.foodiecli.service.CustomerServiceImpl;
import com.trainingMug.foodiecli.service.DishServiceImpl;
import com.trainingMug.foodiecli.service.RestaurantServiceImpl;

public class Factory {
    public static CsvReader getCsvReader(){
        return new CsvReader();
    }
    //Customers class
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }
    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }
    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }

    //Dishes class
    public static DishRepository getDishRepository(){
        return new DishRepository();
    }
    public static DishServiceImpl getDishServiceImpl(){
        return new DishServiceImpl(getDishRepository());
    }
    public static DishController getDishController(){
        return new DishController(getDishServiceImpl());
    }

    //Restaurant class
    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }
    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }
    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }

}
