package com.ss.restaurant.restaurantApp.controller;


import com.ss.restaurant.restaurantApp.entity.Customer;
import com.ss.restaurant.restaurantApp.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController
{

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers ()
    {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id") Long customerId)
    {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }


    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
    {
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }


    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity.BodyBuilder deleteCustomer(@PathVariable(value="id") Long customerId)
    {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok();
    }
}


















