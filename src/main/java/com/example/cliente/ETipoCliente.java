package com.example.cliente;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ETipoCliente {

    PF("1", "Pessoa Física"),
    PJ("2", "Pessoa Jurídica");

    private String codigo;
    private String descricao;
  
    @JsonCreator
    public static ETipoCliente obter(String codigo) {
        for (ETipoCliente t : values()) {
            if (String.valueOf(t.codigo).equals(codigo)) {
                return t;
            }
        }
        return null;
    }

}
