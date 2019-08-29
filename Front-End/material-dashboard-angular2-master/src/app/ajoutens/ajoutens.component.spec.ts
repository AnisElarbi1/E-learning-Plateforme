import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutensComponent } from './ajoutens.component';

describe('AjoutensComponent', () => {
  let component: AjoutensComponent;
  let fixture: ComponentFixture<AjoutensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjoutensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
