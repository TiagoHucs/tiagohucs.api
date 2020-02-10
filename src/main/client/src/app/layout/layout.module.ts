import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OrcamentoEditarComponent } from './orcamentos/orcamento-editar/orcamento-editar.component';
import { OrcamentoListarComponent } from './orcamentos/orcamento-listar/orcamento-listar.component';
import { ClientesModule } from './clientes/clientes.module';
import { SnotifyModule, SnotifyService, SnotifyToast, ToastDefaults } from 'ng-snotify';
import { HomeComponent } from './home/home.component';
import { PublicacaoModule } from './publicacao/publicacao.module';
import { GruposModule } from './grupos/grupos.module';
import { PerfilModule } from './perfil/perfil.module';

@NgModule({
  declarations: [
    LayoutComponent, 
    ProdutosComponent, 
    HeaderComponent,
    DashboardComponent,
    OrcamentoEditarComponent,
    OrcamentoListarComponent,
    HomeComponent
  ],
  imports: [
    PerfilModule,
    PublicacaoModule,
    GruposModule,
    CommonModule,
    LayoutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ClientesModule,
    SnotifyModule
  ],
  providers: [
    { provide: 'SnotifyToastConfig', useValue: ToastDefaults},
    SnotifyService
  ],
})
export class LayoutModule { }
