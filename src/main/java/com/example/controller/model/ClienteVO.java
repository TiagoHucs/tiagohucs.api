package com.example.controller.model;

import com.example.model.ETipoCliente;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteVO {

    private Long id;
    private String nome;
    private String cpfcnpj;
    private ETipoCliente tipoCliente;
}
