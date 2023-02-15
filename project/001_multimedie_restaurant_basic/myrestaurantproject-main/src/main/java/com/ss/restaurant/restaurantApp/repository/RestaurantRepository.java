package com.ss.restaurant.restaurantApp.repository;

import com.ss.restaurant.restaurantApp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>
{

}
