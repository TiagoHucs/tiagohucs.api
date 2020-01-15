import { TestBed } from '@angular/core/testing';

import { PublicacaoService } from './publicacao.service';

describe('PublicacaoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PublicacaoService = TestBed.get(PublicacaoService);
    expect(service).toBeTruthy();
  });
});
