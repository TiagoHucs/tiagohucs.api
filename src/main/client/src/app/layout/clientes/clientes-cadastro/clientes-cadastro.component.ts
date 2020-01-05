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

  formatarCpfCnpj(){
    let cod = this.formCliente.controls['cpfcnpj'].value;
    let tipo = this.getTipo();
    cod = cod.replace(/[^0-9]/g, '');

    if(tipo !== null && tipo === '1'){
      cod = this.formatarCpf(cod);
    } else if (tipo !== null && tipo === '2'){
      cod = this.formatarCnpj(cod);
    }
    this.formCliente.controls['cpfcnpj'].setValue(cod);
  }

  formatarCpf(txt: string){
    txt = txt.substr(0,11)
    if(txt.length > 3){
      txt = txt.substr(0,3) + '.' + txt.substr(3);
    }
    if(txt.length > 7){
      txt = txt.substr(0,7) + '.' + txt.substr(7);
    }
    if(txt.length > 11){
      txt = txt.substr(0,11) + '-' + txt.substr(11);
    }
    return txt;
  }

  formatarCnpj(txt: string){
    txt = txt.substr(0,14)
    if(txt.length > 2){
      txt = txt.substr(0,2) + '.' + txt.substr(2);
    }
    if(txt.length > 6){
      txt = txt.substr(0,6) + '.' + txt.substr(6);
    }
    if(txt.length > 10){
      txt = txt.substr(0,10) + '/' + txt.substr(10);
    }
    if(txt.length > 15){
      txt = txt.substr(0,15) + '-' + txt.substr(15);
    }
    return txt;
  }

  getMaxLength(){
    let tipo = this.getTipo();
    if(tipo !== null && tipo === '1'){
      return 14
    } else if (tipo !== null && tipo === '2'){
      return 18
    } else {
      return 50
    }
  }


  getTipo(){
    return this.formCliente.controls['tipoClienteId'].value;
  }


}
