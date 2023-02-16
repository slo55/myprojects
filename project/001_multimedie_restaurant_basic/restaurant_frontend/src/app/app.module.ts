import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import {  HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { DeliveryLoginComponent } from './delivery-login/delivery-login.component';
import { RestaurantManagerLoginComponent } from './restaurant-manager-login/restaurant-manager-login.component';
import { DeliveryOrderListComponent } from './delivery-order-list/delivery-order-list.component';
import { RestaurantsListComponent } from './restaurants-list/restaurants-list.component';
import { RestaurantMainmenuComponent } from './restaurant-mainmenu/restaurant-mainmenu.component';
import { CustomerMainmenuComponent } from './customer-mainmenu/customer-mainmenu.component';
import { DeliveryMainmenuComponent } from './delivery-mainmenu/delivery-mainmenu.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { RestaurantRegisterComponent } from './restaurant-register/restaurant-register.component';
import { DeliveryRegisterComponent } from './delivery-register/delivery-register.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    NavbarComponent,
    DeliveryLoginComponent,
    RestaurantManagerLoginComponent,
    DeliveryOrderListComponent,
    RestaurantsListComponent,
    RestaurantMainmenuComponent,
    CustomerMainmenuComponent,
    DeliveryMainmenuComponent,
    CustomerRegisterComponent,
    RestaurantRegisterComponent,
    DeliveryRegisterComponent,
    LoginComponent,
    CustomerLoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
