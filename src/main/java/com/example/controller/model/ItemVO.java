package com.example.controller.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemVO {

       private ProdutoVO produto;
       private Long quantidade;
       private BigDecimal valorUnitario;

}
