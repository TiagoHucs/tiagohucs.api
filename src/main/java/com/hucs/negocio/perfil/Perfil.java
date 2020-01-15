package com.hucs.negocio.perfil;

import com.hucs.negocio.publicacao.Publicacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_PERFIL")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Perfil {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PER_ID")
    private Long id;
    @Column(name = "PUB_DS_NOME")
    private String nome;


}
