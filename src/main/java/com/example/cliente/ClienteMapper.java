package com.example.cliente;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClienteMapper extends CustomMapper<Cliente, ClienteVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private MapperFacade mapper;

    @Override
    public void mapAtoB(Cliente a, ClienteVO b, MappingContext context) {
        if (a.getTipoCliente() != null){
            b.setTipoCliente(mapper.map(a.getTipoCliente(), TipoCliente.class));
        }
    }

    @Override
    public void mapBtoA(ClienteVO b, Cliente a, MappingContext context) {
        System.out.println("map");
        if (b.getTipoCliente() != null){
            a.setTipoCliente(mapper.map(a.getTipoCliente(), ETipoCliente.class));
        }
    }

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Cliente.class, ClienteVO.class)
                .exclude("tipoCliente")
                .byDefault()
                .register();
    }

}
