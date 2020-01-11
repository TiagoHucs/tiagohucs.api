import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { ClienteVO } from '../cliente';
import { NgModel } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SnotifyService } from 'ng-snotify';

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
    private toastService: ToastrService,
    private snotify: SnotifyService
    ) { }

  ngOnInit() {
    this.obterClientes();
  }

  obterClientes(){
    this.loading = true;
    this.service.listar().subscribe(
      response => {
        this.clientes = response;
        console.log(this.clientes)
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

  confirmaExcluirCliente(id: number){
    this.snotify.confirm('Tem certeza que deseja excluir o cliente?'+ id, 'Exclusão', {
      timeout: 5000,
      showProgressBar: true,
      closeOnClick: true,
      pauseOnHover: true,
      buttons: [
        {text: 'Yes', action: () => this.excluirCliente(id), bold: false},
        {text: 'No', action: () => console.log('Clicked: No')}]
    });
  }

  excluirCliente(id: number){
    this.service.excluir(id).subscribe(
      response => {
        this.snotify.success(`Cliente ${id} excluido`,'Sucesso!');
        this.obterClientes()
      }
    ) 
  }




}
