package com.trainingMug.foodiecli.util;

import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.model.Dish;
import com.trainingMug.foodiecli.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvReader {

    public List<Customer> readCustomersFromCSV() {
        String CUSTOMERS_CSV_PATH="C:\\Users\\bbbb\\OneDrive\\Desktop\\Foodie-cli-java\\Data\\customers.csv";
        String line;
        List<Customer> customersList =new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERS_CSV_PATH))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Issues in reading csv file from the path :" + CUSTOMERS_CSV_PATH);
            System.exit(0);
        }
        return customersList;
    }
    public List<Restaurant> readRestaurantFromCSV(){
        String line;
        List<Restaurant> restaurantsList=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bbbb\\OneDrive\\Desktop\\Foodie-cli-java\\Data\\restaurants.csv"))){
            br.readLine();
            while ((line =br.readLine())!=null)
            {
                String [] data=line.split(",");
                Restaurant restaurant=new Restaurant();
                restaurant.setId(data[0]).
                        setName(data[1]).
                        setAddress(data[2]).
                        setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return restaurantsList;
    }
    public List<Dish> readDishesFromCSV() {
        String line;
        List<Dish> dishes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bbbb\\OneDrive\\Desktop\\Foodie-cli-java\\Data\\dishes.csv"))) {
              br.readLine();
              while((line=br.readLine())!=null){
                  String [] data=line.split(",");
                  Dish dish = new Dish();
                  dish.setId(data[0]).
                          setName(data[1]).
                          setDescription(data[2]).
                          setPrice(Double.parseDouble(data[3]));
                  dishes.add(dish);
              }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.exit(0);
        }
        return dishes;
    }

}
