import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent {

  postUrl : string ="http://localhost:8080/customers/createCustomer";

  customerForm! : FormGroup;

  firstName : string= "";
  lastName : string= "";
  email : string= "";
  password : string= "";

  constructor(private http: HttpClient, private formBuilder:FormBuilder, private router: Router)
  {
      this.customerForm = this.formBuilder.group({
        "first_name" : null,
        "last_name" : null,
        "password" : null,
        "email" : null,
        "adress" : null,
        "number" : null,
        "type" : ['101']
      });
  }

  CustomerRegister() {
    
    if (this.firstName.length > 3 && 
        this.lastName.length > 3 && 
        this.email.length > 5 && 
        this.password.length > 3)
        {
          this.http.post<Customer>(this.postUrl, this.customerForm.value).subscribe(
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
