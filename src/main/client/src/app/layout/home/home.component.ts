import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  formPublicacao: FormGroup;
  publicacoes: string[] = [];

  constructor(
    public userService: UserService,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.criaFormulario();
  }

  criaFormulario(){
    this.formPublicacao = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      texto: ['', [Validators.required, Validators.maxLength(150)]]
    });
  }

  publicar(){
    this.publicacoes.push(this.formPublicacao.controls['texto'].value);
    this.formPublicacao.reset();
    console.log(`publicou ${this.publicacoes.length}`)
  }

}
