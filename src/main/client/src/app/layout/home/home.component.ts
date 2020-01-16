import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user/user.service';
import { Perfil } from 'src/app/model/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  perfil: Perfil;

  constructor(
    private userService: UserService) { }

  ngOnInit() {
    this.obterNome();
  }

  obterNome(){
    this.userService.getUsername2().subscribe(
      response => {
        this.perfil = response;
      }, err => {
        console.log('erro ao obter username')
      }
    )
  }

}
