import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicacaoCriarComponent } from './publicacao-criar.component';

describe('PublicacaoCriarComponent', () => {
  let component: PublicacaoCriarComponent;
  let fixture: ComponentFixture<PublicacaoCriarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicacaoCriarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicacaoCriarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
