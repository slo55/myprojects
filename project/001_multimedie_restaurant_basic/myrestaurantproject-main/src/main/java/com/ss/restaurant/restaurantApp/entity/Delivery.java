package com.ss.restaurant.restaurantApp.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="deliveries")
public class Delivery
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="password")
    private String password;

    @Column(name="number")
    private String number;

    @Column(name="email")
    private String email;

    @Column(name="type")
    private Long type;

    public Delivery()
    {

    }

    public Delivery(String first_name, String last_name, String password, String number, String email, Long type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.number = number;
        this.email = email;
        this.type = type;
    }







    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }


}
