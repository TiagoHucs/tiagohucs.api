import { Component, OnInit } from '@angular/core';
import { Produto } from './produto';
import { ProdutosService } from './produtos.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.css']
})
export class ProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  produto: Produto = new Produto();
  meuFormulario: FormGroup;

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
    this.service.listar().subscribe(
      response => {
        this.produtos = response;
        this.contar();
      },
      error => {
        console.log(error);
      }
    )
  }

  contar(){
    this.service.count().subscribe(
      response => {
      },
      error => {
        console.log(error);
      }
    );
  }

  novoProduto(){
    this.produto = new Produto();
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

  editaProduto(produto: Produto){
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
    this.service.excluir(produto.id).subscribe(
      response => {
        this.listarProdutos();
      },
      error => {
        console.log(error);
      }
    );
  }

}
