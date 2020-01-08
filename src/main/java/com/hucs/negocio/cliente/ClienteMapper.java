package com.hucs.negocio.cliente;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClienteMapper extends CustomMapper<Cliente, ClienteVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @Autowired
    private MapperFacade mapper;

    @Override
    public void mapAtoB(Cliente a, ClienteVO b, MappingContext context) {
        if(a.getTipoCliente()!=null){
            b.setTipoCliente(TipoCliente.builder().codigo(a.getTipoCliente().getCodigo()).descricao(a.getTipoCliente().getDescricao()).build());
        }
    }

    @Override
    public void mapBtoA(ClienteVO b, Cliente a, MappingContext context) {
        if(b.getTipoCliente()!=null){
            a.setTipoCliente(ETipoCliente.obter(b.getTipoCliente().getCodigo()));
        }
    }

    @PostConstruct
    public void configure() {
        mapperFactory.classMap(Cliente.class, ClienteVO.class)
                .customize(this)
                .exclude("tipoCliente")
                .byDefault()
                .register();
    }

}
