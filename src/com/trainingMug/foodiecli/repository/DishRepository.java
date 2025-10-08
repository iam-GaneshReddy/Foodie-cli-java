package com.trainingMug.foodiecli.repository;

import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class DishRepository {
    private List<Dish> dishList;

    public DishRepository(){
        CsvReader csvReader = new CsvReader();
        dishList=csvReader.readDishesFromCSV();
    }

    public List<Dish> getAllDishes(){
        return this.dishList;
    }
    public Dish addDish(Dish dish){
        dishList.add(dish);
        return dish;
    }
    public Optional<Dish> getDishBYId(String id){
        return dishList.stream().filter(dish->dish.getId().equals(id)).findFirst();
    }
    public Dish deleteDish(Dish dish){
        dishList.remove(dish);
        return dish;
    }
    public Dish updateDish(Dish dishToBeUpdated) {
        Optional<Dish> dishOptional = this.dishList.stream().filter(dish -> dish.getId().equals(dishToBeUpdated.getId()))
                .findFirst()
                .map(dish -> {
                    dish.setName(dishToBeUpdated.getName())
                            .setPrice(dishToBeUpdated.getPrice())
                            .setDescription(dishToBeUpdated.getDescription());
                    return dish;
                });
        return dishOptional.orElse(null);
    }
}
