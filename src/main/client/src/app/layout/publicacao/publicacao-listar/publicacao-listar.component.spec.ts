import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicacaoListarComponent } from './publicacao-listar.component';

describe('PublicacaoListarComponent', () => {
  let component: PublicacaoListarComponent;
  let fixture: ComponentFixture<PublicacaoListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicacaoListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicacaoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
