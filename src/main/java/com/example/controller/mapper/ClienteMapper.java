package com.example.controller.mapper;

import com.example.controller.model.ClienteVO;
import com.example.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public ClienteVO map(Cliente obj){
        return ClienteVO.builder()
                .id(obj.getId())
                .cpfcnpj(obj.getCpfcnpj())
                .tipoCliente(obj.getTipoCliente())
                .nome(obj.getNome())
                .build();
    }
}
