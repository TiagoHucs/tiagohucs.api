import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NgxCurrencyModule } from 'ngx-currency';
import { OrcamentosComponent } from './orcamentos/orcamentos.component';
import { ClientesComponent } from './clientes/clientes.component'

@NgModule({
  declarations: [
    LayoutComponent, 
    ProdutosComponent, 
    HeaderComponent,
    DashboardComponent,
    OrcamentosComponent,
    ClientesComponent],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyModule,
  ]
})
export class LayoutModule { }
