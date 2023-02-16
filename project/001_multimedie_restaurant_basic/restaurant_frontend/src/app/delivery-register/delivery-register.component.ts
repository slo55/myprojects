import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Delivery } from './delivery';

@Component({
  selector: 'app-delivery-register',
  templateUrl: './delivery-register.component.html',
  styleUrls: ['./delivery-register.component.css']
})
export class DeliveryRegisterComponent 
{
  postUrl = "http://localhost:8080/deliveries/createDelivery";

  deliveryForm! :  FormGroup;

  firstName : string= "";
  lastName : string= "";
  email : string= "";
  password : string= "";
  number : string = "";

  constructor(private http: HttpClient, private formBuilder : FormBuilder, private router : Router)
  {
      this.deliveryForm = this.formBuilder.group(
        {
          "first_name" : null,
          "last_name" : null,
          "password" : null,
          "email" : null,
          "number" : null,
          "type" : ['202']
        }
      );
  }


  DeliveryRegister()
  {
    if (this.firstName.length > 3 && 
      this.lastName.length > 3 && 
      this.email.length > 5 && 
      this.password.length > 3)
      {
        this.http.post<Delivery>(this.postUrl, this.deliveryForm.value).subscribe(
          (res) => console.log(res),
          (err) => console.log(err)
        );
        alert("✅Registration is OKEY! ✅", ); 
        window.location.href = "http://localhost:4200/restaurants-list";
        
      } 
      else
      {
        confirm("❗️❗️❗️Registration is NOT CORRECT!❗️❗️❗️"); 
      }
  }







}
