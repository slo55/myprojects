package com.ss.restaurant.restaurantApp.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="customers")
public class Customer
{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="number")
    private String number;

    @Column(name="adress")
    private String adress;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private Long type;

    public Customer()
    {

    }

    public Customer(String first_name, String last_name, String number, String adress, String email, String password, Long type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.number = number;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", number='" + number + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
