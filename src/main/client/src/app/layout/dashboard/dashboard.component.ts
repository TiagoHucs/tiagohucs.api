import { Component, OnInit } from '@angular/core';
import { ProdutosService } from '../produtos/produtos.service';
import { DashboardService } from './dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  produtosQtd: number = 0;
  clientesQtd: number = 0;
  orcamentosQtd: number = 0;
  

  constructor(private service: DashboardService) {
  }

  ngOnInit() {
    this.contar();
  }

  contar(){
    this.service.countProdutos().subscribe(
      response => {
        this.produtosQtd = response;
      },
      error => {
        console.log(error);
      }
    );
    this.service.countClientes().subscribe(
      response => {
        this.clientesQtd = response;
      },
      error => {
        console.log(error);
      }
    );
    this.service.countOrcamentos().subscribe(
      response => {
        this.orcamentosQtd = response;
      },
      error => {
        console.log(error);
      }
    );
  }
}
