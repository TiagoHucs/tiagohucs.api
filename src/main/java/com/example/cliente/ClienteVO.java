package com.example.cliente;

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
    private TipoCliente tipoCliente;
}
