import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { ProdutosComponent } from './produtos/produtos.component';
import { AuthGuard } from '../security/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ClientesListarComponent } from './clientes/clientes-listar/clientes-listar.component';
import { OrcamentoEditarComponent } from './orcamentos/orcamento-editar/orcamento-editar.component';
import { OrcamentoListarComponent } from './orcamentos/orcamento-listar/orcamento-listar.component';
import { ClientesCadastroComponent } from './clientes/clientes-cadastro/clientes-cadastro.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard', pathMatch: 'prefix' },
            { path: 'produtos', component: ProdutosComponent, canActivate: [AuthGuard]},
            { path: 'orcamentos-listar', component: OrcamentoListarComponent, canActivate: [AuthGuard]},
            { path: 'orcamento-editar', component: OrcamentoEditarComponent, canActivate: [AuthGuard]},
            { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
            { path: 'clientes', component: ClientesListarComponent, canActivate: [AuthGuard]},
            { path: 'clientes/cadastro', component: ClientesCadastroComponent, canActivate: [AuthGuard]},
            
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
