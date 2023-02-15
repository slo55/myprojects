package com.ss.restaurant.restaurantApp.repository;

import com.ss.restaurant.restaurantApp.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>
{


}
