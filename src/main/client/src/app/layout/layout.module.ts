import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { MusicasComponent } from './musicas/musicas.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';

@NgModule({
  declarations: [
    LayoutComponent, 
    ProdutosComponent, 
    HeaderComponent,
    MusicasComponent,
    DashboardComponent],
  imports: [
    CommonModule,
    LayoutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class LayoutModule { }
