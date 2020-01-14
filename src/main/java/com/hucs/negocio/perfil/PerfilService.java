package com.hucs.negocio.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil save(Perfil perfil){
        return perfilRepository.save(perfil);
    }
}
