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
  
  constructor(
    private userService: UserService,
    private toastService: ToastrService,
    private router: Router) { 
  }

  ngOnInit() {

  }

  cadastrar(){
      this.message = '';
      this.user.profile = null;
      this.userService.createOrUpdate(this.user).subscribe((userAuthentication:CurrentUser) => {
        //this.toastService.success('Cadastrado com sucesso, faça o seu login!','Concluído');
        this.cadastrou = true  
        //this.router.navigate(['/login']);
      } , err => {
        this.toastService.error(err.error.status + ' - ' + err.error.message,'Erro');
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
