import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/security/auth.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from 'src/app/service/user/user.service';
import decode from 'jwt-decode';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
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