import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { SharedService } from '../service/shared.service';
import { UserService } from '../service/user/user.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { CurrentUser } from '../model/currentUser';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  user = new User('','','','');
  shared : SharedService;
  message : string;
  
  constructor(private userService: UserService,
    private router: Router,
    private cookieService: CookieService) { 
    this.shared = SharedService.getInstance();
    }
  ngOnInit() {
  }

  cadastrarUsuario(){
    this.message = '';
    this.userService.createOrUpdate(this.user).subscribe((userAuthentication:CurrentUser) => {
        this.cookieService.set('token',userAuthentication.token)
        this.shared.token = userAuthentication.token;
        this.shared.user = userAuthentication.user;
        this.shared.user.profile = this.shared.user.profile.substring(5);
        this.shared.showTemplate.emit(true);
        this.router.navigate(['/']);
    } , err => {
      this.shared.token = null;
      this.shared.user = null;
      this.shared.showTemplate.emit(false);
      this.message = 'Erro ';
    });
  }

  getFormGroupClass(isInvalid: boolean, isDirty:boolean): {} {
    return {
      'form-group': true,
      'has-error' : isInvalid  && isDirty,
      'has-success' : !isInvalid  && isDirty
    };
  }

}
