import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { SnotifyModule, SnotifyService, SnotifyToast, ToastDefaults } from 'ng-snotify';
import { PublicacaoCriarComponent } from './publicacao-criar/publicacao-criar.component';
import { PublicacaoListarComponent } from './publicacao-listar/publicacao-listar.component';

@NgModule({
  declarations: [PublicacaoCriarComponent, PublicacaoListarComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports:[PublicacaoCriarComponent,PublicacaoListarComponent]
})
export class PublicacaoModule { }
