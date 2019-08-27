import { TestBed } from '@angular/core/testing';

import { SwtestService } from './swtest.service';

describe('SwtestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SwtestService = TestBed.get(SwtestService);
    expect(service).toBeTruthy();
  });
});
