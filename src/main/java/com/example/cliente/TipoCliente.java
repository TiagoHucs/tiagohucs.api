package com.example.cliente;

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
