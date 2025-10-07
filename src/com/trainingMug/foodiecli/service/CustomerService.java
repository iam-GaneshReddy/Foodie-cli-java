package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;
}
