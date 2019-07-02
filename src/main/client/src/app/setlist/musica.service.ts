import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { APP_API } from '../service/app.api';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

   constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
     return this.http.get<any[]>(`${APP_API}musicas/list`);
     //return this.http.get<any[]>(`musicas/list`);
  }

  public salvar(musica: any): Observable<any> {
    return this.http.post(`${APP_API}musicas/save`,musica);
    //return this.http.post(`musicas/save`,musica);
  }

  public excluir(id: any): Observable<any> {
    return this.http.delete(`${APP_API}musicas/delete/${id}`);
    //return this.http.delete(`musicas/delete/${id}`);
  }
}
