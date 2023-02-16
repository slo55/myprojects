import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantManagerLoginComponent } from './restaurant-manager-login.component';

describe('RestaurantManagerLoginComponent', () => {
  let component: RestaurantManagerLoginComponent;
  let fixture: ComponentFixture<RestaurantManagerLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantManagerLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantManagerLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
