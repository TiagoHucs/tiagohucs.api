import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NgxCurrencyModule } from 'ngx-currency';
import { OrcamentoEditarComponent } from './orcamentos/orcamento-editar/orcamento-editar.component';
import { OrcamentoListarComponent } from './orcamentos/orcamento-listar/orcamento-listar.component';
import { ClientesModule } from './clientes/clientes.module';

@NgModule({
  declarations: [
    LayoutComponent, 
    ProdutosComponent, 
    HeaderComponent,
    DashboardComponent,
    OrcamentoEditarComponent,
    OrcamentoListarComponent,],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyModule,
    ClientesModule
  ]
})
export class LayoutModule { }
