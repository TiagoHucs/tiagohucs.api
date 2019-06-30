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
  novaMusica: Musica;
  usuarios: any[];
  
  constructor(private musicaService: MusicaService) { }

  ngOnInit() {
    this.novaMusica = new Musica();
    console.log('vou buscar');
    this.musicaService.listar().subscribe(
      (response) => {
        this.musicas = response;
        console.log('listado com sucesso');
      }
    );
  }

  adiciona(){
    this.musicaService.salvar(this.novaMusica).subscribe(
      (response) => {
        this.novaMusica = new Musica();
        console.log('Salvo com sucesso');
        this.ngOnInit();
      }
    );
  }

  excluir(id: any){
    this.musicaService.excluir(id).subscribe(
      (response) => {
        this.novaMusica = new Musica();
        console.log('Excluido com sucesso');
        this.ngOnInit();
      }
    );
  }

}
