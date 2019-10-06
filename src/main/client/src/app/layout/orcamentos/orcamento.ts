import { ClienteVO } from './../clientes/cliente'
import { ProdutoVO } from './../produtos/produto'

export class OrcamentoVO{
    
    id: number;
    cliente: ClienteVO;
    itens: ItemVO[];
    total: number;

}

export class ItemVO{
    produto: ProdutoVO;
    quantidade: number;
    valorUnitario: number;
    valorTotal: number;
   
}