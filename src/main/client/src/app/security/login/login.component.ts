import { CurrentUser } from '../../model/currentUser';
import { UserService } from '../../service/user/user.service';
import { User } from '../../model/user';
import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User('','','','');
  message : string;

  constructor(private userService: UserService,
              private router: Router,
              private cookieService: CookieService) { 
  }

  ngOnInit() {
    let token = this.cookieService.get('token');
    if(token){
      this.userService.refresh(this.user).subscribe((userAuthentication:CurrentUser) => {
        this.cookieService.set('token',userAuthentication.token)
        this.router.navigate(['/']);
    });
    }
  }
  
  showSuccess() {
    this.toastr.success('Hello world!', 'Toastr fun!');
  }
  
  login(){
    this.message = '';
    this.userService.login(this.user).subscribe((userAuthentication:CurrentUser) => {
        this.cookieService.set('token',userAuthentication.token)
        this.router.navigate(['/']);
    } , err => {
      this.message = 'Erro ';
    });
  }

  cancelLogin(){
    this.cookieService.delete('token');
    this.message = '';
    this.user = new User('', '','','');
    window.location.href = '/login';
    window.location.reload();
  }

  getFormGroupClass(isInvalid: boolean, isDirty:boolean): {} {
    return {
      'form-group': true,
      'has-error' : isInvalid  && isDirty,
      'has-success' : !isInvalid  && isDirty
    };
  }

}
