import { Component, OnInit } from '@angular/core';
import { PublicacaoService } from '../publicacao.service';
import { Publicacao } from '../publicacao';

@Component({
  selector: 'app-publicacao-listar',
  templateUrl: './publicacao-listar.component.html',
  styleUrls: ['./publicacao-listar.component.css']
})
export class PublicacaoListarComponent implements OnInit {
  publicacoes: Publicacao[] = [];

  constructor(
    private service: PublicacaoService) {
      
    }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.service.listar().subscribe(
      response => {
        this.publicacoes = response;
        console.log(this.publicacoes)
      }
    )
  }
}
