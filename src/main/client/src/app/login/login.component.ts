import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { CookieService } from 'ngx-cookie-service';

import { CurrentUser } from '../model/currentUser';
import { UserService } from '../service/user/user.service';
import { User } from '../model/user';

import { API_NOME } from './../app.constants'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loading: boolean;
  nomeAplicacao: string = API_NOME
  user = new User('', '', '', '');
  message: string;

  constructor(private userService: UserService,
    private router: Router,
    private cookieService: CookieService) {
  }

  ngOnInit() {
    let token = this.cookieService.get('token');
    if (token) {
      this.userService.refresh(this.user).subscribe((userAuthentication: CurrentUser) => {
        this.cookieService.set('token', userAuthentication.token)
        this.router.navigate(['/']);
      });
    }

  }

  login() {
    this.message = '';
    this.loading = true;
    this.userService.login(this.user).subscribe((userAuthentication: CurrentUser) => {
      this.cookieService.set('token', userAuthentication.token)
      this.router.navigate(['/']);
      this.loading = false;
    }, err => {
      this.message = err.error.message;
      this.loading = false;
    });
  }

  cancelLogin() {
    this.cookieService.delete('token');
    this.message = '';
    this.user = new User('', '', '', '');
    window.location.href = '/login';
    window.location.reload();
  }

  getFormGroupClass(isInvalid: boolean, isDirty: boolean): {} {
    return {
      'form-group': true,
      'has-error': isInvalid && isDirty,
      'has-success': !isInvalid && isDirty
    };
  }

  setUsuario() {
    this.user.email = 'usuario@system.com';
    this.user.password = '112233';
    console.log(this.user)
  }

  setAdmin() {
    this.user.email = 'admin@system.com';
    this.user.password = '123456';
    console.log(this.user)
  }
}
