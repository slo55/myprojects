package com.ss.restaurant.restaurantApp.controller;

import com.ss.restaurant.restaurantApp.entity.Delivery;
import com.ss.restaurant.restaurantApp.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/deliveries")
public class DeliveryController
{

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService)
    {
        this.deliveryService = deliveryService;
    }


    @GetMapping("/allDeliveries")
    public ResponseEntity<List<Delivery>> getAllDeliveries()
    {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @GetMapping("/getDeliveryById/{id}")
    public ResponseEntity<Delivery> getDeliveryById (@PathVariable(value="id") Long id)
    {
        return ResponseEntity.ok(deliveryService.getDeliveryById(id));
    }

    @PostMapping("/createDelivery")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery)
    {
        return ResponseEntity.ok(deliveryService.createDelivery(delivery));
    }

    @PutMapping("/updateDelivery")
    public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delivery)
    {
        return ResponseEntity.ok(deliveryService.updateDelivery(delivery));
    }

    @DeleteMapping("/deleteDelivery/{id}")
    public ResponseEntity.BodyBuilder deleteDelivery(@PathVariable(value = "id") Long id)
    {
        deliveryService.deleteDelivery(id);

        return ResponseEntity.ok();
    }


















}
