import { Component, OnInit } from '@angular/core';
import { MusicaService } from './musica.service';
import { Musica } from './musica';

@Component({
  selector: 'app-setlist',
  templateUrl: './setlist.component.html',
  styleUrls: ['./setlist.component.css']
})
export class SetlistComponent implements OnInit {
  musicas: string[];
  musica: Musica;
  novaMusica: string;
  usuarios: any[];
  
  constructor(private musicaService: MusicaService) { }

  ngOnInit() {
    console.log('vou buscar');
    this.musicaService.listar().subscribe(
      (response) => {
        this.musicas = response;
        console.log('listado com sucesso');
      }
    );
  }

  adiciona(){
    this.musica = new Musica();
    this.musica.nome = this.novaMusica;
    this.musica.link = this.novaMusica;

    this.musicaService.salvar(this.musica).subscribe(
      (response) => {
        this.novaMusica = '';
        console.log('Salvo com sucesso');
        this.ngOnInit();
      }
    );
  }

}
