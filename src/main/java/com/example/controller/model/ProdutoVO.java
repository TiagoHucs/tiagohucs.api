package com.example.controller.model;

import com.example.model.ETipoMedida;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoVO {

    private Long id;
    private String nome;
    private BigDecimal valorUnitario;
    private ETipoMedida tipoMedida;

}
