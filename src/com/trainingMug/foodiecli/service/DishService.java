package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.model.Dish;

import java.util.List;

public interface DishService {
    public List<Dish> getDishList();
    public Dish addDish(Dish dish)throws DishAlreadyExistException;
    public Dish getByDishId(String id)throws DishNotFoundException;
    public Dish updateDish(Dish dish)throws DishNotFoundException;
    public void delete(String id) throws DishNotFoundException;
}
