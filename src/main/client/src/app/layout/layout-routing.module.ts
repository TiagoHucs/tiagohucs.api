import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { AuthGuard } from '../security/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientesComponent } from './clientes/clientes.component';
import { OrcamentoEditarComponent } from './orcamentos/orcamento-editar/orcamento-editar.component';
import { OrcamentoListarComponent } from './orcamentos/orcamento-listar/orcamento-listar.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
            { path: 'produtos', component: ProdutosComponent, canActivate: [AuthGuard]},
            { path: 'orcamento-listar', component: OrcamentoListarComponent, canActivate: [AuthGuard]},
            { path: 'orcamento-editar', component: OrcamentoEditarComponent, canActivate: [AuthGuard]},
            { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
            { path: 'clientes', component: ClientesComponent, canActivate: [AuthGuard]},
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
