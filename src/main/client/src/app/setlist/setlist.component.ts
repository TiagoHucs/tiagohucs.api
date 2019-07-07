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
  loading: boolean;
  
  constructor(private musicaService: MusicaService) { }

  ngOnInit() {
    this.loading = true;
    this.novaMusica = new Musica();
    this.musicaService.listar().subscribe(
      (response) => {
        this.musicas = response;
        this.loading = false;
      }
    );
  }

  adiciona(){
    if(this.novaMusica.link == null || this.novaMusica.link == undefined || this.novaMusica.link == ''){
      this.novaMusica.link = 'https://www.cifraclub.com.br/?q='+this.novaMusica.nome;
    }
    this.musicaService.salvar(this.novaMusica).subscribe(
      (response) => {
        this.novaMusica = new Musica();
        console.log('Salvo com sucesso');
        this.ngOnInit();
      }
    );
  }

  editar(musica: Musica){
    this.novaMusica = musica;
  }

  newMusica(){
    this.novaMusica = new Musica();
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
