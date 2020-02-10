import { PerfilVO } from 'src/app/model/user';

export class Publicacao {
    id: string;
    data: Date;
    texto: string;
    perfil: PerfilVO

    constructor() {
        this.perfil = new PerfilVO();
    }
}