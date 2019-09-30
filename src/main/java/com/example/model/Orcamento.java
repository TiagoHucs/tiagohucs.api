package com.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "orcamento_id")
    private Long id;

    @Column
    private LocalDate dataEmissao;

    @Column
    private LocalDate dataValidade;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, mappedBy = "orcamento")
    private List<Item> itens  = new ArrayList<>();

    public void addItem(Item item){
        this.itens.add(item);
        item.setOrcamento(this);
    }

/*    @ManyToOne
    @JoinColumn(name = "ID", nullable = false)
    private Cliente cliente;*/

    //@ManyToOne
    //@JoinColumn(name = "CLIENTE_ID", nullable = false)
    //private Cliente cliente;


}
