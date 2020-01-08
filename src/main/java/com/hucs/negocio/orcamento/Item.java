package com.hucs.negocio.orcamento;

import com.hucs.negocio.produto.Produto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
