package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.model.Dish;

public interface DishService {
    public Dish addDish(Dish dish)throws DishAlreadyExistException;
}
