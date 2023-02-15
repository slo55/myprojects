package com.ss.restaurant.restaurantApp.service;

import com.ss.restaurant.restaurantApp.entity.Order;
import com.ss.restaurant.restaurantApp.repository.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService
{
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders()
    {
        return this.orderRepository.findAll();
    }

    public List<Order> getAllDeliveryToOrder(String status)
    {
        return this.orderRepository.findAll().stream()
                .filter( o -> Objects.equals(o.getStatus().toLowerCase(), status.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Order> getAllRestaurantToOrder(Long restaurantId)
    {
        return this.orderRepository.findAll().stream()
                .filter( o -> Objects.equals(o.getRestaurant_id(), restaurantId))
                .collect(Collectors.toList());
    }

    public List<Order> getOrderByCustomerId(Long customerId)
    {

        return this.orderRepository.findAll().stream()
                .filter(c -> Objects.equals(c.getCustomer_id(), customerId))
                .collect(Collectors.toList());
    }

    public List<Order> getOrderByRestaurantId(Long restaurantId)
    {
        return this.orderRepository.findAll().stream()
            .filter(c -> Objects.equals(c.getRestaurant_id(), restaurantId))
            .collect(Collectors.toList());
    }

    public List<Order> getOrderByDeliveryId(Long deliveryId)
    {
        return this.orderRepository.findAll().stream()
                .filter(c -> Objects.equals(c.getDelivery_id(), deliveryId))
                .collect(Collectors.toList());
    }

    public Order createOrder(Order order)
    {
        return this.orderRepository.save(order);
    }

    public Order updateOrder(Order order) throws ResourceNotFoundException
    {
        Order updatedOrder = this.orderRepository.findById(order.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Order is not found! " + order.getId())
        );

        updatedOrder.setId(order.getId());
        updatedOrder.setNumber(order.getNumber());
        updatedOrder.setFirst_name(order.getFirst_name());
        updatedOrder.setLast_name(order.getLast_name());
        updatedOrder.setDescription(order.getDescription());
        updatedOrder.setStatus(order.getStatus());
        updatedOrder.setCustomer_id(order.getCustomer_id());
        updatedOrder.setDelivery_id(order.getDelivery_id());
        updatedOrder.setRestaurant_id(order.getRestaurant_id());

        return this.orderRepository.save(updatedOrder);
    }

    public void deleteOrder(Long id) throws ResourceNotFoundException
    {
        Order deletedOrder = this.orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Deleted order is not found! : " + id)
        );

        this.orderRepository.delete(deletedOrder);
    }


















}
