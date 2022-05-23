import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicIndexComponent } from './topic-index.component';

describe('TopicIndexComponent', () => {
  let component: TopicIndexComponent;
  let fixture: ComponentFixture<TopicIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopicIndexComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
