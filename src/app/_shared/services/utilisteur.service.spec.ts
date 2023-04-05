import { TestBed } from '@angular/core/testing';

import { UtilisteurService } from './utilisteur.service';

describe('UtilisteurService', () => {
  let service: UtilisteurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtilisteurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
