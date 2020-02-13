package com.hucs.negocio.grupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    public GrupoRepository grupoRepository;

    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }
}
