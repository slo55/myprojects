package com.ss.restaurant.restaurantApp.service;


import com.ss.restaurant.restaurantApp.entity.Customer;
import com.ss.restaurant.restaurantApp.repository.CustomerRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) throws ResourceNotFoundException {
        return this.customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer is not found! (id:" + customerId + ")")
        );
    }


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer updateCustomer(Customer customer)
            throws ResourceNotFoundException {
        Customer updateCustomer = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer is not found! id : " + customer.getId()));

        updateCustomer.setFirst_name(customer.getFirst_name());
        updateCustomer.setLast_name(customer.getLast_name());
        updateCustomer.setNumber(customer.getNumber());

        return customerRepository.save(updateCustomer);
    }


    public void deleteCustomer(Long customerId) throws ResourceNotFoundException {
        Customer deleteCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("the customer is not found! id " + customerId));

        customerRepository.delete(deleteCustomer);
    }


}
