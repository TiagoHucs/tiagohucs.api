import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user/user.service';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from '../security/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService,
              private router: Router,
              private cookieService: CookieService){
  }

  ngOnInit(){
  }

  signOut() : void {
    this.cookieService.delete('token');
    window.location.href = '/login';
    window.location.reload();
  }

}