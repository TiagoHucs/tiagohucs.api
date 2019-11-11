package com.example.cliente;

import lombok.Getter;

@Getter
public enum ETipoCliente {

    PF("1", "Pessoa Física"),
    PJ("2", "Pessoa Jurídica");

    private String codigo;
    private String descricao;

    ETipoCliente(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

}
