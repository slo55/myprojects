import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Customer } from './customer';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit
{
  baseUrl : string ="http://localhost:8080/customers/allCustomers";
  postUrl : string ="http://localhost:8080/customers/createCustomer";

  customers : Customer[] = [];
  form! : FormGroup;

  constructor(private http: HttpClient, private formBuilder: FormBuilder)
  {
    this.form = this.formBuilder.group({
      "first_name" : [''],
      "last_name" :[''],
      "number" : [''],
      "adress" : ['']
    });
  }
  
  submit() {
    this.http.post<Customer>(this.postUrl, this.form.value).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }
  
  ngOnInit(): void 
  {
      this.http.get<Customer[]>(this.baseUrl).subscribe(data => {
        this.customers = data;
      });
  }
  
  




}
