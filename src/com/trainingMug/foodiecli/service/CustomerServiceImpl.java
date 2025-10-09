package com.trainingMug.foodiecli.service;

import com.trainingMug.foodiecli.exceptions.CustomerExistException;
import com.trainingMug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.repository.CustomerRepository;

import java.util.List;
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
    @Override
    public Customer validateEmailPassword(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer=customerRepository.validateEmailPassword(email,password);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("customer not found please login");
        return optionalCustomer.get();
    }
    @Override
    public Customer getById(String id) throws CustomerNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerById(id);
        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("customer not found with Id-"+id);
        return optionalCustomer.get();
    }
    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerOptional=customerRepository.findCustomerById(customer.getCustomerId());
        if(customerOptional.isEmpty())
            throw new CustomerNotFoundException("please enter the id of Existing customer");
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> optional = customerRepository.findCustomerById(id);
        if(optional.isEmpty())
            throw new CustomerNotFoundException("Customer not found pls enter correct details");
        else
            customerRepository.deleteCustomer(optional.get());
    }

}
