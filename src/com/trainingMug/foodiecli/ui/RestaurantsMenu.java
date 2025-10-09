package com.trainingMug.foodiecli.ui;

import com.trainingMug.foodiecli.controller.RestaurantController;
import com.trainingMug.foodiecli.exceptions.DishNotFoundException;
import com.trainingMug.foodiecli.exceptions.RestaurantExistException;
import com.trainingMug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.model.Restaurant;
import com.trainingMug.foodiecli.service.RestaurantService;
import com.trainingMug.foodiecli.util.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantsMenu extends Menu {
    private RestaurantController restaurantController;
    public RestaurantsMenu(){
        this.restaurantController= Factory.getRestaurantController();
    }

    public void displayMenu(){
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO RESTAURANT SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Restaurant");
                System.out.println("2. View All Restaurants");
                System.out.println("3. Search Restaurant");
                System.out.println("4. Update Restaurant ");
                System.out.println("5. Delete Restaurant");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> newRestaurantForm();
                    case 2 -> displayRestaurants();
                    case 3 -> restaurantSearchForm();
                    case 4 -> restaurantUpdateForm();
                    case 5 -> restaurantDeleteForm();
                    case 6 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }
    public void newRestaurantForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Dishes for Menu separated by : (D010:D009)");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setId(id)
                    .setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurant savedRestaurant = Factory.getRestaurantController().addRestaurant(restaurant);
            displayRestaurant(savedRestaurant);
        } catch (RestaurantExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            newRestaurantForm();
        }

    }

    public void restaurantSearchForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Restaurant \n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Restaurant restaurant = restaurantController.getRestaurantById(id);
            displayRestaurant(restaurant);
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }

    }
    public void restaurantUpdateForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Restaurant\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant Deleted Successfully");
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }

    }
    public void  restaurantDeleteForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Restaurant\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant Deleted Successfully");
        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }

    }
    public void displayRestaurants() {
        List<Restaurant> restaurantList = this.restaurantController.getAllRestaurants();
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
        });
    }

    public void displayRestaurant(Restaurant restaurant) {
        displayMenuHeader("Restaurant Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
    }

    public void displayMenuItems(String restaurantId) throws RestaurantNotFoundException, DishNotFoundException {
        displayMenuHeader("Dishes Menu Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        //RestaurantService restaurantService = Factory.getRestaurantService();
        List<Dish> dishItems = Factory.getRestaurantController().getDishItems(restaurantId);
        for(Dish dish : dishItems){
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        }
    }

}
