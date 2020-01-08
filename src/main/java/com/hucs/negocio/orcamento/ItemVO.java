package com.hucs.negocio.orcamento;

import com.hucs.negocio.produto.ProdutoVO;
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
