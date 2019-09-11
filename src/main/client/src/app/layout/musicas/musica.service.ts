import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../../app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

   constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
     return this.http.get<any[]>(`${API_URL}musicas/list`);

  }

  public salvar(musica: any): Observable<any> {
    return this.http.post(`${API_URL}musicas/save`,musica);
  }

  public excluir(id: any): Observable<any> {
    return this.http.delete(`${API_URL}musicas/delete/${id}`);
  }

  public baixarRelatorio(): Observable<any> {
    return this.http.get(`${API_URL}relatorio/musicas`, { responseType: 'blob'}); 
  }

}
