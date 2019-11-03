package com.example.model;

import lombok.Getter;

@Getter
public enum ETipoCliente {

    PF(0, "Pessoa Física"),
    PJ(1, "Pessoa Jurídica");

    private int codigo;
    private String descricao;

    ETipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static ETipoCliente getById(Long id){
        for (ETipoCliente tipo: ETipoCliente.values()) {
            if(Long.valueOf(id) == tipo.getCodigo()){
                return tipo;
            }
        }
        return null;
    }

}
