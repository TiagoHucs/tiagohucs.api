import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-setlist',
  templateUrl: './setlist.component.html',
  styleUrls: ['./setlist.component.css']
})
export class SetlistComponent implements OnInit {
  musicas: string[];
  novaMusica: string;
  usuarios: any[];
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
    console.log('vou buscar');
    this.buscar().subscribe(
      (response) => {
        this.musicas = response;
        console.log('recebi');
      }
    );

  }

  adiciona(){
    this.musicas.push(this.novaMusica );
    this.novaMusica = '';
  }

  public buscar(): Observable<any> {
    return this.http.get<any[]>(`musicas`);
  }

}
