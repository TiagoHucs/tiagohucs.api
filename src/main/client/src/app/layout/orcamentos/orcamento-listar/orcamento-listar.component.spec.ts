import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrcamentoListarComponent } from './orcamento-listar.component';

describe('OrcamentoListarComponent', () => {
  let component: OrcamentoListarComponent;
  let fixture: ComponentFixture<OrcamentoListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrcamentoListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrcamentoListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
