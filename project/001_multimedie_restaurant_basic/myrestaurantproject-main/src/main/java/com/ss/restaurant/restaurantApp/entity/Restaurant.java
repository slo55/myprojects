package com.ss.restaurant.restaurantApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="restaurants")
public class Restaurant
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="image")
    private String image;

    @Column(name="number")
    private String number;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private Long type;


    public Restaurant()
    {

    }

    public Restaurant(String first_name, String last_name, String image, String name, String email, String password, Long type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.image = image;
        this.number = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", image='" + image + '\'' +
                ", name='" + number + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
