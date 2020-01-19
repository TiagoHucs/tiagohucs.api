import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class PublicacaoService {
  private subject = new Subject<any>();

  PROD_URL: string = 'publicacao/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${API_URL}${this.PROD_URL}listar`);
  }

  public salvar(produto: any): Observable<any> {
    return this.http.post(`${API_URL}${this.PROD_URL}criar`, produto);
  }

  public excluir(id: any): Observable<any> {
    return this.http.delete(`${API_URL}${this.PROD_URL}exluir/${id}`);
  }

  sendMessage() {
    this.subject.next();
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }

}
