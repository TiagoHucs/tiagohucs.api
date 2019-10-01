import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrcamentoVO } from './orcamento';
import { OrcamentoService } from './orcamento.service';
import { ClientesService } from '../clientes/clientes.service';
import { Cliente } from '../clientes/cliente';

@Component({
  selector: 'app-orcamentos',
  templateUrl: './orcamentos.component.html',
  styleUrls: ['./orcamentos.component.css']
})
export class OrcamentosComponent implements OnInit {

  orcamentos: OrcamentoVO[] = [];
  clientes: Cliente[] = [];
  orcamento: OrcamentoVO = new OrcamentoVO();
  meuFormulario: FormGroup;

  constructor(
    private service: OrcamentoService,
    private clienteService: ClientesService,
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
        this.orcamentos = response;
      },
      error => {
        console.log(error);
      }
    )
  }

  novoOrcamento(){
    this.clienteService.listar().subscribe(
      response => {
        this.clientes = response;
      },
      error => {
        console.log(error);
      }
    );
    this.converteOrcamentoEmForm(new OrcamentoVO());
  }

  salvaOrcamento(){
    this.converteFormEmOrcamento();
    this.service.salvar(this.orcamento).subscribe(
      response => {
        this.listarOrcamentos();
      },
      error => {
        console.log(error);
      }
    );
  }

  converteFormEmOrcamento(){
    this.orcamento.clienteId = this.meuFormulario.controls['cliente'].value;
  }

  converteOrcamentoEmForm(orcamento: OrcamentoVO){
  }


  editaOrcamento(orcamento: OrcamentoVO){
    this.orcamento = orcamento;
    this.converteOrcamentoEmForm(orcamento)
  }

  confirmaEditaOrcamento(orcamento: OrcamentoVO){
    this.service.salvar(orcamento).subscribe(
      response => {
        this.listarOrcamentos();
      },
      error => {
        console.log(error);
      }
    )
  }

  excluiOrcamento(orcamento: OrcamentoVO){
    this.orcamento = orcamento;
  }

  confirmaExcluiOrcamento(){
    this.service.excluir(this.orcamento.id).subscribe(
      response => {
        this.listarOrcamentos();
      },
      error => {
        console.log(error);
      }
    );
  }

}
