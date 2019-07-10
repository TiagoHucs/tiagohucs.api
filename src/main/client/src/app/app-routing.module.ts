import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SetlistComponent } from './setlist/setlist.component';
import { AuthGuard } from './security/auth.guard';
import { LoginComponent } from './security/login/login.component';
import { ConfiguracoesComponent } from './configuracoes/configuracoes.component';
import { RoleGuardService as RoleGuard  } from './security/role.guard.service';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: '', component: HomeComponent, canActivate: [AuthGuard]},
  { path: 'setlist', component: SetlistComponent, canActivate: [AuthGuard]},
  { path: 'configuracoes', component: ConfiguracoesComponent, 
    canActivate: [RoleGuard],data: { 
    expectedRole: 'ROLE_ADMIN'
  } },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
