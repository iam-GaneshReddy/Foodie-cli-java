package com.trainingMug.foodiecli.repository;

import com.trainingMug.foodiecli.model.Customer;
import com.trainingMug.foodiecli.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customerList;

    public CustomerRepository(){
        CsvReader csvReader=new CsvReader();
        this.customerList = csvReader.readCustomersFromCSV();
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
}
