import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OrcamentoVO } from '../orcamento';
import { OrcamentoService } from '../orcamento.service';
import { ClienteVO } from '../../clientes/cliente';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-orcamento-listar',
  templateUrl: './orcamento-listar.component.html',
  styleUrls: ['./orcamento-listar.component.css']
})
export class OrcamentoListarComponent implements OnInit {

  orcamentos: OrcamentoVO[] = [];
  clientes: ClienteVO[] = [];
  orcamento: OrcamentoVO = new OrcamentoVO();
  meuFormulario: FormGroup;

  constructor(
    private service: OrcamentoService,
    private toastService: ToastrService,
    private formBuilder: FormBuilder
    ) {
  }

  ngOnInit() {
    this.criaFormulario();
    this.listarOrcamentos();
  }

  criaFormulario(){
    this.meuFormulario = this.formBuilder.group({
      cliente: ['', [Validators.required, Validators.maxLength(150)]]
    });
  }

  listarOrcamentos(){
    this.service.listar().subscribe(
      response => {
        this.orcamentos = response;
      },
      error => {
        console.log(error);
      }
    )
  }

  excluirOrcamento(orcamento: OrcamentoVO,confirmado: boolean){
    if(confirmado){
      this.service.excluir(orcamento.id).subscribe(
        response => {
          this.toastService.success('Orçamento excluidosalvo com sucesso');
          this.listarOrcamentos();
        },
        error => {
          console.log(error);
        }
      )
    } else {
      this.orcamento = orcamento;
    }
  }

}
