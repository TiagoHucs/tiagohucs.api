import { Component, OnInit } from '@angular/core';
import { PerfilService } from '../perfil.service';
import { PerfilVO } from 'src/app/model/user';

@Component({
  selector: 'app-perfil-listar',
  templateUrl: './perfil-listar.component.html',
  styleUrls: ['./perfil-listar.component.css']
})
export class PerfilListarComponent implements OnInit {
  perfilList: PerfilVO[];

  constructor(private perfilService: PerfilService) { }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.perfilService.listar().subscribe(
      resolve => {
        this.perfilList = resolve;
      }
    )
  }

}
