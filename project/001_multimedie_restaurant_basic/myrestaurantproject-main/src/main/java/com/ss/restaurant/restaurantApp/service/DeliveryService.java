package com.ss.restaurant.restaurantApp.service;


import com.ss.restaurant.restaurantApp.entity.Delivery;
import com.ss.restaurant.restaurantApp.repository.DeliveryRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService
{
    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository)
    {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries ()
    {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(Long id) throws ResourceNotFoundException
    {
        return deliveryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Delivery is not found : " + id));
    }


    public Delivery createDelivery(Delivery delivery)
    {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(Delivery delivery) throws ResourceNotFoundException
    {
        Delivery updatedDelivery = deliveryRepository.findById(delivery.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Delivery update is not found : " + delivery.getId())
        );

        updatedDelivery.setEmail(delivery.getEmail());
        updatedDelivery.setNumber(delivery.getNumber());
        updatedDelivery.setFirst_name(delivery.getFirst_name());
        updatedDelivery.setLast_name(delivery.getLast_name());

        return deliveryRepository.save(updatedDelivery);
    }

    public void deleteDelivery(Long id) throws ResourceNotFoundException
    {
        Delivery deletedDelivery = deliveryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Delivery deleted is not found : " + id)
        );

        deliveryRepository.delete(deletedDelivery);
    }










}
