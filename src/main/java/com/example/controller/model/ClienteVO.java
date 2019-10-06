package com.example.controller.model;

import com.example.model.ETipoCliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteVO {

    private Long id;
    private String nome;
    private String cpfcnpj;
    private ETipoCliente tipoCliente;
}
