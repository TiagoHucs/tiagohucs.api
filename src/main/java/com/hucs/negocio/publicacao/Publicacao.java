package com.hucs.negocio.publicacao;

import com.hucs.negocio.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private LocalDateTime data;
    @Column
    private String texto;
    @OneToOne
    private Perfil perfil;
}
