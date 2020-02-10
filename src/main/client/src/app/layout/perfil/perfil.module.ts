import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilListarComponent } from './perfil-listar/perfil-listar.component';
import { PerfilLateralComponent } from './perfil-lateral/perfil-lateral.component';
import { PerfilService } from './perfil.service';

@NgModule({
  declarations: [PerfilListarComponent,PerfilLateralComponent],
  imports: [
    CommonModule
  ],
  providers: [
    PerfilService
  ],
  exports:  [PerfilListarComponent,PerfilLateralComponent]
})
export class PerfilModule { }
