package com.hucs.negocio.publicacao;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
//public class PublicacaoVOMapper extends CustomMapper<Publicacao, PublicacaoVO> {
public class PublicacaoVOMapper {

    /*@Autowired
    private MapperFactory mapperFactory;

     @PostConstruct
    public void configure() {
        mapperFactory.classMap(Publicacao.class, PublicacaoVO.class)
                .customize(this)
                .byDefault()
                .register();
    }*/

}
