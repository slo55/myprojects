import { HttpClient, HttpContext } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from './restaurant';

@Component({
  selector: 'app-restaurant-register',
  templateUrl: './restaurant-register.component.html',
  styleUrls: ['./restaurant-register.component.css']
})
export class RestaurantRegisterComponent 
{

  postUrl : string = "http://localhost:8080/restaurants/createRestaurant";

  restaurantForm! : FormGroup;

  firstName : string= "";
  email : string= "";
  password : string= "";
  number : string = "";

  constructor(private http : HttpClient, private formBuilder : FormBuilder, private router : Router)
  {
    this.restaurantForm = this.formBuilder.group(
      {
        "first_name" : null,
        "last_name" : null,
        "password" : null,
        "email" : null,
        "image" : null,
        "number" : null,
        "type" : ['303']
      }
    );
  }


  RestaurantRegister()
  {
    if (this.firstName.length > 3 && 
        this.number.length > 3 && 
        this.email.length > 3 && 
        this.password.length > 3)
        {
          this.http.post<Restaurant>(this.postUrl, this.restaurantForm.value).subscribe(
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
