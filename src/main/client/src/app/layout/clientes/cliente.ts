export class ClienteVO{

    id: number;
    nome: string;
    cpfcnpj: string;
    tipoCliente: TipoCliente;

}

export class TipoCliente{
    codigo:string;
    descricao:string;
}