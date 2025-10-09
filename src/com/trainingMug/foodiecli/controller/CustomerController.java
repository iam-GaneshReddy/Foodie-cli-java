package com.trainingMug.foodiecli.controller;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.repository.CustomerRepository;
import com.trainingMug.foodiecli.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }
    public Customer save(Customer customer) throws CustomerExistException {
       return this.customerService.save(customer);
    }
    public Customer validateCustomerLogin(String email,String password)throws CustomerNotFoundException{
        return this.customerService.validateEmailPassword(email,password);
    }
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        return this.customerService.getById(id);
    }
    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        return customerService.updateCustomer(customer);
    }
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        customerService.deleteCustomer(id);
    }

}
