import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Restaurant } from '../restaurant-register/restaurant';

@Component({
  selector: 'app-restaurant-manager-login',
  templateUrl: './restaurant-manager-login.component.html',
  styleUrls: ['./restaurant-manager-login.component.css']
})
export class RestaurantManagerLoginComponent implements OnInit
{
  baseUrl : string ="http://localhost:8080/restaurants/allRestaurants";
  restaurants : Restaurant[] = [];
  restaurantLoginForm! : FormGroup;
  restaurantIdLogin: any = 0;

  email :string = "";
  password : string = "";

  constructor(private http : HttpClient, private formBuilder : FormBuilder, private router : Router)
  {
      this.restaurantLoginForm = this.formBuilder.group({
        "email" : null,
        "password" : null
      });
  }
  
  
  ngOnInit(): void 
  {
    this.http.get<Restaurant[]>(this.baseUrl).subscribe(data => {
      this.restaurants = data;
    });
  }


  Login()
  {
    if (this.email.length > 5 && this.password.length > 4)
    {

      let isLogin : boolean = false;

      for (let i = 0; i < this.restaurants.length; i++)
      {
          if (this.restaurants[i].email === this.email && this.restaurants[i].password === this.password)
          {
              
              this.restaurantIdLogin = this.restaurants[i].id;
              localStorage.setItem("restaurant303", JSON.stringify(this.restaurantIdLogin));

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
