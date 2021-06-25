import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferenceAlimentaireComponent } from './preference-alimentaire.component';

describe('PreferenceAlimentaireComponent', () => {
  let component: PreferenceAlimentaireComponent;
  let fixture: ComponentFixture<PreferenceAlimentaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreferenceAlimentaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreferenceAlimentaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
