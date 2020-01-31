package com.hucs.negocio.amizade;

import com.hucs.negocio.perfil.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    public void adicionaAmigo(Perfil perfil,Perfil amigo){
        Amizade amizade = new Amizade();
        amizade.setPerfil(perfil);
        amizade.setAmigo(amigo);
        amizadeRepository.save(amizade);
    }
}
