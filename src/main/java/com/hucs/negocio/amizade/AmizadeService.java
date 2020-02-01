package com.hucs.negocio.amizade;

import com.hucs.negocio.perfil.Perfil;
import com.hucs.negocio.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private PerfilService perfilService;

    public void adicionaAmigo(Perfil perfil,Perfil amigo){
        Amizade amizade = new Amizade();
        amizade.setPerfil(perfil);
        amizade.setAmigo(amigo);
        amizadeRepository.save(amizade);
    }

    public List<Perfil> getAmigos(Long id){
        List<Amizade> amizades = amizadeRepository.findAllByPerfilId(id);
        List<Perfil> amigos = new ArrayList<>();
        for (Amizade amizade: amizades) {
            amigos.add(amizade.getAmigo());
        }
        return amigos;
    }
}
