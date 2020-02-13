import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutComponent } from './layout.component';
import { HeaderComponent } from './components/header/header.component';
import { LayoutRoutingModule } from './layout-routing.module';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { SnotifyModule, SnotifyService, SnotifyToast, ToastDefaults } from 'ng-snotify';
import { HomeComponent } from './home/home.component';
import { PublicacaoModule } from './publicacao/publicacao.module';
import { GruposModule } from './grupos/grupos.module';
import { PerfilModule } from './perfil/perfil.module';

@NgModule({
  declarations: [
    LayoutComponent, 
    HeaderComponent,
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
    SnotifyModule
  ],
  providers: [
    { provide: 'SnotifyToastConfig', useValue: ToastDefaults},
    SnotifyService
  ],
})
export class LayoutModule { }
