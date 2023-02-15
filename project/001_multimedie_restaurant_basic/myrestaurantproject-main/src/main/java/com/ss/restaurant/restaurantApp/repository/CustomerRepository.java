package com.ss.restaurant.restaurantApp.repository;


import com.ss.restaurant.restaurantApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{


}
