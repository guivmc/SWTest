import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdimComponent } from './adim.component';

describe('AdimComponent', () => {
  let component: AdimComponent;
  let fixture: ComponentFixture<AdimComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdimComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
