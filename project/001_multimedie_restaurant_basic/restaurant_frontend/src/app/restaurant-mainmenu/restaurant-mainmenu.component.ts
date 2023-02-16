import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Restaurant } from '../restaurant-register/restaurant';
import { Order } from '../restaurants-list/Order';

@Component({
  selector: 'app-restaurant-mainmenu',
  templateUrl: './restaurant-mainmenu.component.html',
  styleUrls: ['./restaurant-mainmenu.component.css']
})
export class RestaurantMainmenuComponent implements OnInit{
  
  restaurantGetUrl : string = "http://localhost:8080/restaurants/getRestaurantsById/";
  updateRestaurantUrl : string = "http://localhost:8080/restaurants/updateRestaurant";

  getRestaurantToOrder : string = "http://localhost:8080/orders/getOrderByRestaurantId/";

  resturantId : any = localStorage.getItem("restaurant303");

  restaurant : Restaurant = {};
  orders : Order[] = [];

  restaurantUpdateForm! : FormGroup;

  first_name :any;
  last_name :any;
  number : any;
  password : any;
  email : any;
  image : any;

  constructor(private http : HttpClient, private formBuilder : FormBuilder)
  {
    this.http.get<Order[]>(this.getRestaurantToOrder + this.resturantId).subscribe(data => {
      this.orders = data;
    });


    this.restaurantUpdateForm = this.formBuilder.group({
      "id" : this.resturantId,
      "first_name" : this.restaurant.first_name,
      "number" : this.restaurant.number,
      "password" : this.restaurant.password,
      "last_name" : this.restaurant.last_name,
      "image" : this.restaurant.image,
      "email" : this.restaurant.email,
      "type" : this.restaurant.type
    });



    this.http.get<Restaurant>(this.restaurantGetUrl + this.resturantId).subscribe(data => {
      this.restaurant = data;
      this.first_name = data.first_name;
      this.last_name = data.last_name;
      this.number = data.number;
      this.password = data.password;
      this.email = data.email;
      this.image = data.image;
      console.log(this.restaurant);
    });

  }
  
  
  
  ngOnInit(): void 
  {
  }


  updateRestaurant()
  {
    this.http.put<Restaurant>(this.updateRestaurantUrl, this.restaurantUpdateForm.value).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

    alert("Customer is updated!");
  }
}
