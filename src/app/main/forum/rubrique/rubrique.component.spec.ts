import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RubriqueComponent } from './rubrique.component';

describe('RubriqueIndexComponent', () => {
  let component: RubriqueComponent;
  let fixture: ComponentFixture<RubriqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RubriqueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RubriqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
