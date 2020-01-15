package com.hucs.negocio.publicacao;

import com.hucs.negocio.perfil.Perfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_PUBLICACAO")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Publicacao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PUB_ID")
    private Long id;
    @Column(name = "PUB_DH_DATA")
    private LocalDateTime data;
    @Column(name = "PUB_DS_TEXTO")
    private String texto;
    @ManyToOne
    @JoinColumn(name = "PER_ID")
    private Perfil perfil;
}
