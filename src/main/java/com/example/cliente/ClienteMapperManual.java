package com.example.cliente;

import ma.glasnost.orika.MappingContext;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapperManual {

    public static ClienteVO mapToVO(Cliente obj) {
        ClienteVO vo = new ClienteVO();
        if(obj.getId() != null){
            vo.setId(obj.getId());
        }
        vo.setNome(obj.getNome());
        vo.setCpfcnpj(obj.getCpfcnpj());
        vo.setTipoClienteId(obj.getTipoCliente().getCodigo());
        if (obj.getTipoCliente() != null){
            vo.setTipoCliente(TipoCliente.builder()
                    .codigo(obj.getTipoCliente().getCodigo())
                    .descricao(obj.getTipoCliente().getDescricao())
                    .build());
        }
        return vo;
    }

    public static Cliente mapToObject(ClienteVO vo) {
        Cliente obj = new Cliente();
        if(vo.getId()!=null){
            obj.setId(vo.getId());
        }
        obj.setNome(vo.getNome());
        obj.setCpfcnpj(vo.getCpfcnpj());
        obj.setTipoCliente(ETipoCliente.obter(vo.getTipoClienteId()));
        if (vo.getTipoCliente() != null){
            obj.setTipoCliente(ETipoCliente.obter(vo.getTipoCliente().getCodigo()));
        }
        return obj;
    }

    public static List<ClienteVO> mapAsVoList(List<Cliente> objList){
        List<ClienteVO> voList = new ArrayList<>();
        for (Cliente cliente: objList) {
            voList.add(mapToVO(cliente));
        }
        return voList;
    }
}
