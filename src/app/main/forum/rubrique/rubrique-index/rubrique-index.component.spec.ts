import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RubriqueIndexComponent } from './rubrique-index.component';

describe('RubriqueIndexComponent', () => {
  let component: RubriqueIndexComponent;
  let fixture: ComponentFixture<RubriqueIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RubriqueIndexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RubriqueIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
