import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesCadastroComponent } from './clientes-cadastro/clientes-cadastro.component';
import { ClientesListarComponent } from './clientes-listar/clientes-listar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ClientesCadastroComponent,
    ClientesListarComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class ClientesModule { }
