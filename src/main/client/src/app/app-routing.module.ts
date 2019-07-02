import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LinksComponent } from './links/links.component';
import { SetlistComponent } from './setlist/setlist.component';
import { AuthGuard } from './security/auth.guard';
import { LoginComponent } from './security/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard]},
  { path: 'links', component: LinksComponent, canActivate: [AuthGuard]},
  { path: 'setlist', component: SetlistComponent, canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
