import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class OrcamentoService {

  ORC_URL: string = 'orcamentos/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${API_URL}${this.ORC_URL}list`);
  }

  public salvar(orcamento: any): Observable<any> {
    return this.http.post(`${API_URL}${this.ORC_URL}save`, orcamento);
  }

  public excluir(id: any): Observable<any> {
    return this.http.delete(`${API_URL}${this.ORC_URL}delete/${id}`);
  }

  public baixarRelatorio(): Observable<any> {
    return this.http.get(`${API_URL}${this.ORC_URL}relatorio`, { responseType: 'blob' });
  }
}
