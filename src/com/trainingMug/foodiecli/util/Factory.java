package com.trainingMug.foodiecli.util;

import com.trainingMug.foodiecli.controller.CustomerController;
import com.trainingMug.foodiecli.repository.CustomerRepository;
import com.trainingMug.foodiecli.service.CustomerServiceImpl;

public class Factory {
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }
    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }
    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }
}
