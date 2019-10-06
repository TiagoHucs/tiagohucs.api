import { Component, OnInit } from '@angular/core';
import { ClienteVO } from './cliente'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ClientesService } from './clientes.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  loading: boolean;
  clientes: ClienteVO[] = [];
  cliente: ClienteVO = new ClienteVO();
  meuFormulario: FormGroup;

  constructor(
    private service: ClientesService,
    private formBuilder: FormBuilder
    ) {
  }

  ngOnInit() {
    this.criaFormulario();
    this.listarClientes();
  }

  criaFormulario(){
    this.meuFormulario = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      cpfcnpj: ['', [Validators.required]],
      tipoCliente: ['', [Validators.required]]
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
        this.loading = false;
      }
    )
  }

  novoCliente(){
    this.converteClienteEmForm(new ClienteVO());
  }

  salvaCliente(){
    this.converteFormEmCliente();
    this.service.salvar(this.cliente).subscribe(
      response => {
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

  converteFormEmCliente(){
    this.cliente.nome = this.meuFormulario.controls['nome'].value;
    this.cliente.cpfcnpj = this.meuFormulario.controls['cpfcnpj'].value;
    this.cliente.tipoCliente = this.meuFormulario.controls['tipoCliente'].value;
  }

  converteClienteEmForm(cliente: ClienteVO){
    this.meuFormulario.controls['nome'].setValue(cliente.nome);
    this.meuFormulario.controls['cpfcnpj'].setValue(cliente.cpfcnpj);
    this.meuFormulario.controls['tipoCliente'].setValue(this.converteEnumTipoMedida(cliente.tipoCliente));
  }

  converteEnumTipoMedida(enu: string){
    if(enu === "PF"){
      return 0;
    }else if(enu === "PJ"){
      return 1;
    }
  }

  editaCliente(cliente: ClienteVO){
    this.cliente = cliente;
    this.converteClienteEmForm(cliente)
  }

  confirmaEditaCliente(cliente: ClienteVO){
    this.service.salvar(cliente).subscribe(
      response => {
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    )
  }

  excluiCliente(cliente: ClienteVO){
    this.cliente = cliente;
  }

  confirmaExcluiCliente(){
    this.service.excluir(this.cliente.id).subscribe(
      response => {
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

}
