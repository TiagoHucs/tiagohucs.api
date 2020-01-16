import { Perfil } from 'src/app/model/user';

export class Publicacao {
    id: string;
    texto: string;
    perfil: Perfil

    constructor() {
        this.perfil = new Perfil();
    }
}