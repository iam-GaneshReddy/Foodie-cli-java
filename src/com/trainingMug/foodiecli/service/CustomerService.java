package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingMug.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;

    public Customer validateEmailPassword(String email,String password)throws CustomerNotFoundException;

    public Customer getById(String id)throws CustomerNotFoundException;
    public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
    public List<Customer> getAllCustomers();
    public void deleteCustomer(String id) throws CustomerNotFoundException;
}
