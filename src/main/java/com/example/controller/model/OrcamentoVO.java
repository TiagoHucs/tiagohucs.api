package com.example.controller.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrcamentoVO {

    private Long id;
    private ClienteVO cliente;
    private List<ItemVO> itens;

}

