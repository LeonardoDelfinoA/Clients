import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceProvidedListComponent } from './service-provided-list.component';

describe('ServiceProvidedListComponent', () => {
  let component: ServiceProvidedListComponent;
  let fixture: ComponentFixture<ServiceProvidedListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ServiceProvidedListComponent]
    });
    fixture = TestBed.createComponent(ServiceProvidedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
