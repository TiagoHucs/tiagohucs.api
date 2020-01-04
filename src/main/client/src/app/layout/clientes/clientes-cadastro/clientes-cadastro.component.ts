import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ClienteVO } from '../cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clientes-cadastro',
  templateUrl: './clientes-cadastro.component.html',
  styleUrls: ['./clientes-cadastro.component.css']
})
export class ClientesCadastroComponent implements OnInit {
  formCliente: FormGroup;
  loading: boolean;
  tipos: string[] = ['a','b','c'];
  
  constructor(
    private service: ClientesService,
    private formBuilder: FormBuilder,
    private toastService: ToastrService,
    private router: Router
    ) {
  }

  ngOnInit() {
    this.obterTipos();
    this.criaFormulario();
  }

  criaFormulario(){
    this.formCliente = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      cpfcnpj: ['', [Validators.required]],
      tipoCliente: [null, [Validators.required]],
    });
  }

  obterTipos(){
    this.service.tipos().subscribe(
      response => {
        this.tipos = response;
        console.log(this.tipos)
      }
    )
  }

  cadastrar(){
   this.service.salvar(this.formCliente.getRawValue()).subscribe(
        response => {
          this.toastService.success('Cliente cadastrado','Sucesso')
          this.router.navigate(['/clientes'])
       }
     )
   }

}
