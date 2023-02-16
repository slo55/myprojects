import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerMainmenuComponent } from './customer-mainmenu.component';

describe('CustomerMainmenuComponent', () => {
  let component: CustomerMainmenuComponent;
  let fixture: ComponentFixture<CustomerMainmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerMainmenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerMainmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
