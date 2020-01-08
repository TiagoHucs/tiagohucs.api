package com.hucs.negocio.cliente;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCliente {
    private String codigo;
    private String descricao;
}
