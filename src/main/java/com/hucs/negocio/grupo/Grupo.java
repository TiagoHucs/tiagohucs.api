package com.hucs.negocio.grupo;

import com.hucs.negocio.perfil.Perfil;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_GRUPO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Grupo {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GRU_ID")
    private Long id;

    @Column(name = "GRU_DS_NOME", nullable=false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "PER_ID", nullable=false)
    private Perfil dono;

    @ManyToMany
    @JoinTable(name = "TB_GRUPO_INTEGRANTE",joinColumns = @JoinColumn(name = "GRU_ID"),inverseJoinColumns = @JoinColumn(name = "PER_ID"))
    private Set<Perfil> integrantes = new HashSet<>();


}
