import { Component, OnInit } from '@angular/core';
import { ProdutosService } from '../produtos/produtos.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  produtosQtd: number = 0;
  clientesQtd: number = 0;
  orcamentosQtd: number = 0;
  

  constructor(private service: ProdutosService) {
  }

  ngOnInit() {
    this.contar();
  }

  contar(){
    this.service.count().subscribe(
      response => {
        this.produtosQtd = response;
      },
      error => {
        console.log(error);
      }
    );
    this.service.countC().subscribe(
      response => {
        this.clientesQtd = response;
      },
      error => {
        console.log(error);
      }
    );
    this.service.countO().subscribe(
      response => {
        this.orcamentosQtd = response;
      },
      error => {
        console.log(error);
      }
    );
  }
}
