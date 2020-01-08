package com.hucs.negocio.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpfcnpj;
    @Column
    private ETipoCliente tipoCliente;

}
