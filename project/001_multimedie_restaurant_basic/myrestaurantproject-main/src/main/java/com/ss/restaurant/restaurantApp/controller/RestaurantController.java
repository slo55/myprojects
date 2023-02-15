package com.ss.restaurant.restaurantApp.controller;


import com.ss.restaurant.restaurantApp.entity.Restaurant;
import com.ss.restaurant.restaurantApp.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController
{
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/allRestaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurants()
    {
       return ResponseEntity.ok(this.restaurantService.getAllRestaurants());
    }


    @GetMapping("/getRestaurantsById/{id}")
    public ResponseEntity<Restaurant> getRestaurantById (@PathVariable(value = "id") Long id)
    {
        return ResponseEntity.ok(this.restaurantService.getRestaurantById(id));
    }


    @PostMapping("/createRestaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant)
    {
        return ResponseEntity.ok(this.restaurantService.createRestaurant(restaurant));
    }

    @PutMapping("/updateRestaurant")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant)
    {
        return ResponseEntity.ok(this.restaurantService.updateRestaurant(restaurant));
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity.BodyBuilder deleteRestaurant(@PathVariable(value = "id") Long id)
    {
        this.restaurantService.deleteRestaurant(id);

        return ResponseEntity.ok();
    }
















}
