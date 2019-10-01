import { Component, OnInit } from '@angular/core';
import { Produto } from './produto';
import { ProdutosService } from './produtos.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styles: ['']
})
export class ProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  produto: Produto = new Produto();
  meuFormulario: FormGroup;
  loading: boolean;

  constructor(
    private service: ProdutosService,
    private formBuilder: FormBuilder
    ) {
  }

  ngOnInit() {
    this.criaFormulario();
    this.listarProdutos();
  }

  criaFormulario(){
    this.meuFormulario = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      valor: ['', [Validators.required]],
      tipoMedida: ['', [Validators.required]],
    });
  }

  listarProdutos(){
    this.loading = true;
    this.service.listar().subscribe(
      response => {
        this.produtos = response;
        this.loading = false;
      },
      error => {
        console.log(error);
      }
    )
  }

  novoProduto(){
    this.converteProdutoEmForm(new Produto());
  }

  salvaProduto(){
    this.converteFormEmProduto();
    this.service.salvar(this.produto).subscribe(
      response => {
        this.listarProdutos();
      },
      error => {
        console.log(error);
      }
    );
  }

  converteFormEmProduto(){
    this.produto.nome = this.meuFormulario.controls['nome'].value;
    this.produto.valor = this.meuFormulario.controls['valor'].value;
    this.produto.tipoMedida = this.meuFormulario.controls['tipoMedida'].value;
  }

  converteProdutoEmForm(produto: Produto){
    this.meuFormulario.controls['nome'].setValue(produto.nome);
    this.meuFormulario.controls['valor'].setValue(produto.valor);
    this.meuFormulario.controls['tipoMedida'].setValue(this.converteEnumTipoMedida(produto.tipoMedida));
    console.log(produto.tipoMedida);
  }

  // TODO: criar um util da aplicacao

  converteEnumTipoMedida(enu: string){
    if(enu === "UN"){
      return 0;
    }else if(enu === "KG"){
      return 1;
    }else if(enu === "HR"){
      return 2;
    }
  }

  editaProduto(produto: Produto){
    this.produto = produto;
    this.converteProdutoEmForm(produto)
  }

  confirmaEditaProduto(produto: Produto){
    this.service.salvar(produto).subscribe(
      response => {
        this.listarProdutos();
      },
      error => {
        console.log(error);
      }
    )
  }

  excluiProduto(produto: Produto){
    this.produto = produto;
  }

  confirmaExcluiProduto(){
    this.service.excluir(this.produto.id).subscribe(
      response => {
        this.listarProdutos();
      },
      error => {
        console.log(error);
      }
    );
  }

}
