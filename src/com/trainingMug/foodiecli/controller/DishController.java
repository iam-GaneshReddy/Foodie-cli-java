package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.service.DishServiceImpl;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService){
        this.dishService = dishService;
    }
    public Dish addDish(Dish dish)throws DishAlreadyExistException {
        dishService.addDish(dish);
        return dish;
    }
}
