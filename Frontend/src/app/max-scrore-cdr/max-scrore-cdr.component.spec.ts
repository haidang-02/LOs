import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaxScroreCDRComponent } from './max-scrore-cdr.component';

describe('MaxScroreCDRComponent', () => {
  let component: MaxScroreCDRComponent;
  let fixture: ComponentFixture<MaxScroreCDRComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MaxScroreCDRComponent]
    });
    fixture = TestBed.createComponent(MaxScroreCDRComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
