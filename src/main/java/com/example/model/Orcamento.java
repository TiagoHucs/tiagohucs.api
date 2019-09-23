package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Orcamento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private LocalDate dataEmissao;
    @Column
    private LocalDate dataValidade;;
    @ManyToOne
    private Cliente cliente;
    
    //@ManyToOne
    //@JoinColumn(name = "CLIENTE_ID", nullable = false)
    //private Cliente cliente;
    
    @OneToMany
    private List<Item> itens;

}
