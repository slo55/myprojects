import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer';
import { Delivery } from '../delivery-register/delivery';
import { Restaurant } from '../restaurant-register/restaurant';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit
{

  customerIdGet : string ="http://localhost:8080/customers/getCustomerById/";
  deliveryIdGet : string = "http://localhost:8080/deliveries/getDeliveryById/";
  restaurantIdGet : string = "http://localhost:8080/restaurants/getRestaurantsById/";

  login : boolean = localStorage.length == 0 ? true : false;
  logout : boolean = localStorage.length > 0 ? true: false;

  customer : Customer = {};
  customerId : any = localStorage.getItem("customer101");

  delivery : Delivery = {};
  deliveryId : any = localStorage.getItem("delivery202");

  restaurant : Restaurant = {};
  restaurantId : any = localStorage.getItem("restaurant303");
  
  first_name : any = "";


constructor(private router : Router, private http: HttpClient)
{
    if (localStorage.getItem("customer101") != null)
    {
      this.http.get<Customer>(this.customerIdGet + this.customerId).subscribe(data => {
        this.customer = data;
        this.first_name =  "Welcome " +data.first_name;
      });
    }

    if (localStorage.getItem("delivery202") != null)
    {
      this.http.get<Delivery>(this.deliveryIdGet + this.deliveryId).subscribe(data => {
        this.delivery = data;
        this.first_name =  "Welcome " +data.first_name;
      });
    }

    if (localStorage.getItem("restaurant303") != null)
    {
      this.http.get<Restaurant>(this.restaurantIdGet + this.restaurantId).subscribe(data => {
        this.delivery = data;
        this.first_name =  "Welcome " +data.first_name + " Restaurant";
      });
    }


}
  ngOnInit(): void {
    
  }

  CustomerMenu()
  {
     let key = localStorage.key(0);

     if (key == "customer101")
     {
      this.router.navigateByUrl('customer-mainmenu');
     }
     else
     {
      confirm("You are not authorized!!❗️❗️❗️"); 
     }
  }

  DeliveryMenu()
  {
    let key = localStorage.key(0);

    if (key == "delivery202")
    {
      this.router.navigateByUrl('delivery-mainmenu');
    }
    else
    {
     confirm("You are not authorized!!❗️❗️❗️"); 
    }

  }

  RestaurantManagerMenu()
  {
    let key = localStorage.key(0);

    if (key == "restaurant303")
    {
      this.router.navigateByUrl('restaurant-mainmenu');
    }
    else
    {
     confirm("You are not authorized!!❗️❗️❗️"); 
    }

  }

  Login()
  {
    if (localStorage.length == 0)
    {

      this.router.navigateByUrl('/login');
      console.log(localStorage);
      
    }
    else
    {
      window.location.href = "http://localhost:4200/restaurants-list";
    }
  
  }

  Logout()
  {
    localStorage.clear();
    window.location.href = "http://localhost:4200/restaurants-list";
  }





}