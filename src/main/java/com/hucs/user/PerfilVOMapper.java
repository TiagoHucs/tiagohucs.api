package com.hucs.user;

import com.hucs.negocio.cliente.Cliente;
import com.hucs.negocio.cliente.ClienteVO;
import com.hucs.negocio.cliente.ETipoCliente;
import com.hucs.negocio.cliente.TipoCliente;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;

public class PerfilVOMapper extends CustomMapper<Object, PerfilVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Object.class, PerfilVO.class)
                .customize(this)
                .exclude("password")
                .byDefault()
                .register();
    }
}
