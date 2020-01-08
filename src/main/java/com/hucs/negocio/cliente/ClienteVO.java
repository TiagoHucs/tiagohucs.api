package com.hucs.negocio.cliente;

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
    private TipoCliente tipoCliente;

}
