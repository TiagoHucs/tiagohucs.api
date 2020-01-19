export class User {
    constructor(public id: string,
                public email: string,
                public password: string,
                public profile: string) {
    }
}

export class Perfil {
    id: string;
    nome: string;
    imagem: string;
}
  