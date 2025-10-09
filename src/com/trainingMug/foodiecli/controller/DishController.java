package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.service.DishServiceImpl;

import java.util.List;

public class DishController {
    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService){
        this.dishService = dishService;
    }
    public Dish addDish(Dish dish)throws DishAlreadyExistException {
        dishService.addDish(dish);
        return dish;
    }
    public Dish getByDishId(String id) throws DishNotFoundException {
        dishService.getByDishId(id);
        return dishService.getDishList().stream().filter(dish->dish.getId().equals(id)).findFirst().get();
    }
    public List<Dish> getDishList(){
        return dishService.getDishList();
    }
    public Dish updateDish(Dish dish) throws DishNotFoundException {
        return dishService.updateDish(dish);
    }
    public void delete(String id) throws DishNotFoundException {
        this.dishService.delete(id);
    }

}
