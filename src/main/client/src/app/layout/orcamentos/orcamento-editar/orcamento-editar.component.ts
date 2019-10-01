import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../../clientes/clientes.service';
import { Cliente } from '../../clientes/cliente';
import { Produto } from '../../produtos/produto';
import { ProdutosService } from '../../produtos/produtos.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-orcamento-editar',
  templateUrl: './orcamento-editar.component.html',
  styleUrls: ['./orcamento-editar.component.css']
})
export class OrcamentoEditarComponent implements OnInit {
  clientes: Cliente[];
  produtos: Produto[];
  produtoAdd: Produto;
  qtdAdd: number;
  itens: any[] = [];

  formItem: FormGroup;

  constructor(
    private clienteService: ClientesService,
    private produtoService: ProdutosService,
  ) { }

  ngOnInit() {
    this.listaClientes();
    this.listaProdutos();
  }

  listaClientes() {
    this.clienteService.listar().subscribe(
      response => {
        this.clientes = response;
      },
      error => {
        console.log(error);
      }
    );
  }

  listaProdutos() {
    this.produtoService.listar().subscribe(
      response => {
        this.produtos = response;
      },
      error => {
        console.log(error);
      }
    );
  }

  novoItem() {
    this.produtoAdd = new Produto();
  }

  addItemToList() {
    console.log(this.produtoAdd);
    this.itens.push(this.produtoAdd);
  }

}
