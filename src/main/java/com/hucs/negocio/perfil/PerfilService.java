package com.hucs.negocio.perfil;

import com.hucs.negocio.amizade.AmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private AmizadeService amizadeService;

    public Perfil save(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public List<Perfil> listar(){
        return perfilRepository.findAll();
    }


}
