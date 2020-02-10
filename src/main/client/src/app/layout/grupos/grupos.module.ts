import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GruposListarComponent } from './grupos-listar/grupos-listar.component';

@NgModule({
  declarations: [GruposListarComponent],
  imports: [
    CommonModule
  ],
  exports:  [GruposListarComponent]
})
export class GruposModule { }
