import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PublicacaoService } from '../publicacao.service';

@Component({
  selector: 'app-publicacao-listar',
  templateUrl: './publicacao-listar.component.html',
  styleUrls: ['./publicacao-listar.component.css']
})
export class PublicacaoListarComponent implements OnInit {

  publicacoes: string[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private service: PublicacaoService) { }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.service.listar().subscribe(
      response => {
        this.publicacoes = response;
        console.log('listou')
      }
    )
  }

}
