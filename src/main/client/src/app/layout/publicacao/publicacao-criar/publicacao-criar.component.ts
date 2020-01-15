import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PublicacaoService } from '../publicacao.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-publicacao-criar',
  templateUrl: './publicacao-criar.component.html',
  styleUrls: ['./publicacao-criar.component.css']
})
export class PublicacaoCriarComponent implements OnInit {
  formPublicacao: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: PublicacaoService,
    private toastService: ToastrService) { }

  ngOnInit() {
    this.criaFormulario();
  }

  criaFormulario(){
    this.formPublicacao = this.formBuilder.group({
      texto: ['', [Validators.required, Validators.maxLength(150)]]
    });
  }

  publicar(){
    this.service.salvar(this.formPublicacao.getRawValue()).subscribe(
      response => {
        this.formPublicacao.reset();
        this.toastService.success('Postado com sucesso');
      }
    )
  }

}
