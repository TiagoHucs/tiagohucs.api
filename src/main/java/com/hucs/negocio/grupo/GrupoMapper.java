package com.hucs.negocio.grupo;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class GrupoMapper extends CustomMapper<Grupo, GrupoVO> {

        @Autowired
        private MapperFactory mapperFactory;

        @PostConstruct
        public void configure() {
            mapperFactory.classMap(Grupo.class, GrupoVO.class)
                    .customize(this)
                    .byDefault()
                    .register();
        }
}
