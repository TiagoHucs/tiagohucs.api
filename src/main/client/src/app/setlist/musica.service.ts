import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

  URL_API_LOCAL: String = 'http://localhost:5000/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
     //return this.http.get<any[]>(`${this.URL_API_LOCAL}musicas/list`);
     return this.http.get<any[]>(`musicas/list`);
  }

  public salvar(musica: any): Observable<any> {
    //return this.http.post(`${this.URL_API_LOCAL}musicas/save`,musica);
    return this.http.post(`musicas/save`,musica);
  }

  public excluir(id: any): Observable<any> {
    //return this.http.delete(`${this.URL_API_LOCAL}musicas/delete/${id}`);
    return this.http.delete(`musicas/delete/${id}`);
  }
}
