package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.DishAlreadyExistException;
import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.repository.DishRepository;
import com.trainingMug.foodiecli.util.Factory;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{
    private DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishList() {
        return dishRepository.getAllDishes();
    }

    @Override
    public Dish addDish(Dish dish) throws DishAlreadyExistException {
        Optional<Dish> optionaDish = dishRepository.getDishBYId(dish.getId());
        if(optionaDish.isPresent())
            throw new DishAlreadyExistException("Dish ALready Found"+dish.getId());
        return this.dishRepository.addDish(dish);
    }

    @Override
    public Dish getByDishId(String id) throws DishNotFoundException {
        Optional<Dish>  optionalDish= dishRepository.getDishBYId(id);
        if(!optionalDish.isPresent())
            throw new DishNotFoundException("Dish not found with "+id);
        return optionalDish.get();
    }

    @Override
    public Dish updateDish(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.getDishBYId((dish.getId()));
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + dish.getId());
        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void delete(String id) throws DishNotFoundException{
        Optional<Dish> dishById = this.dishRepository.getDishBYId(id);
        if(dishById.isEmpty())
            throw new DishNotFoundException("Dish Not Found with Id : " + id);
        this.dishRepository.deleteDish(dishById.get());
    }
}
