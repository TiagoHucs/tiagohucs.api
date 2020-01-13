import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import decode from 'jwt-decode';

import { AuthService } from 'src/app/security/auth.service';
import { UserService } from 'src/app/service/user/user.service';

import { API_NOME } from './../../../app.constants'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  nomeAplicacao: string = API_NOME
  username: string;

  constructor(private authService: AuthService,
              private router: Router,
              private cookieService: CookieService,
              public userService: UserService){
  }

  ngOnInit(){
    const token = this.cookieService.get('token');
    const tokenPayload = decode(token);
    console.log(tokenPayload)
    this.username = tokenPayload.sub;
  }

  signOut() : void {
    this.cookieService.delete('token');
    window.location.href = '/login';
    window.location.reload();
  }


}