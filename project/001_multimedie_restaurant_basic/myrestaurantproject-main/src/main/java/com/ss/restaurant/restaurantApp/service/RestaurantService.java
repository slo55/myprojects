package com.ss.restaurant.restaurantApp.service;


import com.ss.restaurant.restaurantApp.entity.Restaurant;
import com.ss.restaurant.restaurantApp.repository.RestaurantRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService
{

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants()
    {
        return this.restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) throws ResourceNotFoundException
    {
        return this.restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Restaurant is not found ! " + id)
        );
    }


    public Restaurant createRestaurant(Restaurant restaurant)
    {
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws ResourceNotFoundException
    {
        Restaurant updatedRestaurant = this.restaurantRepository.findById(restaurant.getId()).orElseThrow(
                () -> new ResourceNotFoundException("updatade Restaurant is not found! " + restaurant.getId())
        );

        updatedRestaurant.setFirst_name(restaurant.getFirst_name());
        updatedRestaurant.setLast_name(restaurant.getLast_name());
        updatedRestaurant.setImage(restaurant.getImage());
        updatedRestaurant.setNumber(restaurant.getNumber());
        updatedRestaurant.setEmail(restaurant.getEmail());
        updatedRestaurant.setPassword(restaurant.getPassword());

        return this.restaurantRepository.save(updatedRestaurant);
    }

    public void deleteRestaurant(Long id) throws ResourceNotFoundException
    {
        Restaurant restaurant = this.restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("deleted restaurant is not found! " + id)
        );

        this.restaurantRepository.delete(restaurant);
    }


}
