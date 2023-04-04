import { TestBed } from '@angular/core/testing';

import { RubriqueService } from './rubrique.service';

describe('RubriqueService', () => {
  let service: RubriqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RubriqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
