import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrcamentoVO } from '../orcamento';
import { OrcamentoService } from '../orcamento.service';
import { ClienteVO } from '../../clientes/cliente';

@Component({
  selector: 'app-orcamento-listar',
  templateUrl: './orcamento-listar.component.html',
  styleUrls: ['./orcamento-listar.component.css']
})
export class OrcamentoListarComponent implements OnInit {

  orcamentos: OrcamentoVO[] = [];
  clientes: ClienteVO[] = [];
  orcamento: OrcamentoVO = new OrcamentoVO();
  meuFormulario: FormGroup;

  constructor(
    private service: OrcamentoService,
    private formBuilder: FormBuilder
    ) {
  }

  ngOnInit() {
    this.criaFormulario();
    this.listarOrcamentos();
    console.log(this.orcamentos);
  }

  criaFormulario(){
    this.meuFormulario = this.formBuilder.group({
      cliente: ['', [Validators.required, Validators.maxLength(150)]]
    });
  }

  listarOrcamentos(){
    this.service.listar().subscribe(
      response => {
        console.log(this.orcamentos)
        //this.orcamentos = response;
      },
      error => {
        console.log(error);
      }
    )
  }

}
