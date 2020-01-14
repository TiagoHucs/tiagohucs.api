package com.hucs.negocio.post;

import com.hucs.negocio.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nome;
    @OneToOne
    private Perfil perfil;
}
