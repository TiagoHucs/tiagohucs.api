package com.hucs.negocio.perfil;

import com.hucs.negocio.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nome;
    @OneToMany
    private List<Post> publicacoes;

}
