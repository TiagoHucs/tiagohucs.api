package com.example.cliente;

import com.example.model.ETipoCliente;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClienteMapper extends CustomMapper<Cliente,ClienteVO> {

    @Autowired
    private MapperFactory mapperFactory;

    @Override
    public void mapAtoB(Cliente a, ClienteVO b, MappingContext context) {
        if(a.getId() != null){
            b.setId(a.getId());
        }
        if(a.getNome() != null){
            b.setNome(a.getNome());
        }
        if(a.getCpfcnpj() != null){
            b.setCpfcnpj(a.getCpfcnpj());
        }
        //TODO: mappear esse objeto por fora
        if(a.getTipoCliente() != null){
            b.setTipoCliente(TipoCliente.builder()
                    .codigo(a.getTipoCliente().getCodigo())
                    .descricao(a.getTipoCliente().getDescricao())
                    .build());
        }
    }

    @Override
    public void mapBtoA(ClienteVO b, Cliente a, MappingContext context) {
        if(b.getId() != null){
            a.setId(b.getId());
        }
        if(b.getNome() != null){
            a.setNome(b.getNome());
        }
        if(b.getCpfcnpj() != null){
            a.setCpfcnpj(b.getCpfcnpj());
        }
        if(b.getTipoCliente()!=null){
            a.setTipoCliente(ETipoCliente.getById(b.getId()));
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
