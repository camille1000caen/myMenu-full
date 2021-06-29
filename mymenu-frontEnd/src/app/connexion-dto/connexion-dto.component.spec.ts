import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnexionDTOComponent } from './connexion-dto.component';

describe('ConnexionDTOComponent', () => {
  let component: ConnexionDTOComponent;
  let fixture: ComponentFixture<ConnexionDTOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnexionDTOComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnexionDTOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
