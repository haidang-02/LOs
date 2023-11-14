import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPointComponent } from './show-point.component';

describe('ShowPointComponent', () => {
  let component: ShowPointComponent;
  let fixture: ComponentFixture<ShowPointComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowPointComponent]
    });
    fixture = TestBed.createComponent(ShowPointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
