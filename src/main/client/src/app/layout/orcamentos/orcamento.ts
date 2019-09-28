import { Cliente } from './../clientes/cliente'
import { Produto } from './../produtos/produto'

export class Orcamento{
    
    id: number;
    clienteId: number;
    items: Item[];

}

export class Item{

    id: number;
    produto: Produto;
    quantidade: number;  

}