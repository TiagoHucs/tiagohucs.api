package com.hucs.negocio.perfil;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "PER_DS_NOME")
    private String nome;

    @Lob
    @Column(name = "PER_DS_IMAGEM")
    private String imagem;

}
