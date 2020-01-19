import { Component, OnInit, OnDestroy } from '@angular/core';
import { PublicacaoService } from '../publicacao.service';
import { Publicacao } from '../publicacao';
import { Subscription } from 'rxjs';
import { resolve } from 'url';

@Component({
  selector: 'app-publicacao-listar',
  templateUrl: './publicacao-listar.component.html',
  styleUrls: ['./publicacao-listar.component.css']
})
export class PublicacaoListarComponent implements OnInit, OnDestroy {
  publicacoes: Publicacao[] = [];
  subscription: Subscription;

  constructor(private service: PublicacaoService) {
    // subscribe to home component messages
    this.subscription = this.service.getMessage().subscribe(resolve => {
      this.listar();
    });
  }

  ngOnInit() {
    this.listar();
  }

  ngOnDestroy() {
    // unsubscribe to ensure no memory leaks
    this.subscription.unsubscribe();
  }

  listar() {
    this.service.listar().subscribe(
      response => {
        this.publicacoes = response;
        console.log(this.publicacoes)
      }
    )
  }
}
