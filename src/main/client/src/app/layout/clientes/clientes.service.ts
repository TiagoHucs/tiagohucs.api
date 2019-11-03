import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  CLI_URL: string = 'clientes/';

  constructor(private http: HttpClient) { }

  public listar(): Observable<any> {
    return this.http.get<any[]>(`${API_URL}${this.CLI_URL}list`);
  }

  public salvar(cliente: any): Observable<any> {
    console.log(cliente)
    return this.http.post(`${API_URL}${this.CLI_URL}save`, cliente);
  }

  public excluir(id: any): Observable<any> {
    return this.http.delete(`${API_URL}${this.CLI_URL}delete/${id}`);
  }

  public baixarRelatorio(): Observable<any> {
    return this.http.get(`${API_URL}${this.CLI_URL}relatorio`, { responseType: 'blob' });
  }
}
