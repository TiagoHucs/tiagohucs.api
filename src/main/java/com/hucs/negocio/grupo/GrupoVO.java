package com.hucs.negocio.grupo;

import com.hucs.negocio.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoVO {

    private Long id;
    private String nome;
    private Perfil perfil;

}
