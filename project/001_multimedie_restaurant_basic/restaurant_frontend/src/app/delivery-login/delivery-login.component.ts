import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Delivery } from '../delivery-register/delivery';

@Component({
  selector: 'app-delivery-login',
  templateUrl: './delivery-login.component.html',
  styleUrls: ['./delivery-login.component.css']
})
export class DeliveryLoginComponent implements OnInit 
{


  baseUrl : string ="http://localhost:8080/deliveries/allDeliveries";
  deliveries : Delivery[] = [];
  deliveryLoginForm! : FormGroup;
  deliveryIdLogin: any = 0;

  email :string = "";
  password : string = "";


  constructor(private http: HttpClient, private formBuilder:FormBuilder, private router : Router)
  {
    this.deliveryLoginForm = this.formBuilder.group({

      "password" : null,
      "email" : null,
    });
  }

  ngOnInit(): void {  
    this.http.get<Delivery[]>(this.baseUrl).subscribe(data => {
      this.deliveries = data;
    });

    
  }

  Login()
  {
    let isLogin : boolean = false;
    if (this.email.length > 5 && this.password.length > 4)
    {
      for (let i = 0; i < this.deliveries.length; i++)
      {
          if (this.deliveries[i].email === this.email && this.deliveries[i].password === this.password)
          {
              
              this.deliveryIdLogin = this.deliveries[i].id;
              localStorage.setItem("delivery202", JSON.stringify(this.deliveryIdLogin));

              alert("LOGIN is SUCCESFULLY! ✅", ); 
              window.location.href = "http://localhost:4200/restaurants-list";
              isLogin = true;
          }
      }

      if (isLogin == false)
      {
        confirm("LOGIN is NOT CORRECT!❗️❗️❗️"); 
      }
    } 
    else
    {

      confirm("LOGIN is NOT CORRECT!❗️❗️❗️"); 
    }
  }


}








