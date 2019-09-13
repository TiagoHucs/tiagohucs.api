export class Produto{

    id: number;
    nome: string;
    valor: number;
    tipoMedida: UnidadeProduto;

}

export class UnidadeProduto{

    codigo: number;
    descricao: string;

}