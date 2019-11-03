package com.example.controller.model;

import com.example.cliente.ClienteVO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoVO {

    private Long id;
    private ClienteVO cliente;
    private List<ItemVO> itens;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;

}

