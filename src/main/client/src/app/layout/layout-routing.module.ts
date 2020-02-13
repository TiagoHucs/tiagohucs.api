import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { AuthGuard } from '../security/auth.guard';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'home', pathMatch: 'prefix' },
            { path: 'home', component: HomeComponent, canActivate: [AuthGuard]},           
            // { path: 'configuracoes', component: ConfiguracoesComponent,
            //     canActivate: [RoleGuard],data: { 
            //     expectedRole: 'ROLE_ADMIN'
            // }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule {}
