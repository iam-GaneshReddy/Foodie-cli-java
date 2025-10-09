package com.trainingMug.foodiecli.repository;

import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.util.CsvReader;
import com.trainingMug.foodiecli.util.Factory;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customerList;

    public CustomerRepository(){
        //CsvReader csvReader=new CsvReader();
        this.customerList = Factory.getCsvReader().readCustomersFromCSV();
    }

    public List<Customer> getAllCustomers(){
        return this.customerList;
    }
    public Customer save(Customer customer){
        customerList.add(customer);
        return customer;
    }
    public Optional<Customer> findCustomerById(String id) {
        return customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }
    public Optional<Customer> validateEmailPassword(String email,String password){
        return this.customerList.stream().
                filter(customer->customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }
    public Customer updateCustomer(Customer updatedCustomer){
        Optional<Customer> optional=this.customerList.stream().
                filter(customer->customer.getCustomerId().equals(updatedCustomer.getCustomerId())).
                findFirst().map(customer->{
                    customer.setId(updatedCustomer.getCustomerId()).
                            setName(updatedCustomer.getName()).
                            setEmail(updatedCustomer.getEmail()).setPassword(updatedCustomer.getPassword());
                    return customer;
                });
        return optional.orElse(null);
    }
    public void deleteCustomer(Customer customer){
        this.customerList.remove(customer);
    }
}
