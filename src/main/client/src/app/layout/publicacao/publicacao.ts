import { Perfil } from 'src/app/model/user';

export class Publicacao {
    id: string;
    data: Date;
    texto: string;
    perfil: Perfil

    constructor() {
        this.perfil = new Perfil();
    }
}