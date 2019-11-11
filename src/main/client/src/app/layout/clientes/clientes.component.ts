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
  tipos: Object[] = [{codigo:0,descricao:'Pessoa Física'},{codigo:1,descricao:'Pessoa Jurídica'}]

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
      cpfcnpj: ['', [Validators.required]],
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
    this.criaFormulario();
  }

  salvaCliente(){
    this.service.salvar(this.meuFormulario.getRawValue()).subscribe(
      response => {
        this.toastService.success('Cliente salvo com sucesso');
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

  editaCliente(cliente: ClienteVO){
    this.meuFormulario.patchValue(cliente);
  }

  excluirCliente(cliente: ClienteVO){
    this.service.excluir(cliente.id).subscribe(
      response => {
        this.toastService.success('Cliente excluido com sucesso');
        this.listarClientes();
      },
      error => {
        console.log(error);
      }
    );
  }

  compare(val1, val2) {
    return val1.id === val2.id;
  }

}
