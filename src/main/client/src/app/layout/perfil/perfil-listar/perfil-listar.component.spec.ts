import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilListarComponent } from './perfil-listar.component';

describe('PerfilListarComponent', () => {
  let component: PerfilListarComponent;
  let fixture: ComponentFixture<PerfilListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerfilListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
