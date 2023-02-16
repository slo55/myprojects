import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantMainmenuComponent } from './restaurant-mainmenu.component';

describe('RestaurantMainmenuComponent', () => {
  let component: RestaurantMainmenuComponent;
  let fixture: ComponentFixture<RestaurantMainmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantMainmenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantMainmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
