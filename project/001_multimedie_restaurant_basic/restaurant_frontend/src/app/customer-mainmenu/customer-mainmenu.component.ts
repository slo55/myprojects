import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer';
import { Order } from '../restaurants-list/Order';

@Component({
  selector: 'app-customer-mainmenu',
  templateUrl: './customer-mainmenu.component.html',
  styleUrls: ['./customer-mainmenu.component.css']
})
export class CustomerMainmenuComponent implements OnInit
{
  orderUrl : string = "http://localhost:8080/orders/getOrderByCustomerId/";
  customerUrl : string = "http://localhost:8080/customers/getCustomerById/";
  updateCustomerUrl : string = "http://localhost:8080/customers/updateCustomer";
  deleteOrderUrl : string = "http://localhost:8080/orders/deleteOrder/";

  orders : Order[] = [];

  customerId : any = localStorage.getItem("customer101");
  
  customer : Customer = {};

  customerUpdateForm! : FormGroup;

  first_name :any = "";
  last_name : any = "";
  number : any = "";
  adress : any = "";

  constructor(private http: HttpClient, private formBuilder : FormBuilder, private router : Router)
  {
    this.http.get<Order[]>(this.orderUrl + this.customerId).subscribe(data => {
      this.orders = data;
    });

   this.http.get<Customer>(this.customerUrl + this.customerId).subscribe(data => {
      this.customer = data;
      this.first_name = data.first_name;
      this.last_name = data.last_name;
      this.number = data.number;
      this.adress = data.adress;
    });

    this.customerUpdateForm = this.formBuilder.group({
      "id" : this.customerId,
      "first_name" : this.first_name,
      "last_name" : this.last_name,
      "number" : this.number,
      "adress" : this.adress
    });

  }

  ngOnInit(): void 
  {
  
  }

  updateCustomer()
  {
    this.http.put<Customer>(this.updateCustomerUrl, this.customerUpdateForm.value).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );

    alert("Customer is updated!");
  }


  Delete(id:any)
  {
    this.http.delete<Order>(this.deleteOrderUrl + id).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
    alert("Order is deleted!");
    window.location.href = "http://localhost:4200/customer-mainmenu";
  }
}
