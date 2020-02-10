import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user/user.service';
import { PerfilVO } from 'src/app/model/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  perfil: PerfilVO;
  image: any;

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

  changeListener($event) : void {
    this.readThis($event.target);
  }
  
  readThis(inputValue: any): void {
    var file:File = inputValue.files[0];
    var myReader:FileReader = new FileReader();
  
    myReader.onloadend = (e) => {
      this.image = myReader.result;
    }
    myReader.readAsDataURL(file);
  }

}
