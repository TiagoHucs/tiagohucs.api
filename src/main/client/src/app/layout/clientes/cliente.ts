export class ClienteVO{

    id: number;
    nome: string;
    cpfcnpj: string;
    tipoCliente: TipoCliente;
    tipoClienteId: string;

}

export class TipoCliente{
    codigo:string;
    descricao:string;
}