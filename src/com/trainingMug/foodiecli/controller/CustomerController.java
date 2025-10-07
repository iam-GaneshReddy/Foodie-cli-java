package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.repository.CustomerRepository;
import com.trainingMug.foodiecli.service.CustomerServiceImpl;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }

    public Customer save(Customer customer) throws CustomerExistException {
       return this.customerService.save(customer);
    }
}
