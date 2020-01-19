import { Component, OnInit } from '@angular/core';
import { Perfil } from 'src/app/model/user';
import { UserService } from 'src/app/service/user/user.service';
import { PerfilService } from 'src/app/service/perfil/perfil.service';
import { resolve } from 'url';

@Component({
  selector: 'app-perfil-lateral',
  templateUrl: './perfil-lateral.component.html',
  styleUrls: ['./perfil-lateral.component.css']
})
export class PerfilLateralComponent implements OnInit {
  perfil: Perfil;
  image: any;

  constructor(
    private userService: UserService,
    private perfilService: PerfilService) { }

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

  changeListener($event) : void {
    this.readThis($event.target);
  }
  
  readThis(inputValue: any): void {
    var file:File = inputValue.files[0];
    var myReader:FileReader = new FileReader();
  
    myReader.onloadend = (e) => {
      this.image = myReader.result;
      this.perfil.imagem = this.image;
      this.perfilService.salvarImagem(this.image).subscribe(
        resolve => {
            console.log('salvo com sucesso');
        }, err => {
          console.log('deu erro');
        }
      );
    }
    myReader.readAsDataURL(file);
  }
}
