import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { AuthGuard } from '../security/auth.guard';
import { MusicasComponent } from './musicas/musicas.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
            { path: 'produtos', component: ProdutosComponent, canActivate: [AuthGuard]},
            { path: 'musicas', component: MusicasComponent, canActivate: [AuthGuard]},
            { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
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
