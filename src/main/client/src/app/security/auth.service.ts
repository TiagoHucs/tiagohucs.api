import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { CookieService } from 'ngx-cookie-service';

@Injectable()
export class AuthService {
  constructor(public jwtHelper: JwtHelperService,public cookieService: CookieService) {}
  // ...
  public isAuthenticated(): boolean {
    const token = this.cookieService.get('token');
    console.log('AuthService: token expirado?: '+ this.jwtHelper.isTokenExpired(token))
    return !this.jwtHelper.isTokenExpired(token);
  }
}