import { Cliente } from './../clientes/cliente'
import { Produto } from './../produtos/produto'

export class OrcamentoVO{
    
    id: number;
    clienteId: number;
    itens: Item[];

}

export class Item{

    produtoId: number;
    quantidade: number;
    
}