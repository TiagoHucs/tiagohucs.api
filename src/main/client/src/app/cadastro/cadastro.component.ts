import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user/user.service';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { CurrentUser } from '../model/currentUser';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

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
