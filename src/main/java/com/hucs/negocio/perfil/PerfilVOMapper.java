package com.hucs.negocio.perfil;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class PerfilVOMapper extends CustomMapper<Perfil, PerfilVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Perfil.class, PerfilVO.class)
                .customize(this)
                .exclude("password")
                .byDefault()
                .register();
    }
}
