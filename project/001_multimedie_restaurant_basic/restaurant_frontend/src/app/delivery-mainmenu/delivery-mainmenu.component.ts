import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Delivery } from '../delivery-register/delivery';
import { Order } from '../restaurants-list/Order';

@Component({
  selector: 'app-delivery-mainmenu',
  templateUrl: './delivery-mainmenu.component.html',
  styleUrls: ['./delivery-mainmenu.component.css']
})
export class DeliveryMainmenuComponent implements OnInit {
  
  getAllDeliveryToWaitUrl : string = "http://localhost:8080/orders/allDeliveryToOrder/On the way";
  getDeliveryUrl : string = "http://localhost:8080/deliveries/getDeliveryById/";
  updateDeliveryUrl : string = "http://localhost:8080/deliveries/updateDelivery";

  delivery : Delivery = {};
  
  deliveryForm! : FormGroup;

  first_name : any = this.delivery.first_name;
  last_name : any = this.delivery.last_name;
  number : any = this.delivery.number;

  deliveryId : any = localStorage.getItem("delivery202");

  orderToDeliveries : Order[] = [];
  
  constructor(private http : HttpClient, private route : Router, private formBuilder : FormBuilder)
  {

    this.http.get<Delivery>(this.getDeliveryUrl + this.deliveryId).subscribe(data => {
      this.delivery = data;
      this.first_name = data.first_name;
      this.last_name = data.last_name;
      this.number = data.number;
      
    });

    this.http.get<Order[]>(this.getAllDeliveryToWaitUrl).subscribe(data => {
      this.orderToDeliveries = data;
    });

    this.deliveryForm = formBuilder.group(
      {
        "id" : this.deliveryId,        
        "first_name" : this.delivery.first_name,
        "last_name" : this.delivery.last_name,
        "number" : this.delivery.number,
        "password" : this.delivery.password,
        "email" : this.delivery.email,
      }
    );





  }
  
  
  UpdateDelivery()
  {
    this.http.put<Delivery>(this.updateDeliveryUrl, this.deliveryForm.value).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

    alert("Customer is updated!");
  }
  
  
  
  
  ngOnInit(): void 
  {
    
  }

}
