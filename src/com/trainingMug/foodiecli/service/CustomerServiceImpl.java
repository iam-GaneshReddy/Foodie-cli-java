package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository=customerRepository;
    }
    @Override
    public Customer save(Customer customer) throws CustomerExistException {
        Optional<Customer> customerById = customerRepository.findCustomerById(customer.getCustomerId());
        if(customerById.isPresent())
            throw new CustomerExistException("Customer is already existed"+customer.getCustomerId());
        return this.customerRepository.save(customer);
    }
}
