import { TestBed } from '@angular/core/testing';

import { ServiceProvidedService } from './service-provided.service';

describe('ServiceProvidedService', () => {
  let service: ServiceProvidedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceProvidedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
