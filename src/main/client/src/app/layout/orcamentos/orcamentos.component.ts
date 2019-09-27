import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Orcamento } from './orcamento';
import { OrcamentoService } from './orcamento.service';

@Component({
  selector: 'app-orcamentos',
  templateUrl: './orcamentos.component.html',
  styleUrls: ['./orcamentos.component.css']
})
export class OrcamentosComponent implements OnInit {

  orcamentos: Orcamento[] = [];
  orcamento: Orcamento = new Orcamento();
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
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      valor: ['', [Validators.required]],
      tipoMedida: ['', [Validators.required]],
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

  novoProduto(){
    this.converteOrcamentoEmForm(new Orcamento());
  }

  salvaProduto(){
    this.converteFormEmProduto();
    this.service.salvar(this.orcamento).subscribe(
      response => {
        this.listarOrcamentos();
      },
      error => {
        console.log(error);
      }
    );
  }

  converteFormEmProduto(){
    // this.orcamento.nome = this.meuFormulario.controls['nome'].value;
    // this.orcamento.valor = this.meuFormulario.controls['valor'].value;
    // this.orcamento.tipoMedida = this.meuFormulario.controls['tipoMedida'].value;
  }

  converteOrcamentoEmForm(orcamento: Orcamento){
    // this.meuFormulario.controls['nome'].setValue(orcamento.nome);
    // this.meuFormulario.controls['valor'].setValue(orcamento.valor);
    // this.meuFormulario.controls['tipoMedida'].setValue(this.converteEnumTipoMedida(produto.tipoMedida));
  }


  editaProduto(orcamento: Orcamento){
    this.orcamento = orcamento;
    this.converteOrcamentoEmForm(orcamento)
  }

  confirmaEditaProduto(orcamento: Orcamento){
    this.service.salvar(orcamento).subscribe(
      response => {
        this.listarOrcamentos();
      },
      error => {
        console.log(error);
      }
    )
  }

  excluiProduto(orcamento: Orcamento){
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
