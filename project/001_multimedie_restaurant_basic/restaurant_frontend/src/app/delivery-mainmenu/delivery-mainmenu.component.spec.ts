import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryMainmenuComponent } from './delivery-mainmenu.component';

describe('DeliveryMainmenuComponent', () => {
  let component: DeliveryMainmenuComponent;
  let fixture: ComponentFixture<DeliveryMainmenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeliveryMainmenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeliveryMainmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
