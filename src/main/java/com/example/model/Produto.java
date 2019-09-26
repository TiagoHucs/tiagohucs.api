package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private BigDecimal valor;
    @Column
    private ETipoMedida tipoMedida;
}
