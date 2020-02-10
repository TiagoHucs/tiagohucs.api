import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from '../../app.url.dev'

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(
    private http: HttpClient
  ) { }

  getUsername2(): Observable<any> {
    return this.http.get(`${API_URL}perfil`);
  }

  listar(): Observable<any> {
    return this.http.get(`${API_URL}perfil/listar`);
  }

  salvarImagem(imagem: string): Observable<any> {
    return this.http.post(`${API_URL}salvaimagem`, imagem);
  }
}
