import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ɵgetUnknownPropertyStrictMode } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer';
import { Restaurant } from '../restaurant-register/restaurant';
import { Order } from './Order';

@Component({
  selector: 'app-restaurants-list',
  templateUrl: './restaurants-list.component.html',
  styleUrls: ['./restaurants-list.component.css']
})
export class RestaurantsListComponent implements OnInit
{
  public restaurants : Restaurant[] = []; 

  getAllRestaurantUrl : string ="http://localhost:8080/restaurants/allRestaurants";
  postUrl : string ="http://localhost:8080/orders/createOrder";

  customerUrl : string = "http://localhost:8080/customers/getCustomerById/";
  customer : Customer = {};
  customerAdress : any;
  customerId : any = localStorage.getItem("customer101");

  formOrder! : FormGroup;

  constructor(private http: HttpClient, private router : Router, private formBuilder : FormBuilder)
  {
    this.http.get<Restaurant[]>(this.getAllRestaurantUrl).subscribe(data => {
      this.restaurants = data;
    });
    
    this.http.get<Customer>(this.customerUrl + this.customerId).subscribe(data => {
      this.customer = data;
      this.customerAdress = data.adress;
      console.log(this.customerAdress);
    });

  }

  ngOnInit(): void 
  {

  }
  public McRonaldsMenu : Array<string> = [
    '	Substantial Mac €6.35',
    '	Royal Cheese €7.10',
    '	Rooster McNuggets €6.85',
    '	Filet-o-Ghoti €6.35',
    '	0.25th Pounder €6.35'
  ];


Order(restaurant_id : any)
{
  let key = localStorage.key(0);

  if (key == "delivery202" || key == "restaurant303")
  {
    alert("please login as customer 🤓"); 
  }
  else
  {
    
    let first_name = prompt("What is your name?");
    let last_name = prompt("What is last name?");
    let number = prompt("What is your phone number?");
    let description = prompt("What is your order?");
    let status = "On the way";
    let customer_id = localStorage.getItem("customer101");


    this.formOrder = this.formBuilder.group({
      "first_name" : first_name,
      "last_name" : last_name,
      "number" : number,
      "description" : description,
      "status" : status,
      "customer_id" : customer_id,
      "restaurant_id" : restaurant_id,
      "adress" : this.customerAdress
    });

    this.http.post<Order>(this.postUrl, this.formOrder.value).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

    alert("order is on the way...");

  }
}




}
