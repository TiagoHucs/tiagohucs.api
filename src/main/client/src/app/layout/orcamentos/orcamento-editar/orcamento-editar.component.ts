import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../../clientes/clientes.service';
import { ClienteVO } from '../../clientes/cliente';
import { ProdutoVO } from '../../produtos/produto';
import { ProdutosService } from '../../produtos/produtos.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrcamentoVO, ItemVO } from '../orcamento';
import { OrcamentoService } from '../orcamento.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-orcamento-editar',
  templateUrl: './orcamento-editar.component.html',
  styleUrls: ['./orcamento-editar.component.css']
})
export class OrcamentoEditarComponent implements OnInit {
  clientes: ClienteVO[];
  produtos: ProdutoVO[];
  orcamento: OrcamentoVO = new OrcamentoVO();
  novoItem: ItemVO = new ItemVO();
  formItem: FormGroup;

  constructor(
    private clienteService: ClientesService,
    private orcamentoService: OrcamentoService,
    private produtoService: ProdutosService,
    private toastService: ToastrService,
  ) { }

  ngOnInit() {
    this.orcamento.cliente = new ClienteVO();
    this.orcamento.itens = [];
    this.orcamento.total = 0;
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

  addItemToList() {
    this.orcamento.itens.push(this.novoItem);
    this.calculaTotal();
    this.novoItem = new ItemVO();
  }

  salvarOrcamento(){
    this.orcamentoService.salvar(this.orcamento).subscribe(
      response => {
        this.toastService.success('Orçamento salvo com sucesso');
      },
      error => {
        console.log(error);
      }
    );
  }

  calculaTotal(){
    if(this.orcamento.itens.length > 0){
      this.orcamento.itens.forEach(item => {
        console.log('adicionando '+ item.quantidade + item.produto.nome + 's:');
        this.orcamento.total = this.orcamento.total + (item.valorUnitario * item.quantidade);
      });
    } else {
      console.log('Lista zerada! ');

      this.orcamento.total = 0;
    }
    console.log('calcula total: '+ this.orcamento.total);
  }

}
