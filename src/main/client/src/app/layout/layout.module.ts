import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NgxCurrencyModule } from 'ngx-currency';
import { ClientesComponent } from './clientes/clientes.component';
import { OrcamentoEditarComponent } from './orcamentos/orcamento-editar/orcamento-editar.component';
import { OrcamentoListarComponent } from './orcamentos/orcamento-listar/orcamento-listar.component';

@NgModule({
  declarations: [
    LayoutComponent, 
    ProdutosComponent, 
    HeaderComponent,
    DashboardComponent,
    ClientesComponent,
    OrcamentoEditarComponent,
    OrcamentoListarComponent],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyModule,
  ]
})
export class LayoutModule { }
