import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintReserveComponent } from './print-reserve.component';

describe('PrintReserveComponent', () => {
  let component: PrintReserveComponent;
  let fixture: ComponentFixture<PrintReserveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrintReserveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrintReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
