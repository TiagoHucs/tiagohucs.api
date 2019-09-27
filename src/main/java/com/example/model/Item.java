package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    private Produto produto;

    @Column
    private Long quantidade;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Orcamento orcamento;
}
