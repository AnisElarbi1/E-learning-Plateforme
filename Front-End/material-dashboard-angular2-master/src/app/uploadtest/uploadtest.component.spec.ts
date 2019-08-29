import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadtestComponent } from './uploadtest.component';

describe('UploadtestComponent', () => {
  let component: UploadtestComponent;
  let fixture: ComponentFixture<UploadtestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadtestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadtestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
