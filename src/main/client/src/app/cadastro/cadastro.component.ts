import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { ToastrService } from 'ngx-toastr';

import { User } from '../model/user';
import { UserService } from '../service/user/user.service';
import { CurrentUser } from '../model/currentUser';

import { API_NOME } from './../app.constants'

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  nomeAplicacao: string = API_NOME;
  user = new User('','','','');
  message : string;
  cadastrou : boolean;
  loading: boolean;
  
  constructor(
    private userService: UserService,
    private router: Router) { 
  }

  ngOnInit() {

  }

  cadastrar(){
      this.message = '';
      this.user.profile = null;
      this.loading = true;
      this.userService.createOrUpdate(this.user).subscribe((userAuthentication:CurrentUser) => {
        //this.toastService.success('Cadastrado com sucesso, faça o seu login!','Concluído');
        this.cadastrou = true  
        //this.router.navigate(['/login']);
        this.loading = false;
      } , err => {
        this.message = err.error.message;
        console.log(err.error.message)
        this.loading = false;
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
