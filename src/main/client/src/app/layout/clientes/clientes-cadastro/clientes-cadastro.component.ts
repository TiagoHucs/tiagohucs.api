import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ClienteVO } from '../cliente';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-clientes-cadastro',
  templateUrl: './clientes-cadastro.component.html',
  styleUrls: ['./clientes-cadastro.component.css']
})
export class ClientesCadastroComponent implements OnInit {
  formCliente: FormGroup;
  loading: boolean;
  tipos: string[];
  
  constructor(
    private service: ClientesService,
    private formBuilder: FormBuilder,
    private toastService: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    ) {
  }

  ngOnInit() {
    this.obterTipos();
    this.criaFormulario();
    this.activatedRoute.params.subscribe(params => {
      if(params.id){
        this.preencherParaEdicao(params.id);
      }
    });
  }

  criaFormulario(){
    this.formCliente = this.formBuilder.group({
      id: [''],
      nome: ['', [Validators.required, Validators.maxLength(150)]],
      cpfcnpj: ['', [Validators.required]],
      tipoClienteId: [null, [Validators.required]],
    });
  }

  obterTipos(){
    this.service.tipos().subscribe(
      response => {
        this.tipos = response;
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

  preencherParaEdicao(id: number){
    this.service.obter(id).subscribe(
      res => {
        this.formCliente.patchValue(res);
      }
    )
  }



}
