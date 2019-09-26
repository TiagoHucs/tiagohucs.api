import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.url.dev';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }

  public countProdutos(): Observable<any> {
    this.http.get<any[]>(`${API_URL}produtos/count`);
    return this.http.get<any[]>(`${API_URL}produtos/count`);
  }

  //TODO: vai sair daqui
  public countClientes(): Observable<any> {
    this.http.get<any[]>(`${API_URL}clientes/count`);
    return this.http.get<any[]>(`${API_URL}clientes/count`);
  }

    //TODO: vai sair daqui
    public countOrcamentos(): Observable<any> {
      this.http.get<any[]>(`${API_URL}orcamentos/count`);
      return this.http.get<any[]>(`${API_URL}orcamentos/count`);
    }

}
