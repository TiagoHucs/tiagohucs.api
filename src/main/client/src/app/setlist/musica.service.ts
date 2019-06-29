import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

  URL_API_LOCAL: String = 'http://localhost:8080/';
  URL_API_PROD: String = ''; 

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${this.URL_API_PROD}musicas/list`);
  }

  public salvar(musica: any): Observable<any> {
    return this.http.post(`${this.URL_API_PROD}musicas/save`,musica);
  }
}
