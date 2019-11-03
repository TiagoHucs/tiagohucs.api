package com.example.model;

import com.example.cliente.Cliente;
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
        if(this.itens == null){
            this.itens = new ArrayList<Item>();
        }

        this.itens.add(item);
        item.setOrcamento(this);
    }

}
