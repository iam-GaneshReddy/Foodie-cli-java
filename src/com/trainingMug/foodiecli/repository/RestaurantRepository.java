package com.trainingMug.foodiecli.repository;

import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {
    private List<Restaurant> restaurantList;

    public RestaurantRepository(){
        CsvReader csvReader=new CsvReader();
        restaurantList=csvReader.readRestaurantFromCSV();
    }
    public List<Restaurant> getRestaurantList(){
        return this.restaurantList;
    }
    public Restaurant addRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }
    public Optional<Restaurant> getRestaurantById(String id){
        return restaurantList.stream().
                filter(restaurant->restaurant.getId().equals(id)).findFirst();

    }
    public void deleteRestaurant(Restaurant restaurant)
    {
        restaurantList.remove(restaurant);
    }
    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> optionalRestaurant = restaurantList.stream()
                .filter(resturant->resturant.getId().
                        equalsIgnoreCase(restaurantToBeUpdated.getId())).findFirst().
                map(restaurant -> {
                            restaurant.setId(restaurantToBeUpdated.getId())
                                    .setName(restaurantToBeUpdated.getName()).setAddress(restaurantToBeUpdated.getAddress())
                                    .setMenu(restaurantToBeUpdated.getMenu());
                            return restaurant;
                        }

                );
      return  optionalRestaurant.orElse(null);
    }
    public List<String> getAllDishItems(String id){
        Optional<List<String>> optional=restaurantList.stream().filter(restaurant->restaurant.getId().equals(id)).findFirst().map(Restaurant::getMenu);
        return optional.get();
    }
}
