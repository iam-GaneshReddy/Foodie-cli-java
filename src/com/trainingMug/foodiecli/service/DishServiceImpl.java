package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.repository.DishRepository;

import java.util.Optional;

public class DishServiceImpl implements DishService{
    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }
    @Override
    public Dish addDish(Dish dish) throws DishAlreadyExistException {
        Optional<Dish> optionaDish = dishRepository.getDishBYId(dish.getId());
        if(optionaDish.isPresent())
            throw new DishAlreadyExistException("Dish ALready Found"+dish.getId());
        return this.dishRepository.addDish(dish);

    }
}
