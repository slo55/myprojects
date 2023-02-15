package com.ss.restaurant.restaurantApp.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="last_name", nullable = false)
    private String last_name;

    @Column(name="number", nullable = false)
    private String number;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private String status;

    @Column(name="restaurant_id")
    private Long restaurant_id;

    @Column(name="delivery_id")
    private Long delivery_id;

    @Column(name="customer_id")
    private Long customer_id;

    @Column(name="adress")
    private String adress;

    public Order()
    {

    }

    public Order(String first_name, String last_name, String number, String description, String status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.number = number;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number='" + number + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", restaurant_id=" + restaurant_id +
                ", delivery_id=" + delivery_id +
                ", customer_id=" + customer_id +
                '}';
    }
}
