import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CustomerMainmenuComponent } from './customer-mainmenu/customer-mainmenu.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { DeliveryLoginComponent } from './delivery-login/delivery-login.component';
import { DeliveryMainmenuComponent } from './delivery-mainmenu/delivery-mainmenu.component';
import { DeliveryOrderListComponent } from './delivery-order-list/delivery-order-list.component';
import { DeliveryRegisterComponent } from './delivery-register/delivery-register.component';
import { RestaurantMainmenuComponent } from './restaurant-mainmenu/restaurant-mainmenu.component';
import { RestaurantManagerLoginComponent } from './restaurant-manager-login/restaurant-manager-login.component';
import { RestaurantRegisterComponent } from './restaurant-register/restaurant-register.component';
import { RestaurantsListComponent } from './restaurants-list/restaurants-list.component';
import { LoginComponent } from './login/login.component';
import { CustomerLoginComponent } from './customer-login/customer-login.component';

const routes : Routes = 
[
  { path : '', redirectTo : 'restaurants-list', pathMatch:'full' },
  { path : 'login', component: LoginComponent },
  { path : 'customer-mainmenu', component: CustomerMainmenuComponent},
  { path : 'customer-register', component: CustomerRegisterComponent},
  { path : 'customer-login' , component: CustomerLoginComponent},
  { path : 'delivery-login', component: DeliveryLoginComponent},
  { path : 'delivery-mainmenu', component : DeliveryMainmenuComponent},
  { path : 'delivery-order-list', component:DeliveryOrderListComponent},
  { path : 'delivery-register', component : DeliveryRegisterComponent},
  { path : 'restaurant-mainmenu', component : RestaurantMainmenuComponent},
  { path : 'restaurant-manager-login', component : RestaurantManagerLoginComponent},
  { path : 'restaurant-register', component : RestaurantRegisterComponent},
  { path : 'restaurants-list', component : RestaurantsListComponent},
  { path : 'restaurant-mainmenu/:id', component : RestaurantMainmenuComponent}
];

@NgModule({
  imports : [RouterModule.forRoot(routes)],
  exports : [RouterModule]
})
export class AppRoutingModule { }
