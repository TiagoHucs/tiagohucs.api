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
  musicas: string[] = ["Winds of change", "Fast car", "Mr Brightside"];
  novaMusica: string;
  usuarios: any[];
  
  constructor(private http: HttpClient) { }

  ngOnInit() {
    console.log('vou buscar');
    this.buscar().subscribe(
      (response) => {
        this.usuarios = response;
        console.log('recebi');
      }
    );

  }

  adiciona(){
    this.musicas.push(this.novaMusica );
    this.novaMusica = '';
  }

  public buscar(): Observable<any> {
    return this.http.get<any[]>(`https://jsonplaceholder.typicode.com/todos/`);
  }

}
