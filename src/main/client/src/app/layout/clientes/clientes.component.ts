import { Component, OnInit } from '@angular/core';
import { ClienteVO } from './cliente'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientesService } from './clientes.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styles: ['']
})
export class ClientesComponent implements OnInit {
  clientes: ClienteVO[] = [];
  cliente: ClienteVO = new ClienteVO();
  meuFormulario: FormGroup;
  loading: boolean;

  constructor(
    private service: ClientesService,
    private formBuilder: FormBuilder,
    private toastService: ToastrService,
    ) {
  }

  ngOnInit() {
    this.criaFormulario();
    this.listarClientes();
  }

  criaFormulario(){
    this.meuFormulario = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      cpfCnpj: ['', [Validators.required]],
      tipoCliente: ['', [Validators.required]],
    });
  }

  listarClientes(){
    this.loading = true;
    this.service.listar().subscribe(
      response => {
        this.clientes = response;
        this.loading = false;
      },
      error => {
        console.log(error);
      }
    )
  }

  novoCliente(){
    this.cliente = new ClienteVO();
    this.converteClienteEmForm(this.cliente);
  }

  salvaCliente(){
    this.converteFormEmCliente();
    this.service.salvar(this.cliente).subscribe(
      response => {
        this.toastService.success('Cliente salvo com sucesso');
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

  converteFormEmCliente(){
    this.cliente.nome = this.meuFormulario.controls['nome'].value;
    this.cliente.cpfcnpj = this.meuFormulario.controls['cpfCnpj'].value;
    this.cliente.tipoCliente = this.meuFormulario.controls['tipoCliente'].value;
  }

  converteClienteEmForm(cliente: ClienteVO){
    this.meuFormulario.controls['nome'].setValue(cliente.nome);
    this.meuFormulario.controls['cpfCnpj'].setValue(cliente.cpfcnpj);
    this.meuFormulario.controls['tipoCliente'].setValue(this.converteEnumTipoCliente(cliente.tipoCliente));
  }

  // TODO: criar um util da aplicacao
  converteEnumTipoCliente(enu: string){
    if(enu === "PF"){
      return 0;
    }else if(enu === "PJ"){
      return 1;
    }
  }

  editaCliente(cliente: ClienteVO){
    this.cliente = cliente;
    this.converteClienteEmForm(this.cliente);
  }

  excluiCliente(){
    this.service.excluir(this.cliente.id).subscribe(
      response => {
        this.toastService.success('Cliente excluido com sucesso');
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

}
