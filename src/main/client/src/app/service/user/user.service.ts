import { User } from '../../model/user';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { API_URL } from '../../app.url.dev'
import decode from 'jwt-decode';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class UserService {

  constructor(
    private http: HttpClient,
    private cookieService: CookieService){
    }

  getRole(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    return tokenPayload.role;
  }

  getUsername(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    return tokenPayload.sub;
  }

  login(user: User){
    return this.http.post(`${API_URL}api/auth`,user);
  }

  refresh(user: User){
    return this.http.post(`${API_URL}api/refresh`,user);
  }

  createOrUpdate(user: User){
    if(user.id != null && user.id != ''){
      console.log('user com id vou chamar endpoint de atualizaçaõ')
      return this.http.put(`${API_URL}user/update`,user);
    } else {
      user.id = null;
      console.log('user sem id vou chamar endpoint de criação')
      return this.http.post(`${API_URL}user/cadastrar `, user);
    }
  }

  findAll(page:number,count:number){
    return this.http.get(`${API_URL}api/user/${page}/${count}`);
  }

  findById(id:string){
    return this.http.get(`${API_URL}api/user/${id}`);
  }

  delete(id:string){
    return this.http.delete(`${API_URL}api/user/${id}`);
  }
}
