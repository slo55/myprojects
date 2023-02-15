package com.ss.restaurant.restaurantApp.controller;


import com.ss.restaurant.restaurantApp.entity.Order;
import com.ss.restaurant.restaurantApp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController
{

    private final OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders()
    {
        return ResponseEntity.ok(this.orderService.getAllOrders());
    }


    @GetMapping("/allDeliveryToOrder/{status}")
    public ResponseEntity<List<Order>> getAllDeliveryToOrder(@PathVariable(value = "status") String status)
    {
        return ResponseEntity.ok(this.orderService.getAllDeliveryToOrder(status));
    }
    @GetMapping("/getOrderByCustomerId/{id}")
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable(value = "id") Long customerId)
    {
        return ResponseEntity.ok(this.orderService.getOrderByCustomerId(customerId));
    }

    @GetMapping("/getOrderByRestaurantId/{id}")
    public ResponseEntity<List<Order>> getAllRestaurantToOrder(@PathVariable(value = "id") Long restaurantId)
    {
        return ResponseEntity.ok(this.orderService.getAllRestaurantToOrder(restaurantId));
    }

    @GetMapping("/getOrderByRestaurantId/{id}")
    public ResponseEntity<List<Order>> getOrderByRestaurantId(@PathVariable(value = "id") Long restaurantId)
    {
        return ResponseEntity.ok(this.orderService.getOrderByRestaurantId(restaurantId));
    }

    @GetMapping("/getOrderByDeliveryId/{id}")
    public ResponseEntity<List<Order>> getOrderByDeliveryId(@PathVariable(value = "id") Long deliveryId)
    {
        return ResponseEntity.ok(this.orderService.getOrderByDeliveryId(deliveryId));
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        return ResponseEntity.ok(this.orderService.createOrder(order));
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order)
    {
        return ResponseEntity.ok(this.orderService.updateOrder(order));
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity.BodyBuilder deleteOrder(@PathVariable(value = "id") Long id)
    {
        this.orderService.deleteOrder(id);

        return ResponseEntity.ok();
    }























}
