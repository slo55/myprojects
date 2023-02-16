import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit
{
  baseUrl : string ="http://localhost:8080/customers/allCustomers";
  customers : Customer[] = [];
  customerLoginForm! : FormGroup;
  customerIdLogin: any = 0;

  email :string = "";
  password : string = "";


  constructor(private http: HttpClient, private formBuilder:FormBuilder, private router : Router)
  {
    this.customerLoginForm = this.formBuilder.group({

      "password" : null,
      "email" : null,
    });
  }

  ngOnInit(): void {  
    this.http.get<Customer[]>(this.baseUrl).subscribe(data => {
      this.customers = data;
    });

    
  }

  Login()
  {
    let isLogin : boolean = false;

    if (this.email.length > 5 && this.password.length > 4)
    {
      for (let i = 0; i < this.customers.length; i++)
      {
          if (this.customers[i].email === this.email && this.customers[i].password === this.password)
          {
              
              this.customerIdLogin = this.customers[i].id;
              localStorage.setItem("customer101", JSON.stringify(this.customerIdLogin));

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
