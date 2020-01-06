import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { ClienteVO } from '../cliente';
import { NgModel } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-clientes-listar',
  templateUrl: './clientes-listar.component.html',
  styleUrls: ['./clientes-listar.component.css']
})
export class ClientesListarComponent implements OnInit {
  public clientes: ClienteVO[];
  public loading: boolean;

  constructor(
    private service: ClientesService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastService: ToastrService
    ) { }

  ngOnInit() {
    this.obterClientes();
  }

  obterClientes(){
    this.loading = true;
    this.service.listar().subscribe(
      response => {
        this.clientes = response;
        this.loading = false;
      }
    )
  }

  novoCliente(){
    this.router.navigate(['clientes/cadastro']);
  }

  editarCliente(id: number){
    this.router.navigate([`clientes/cadastro/${id}`]);
  }

  excluirCliente(id: number){
    this.service.excluir(id).subscribe(
      response => {
        this.toastService.success('Cliente excluido','Sucesso')
        this.obterClientes()
      }
    )
  }

}
