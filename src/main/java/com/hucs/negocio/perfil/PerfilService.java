package com.hucs.negocio.perfil;

import com.hucs.negocio.amizade.AmizadeService;
import com.hucs.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private AmizadeService amizadeService;

    @Autowired
    private UserService userService;

    public Perfil save(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public List<Perfil> listar(){
        return perfilRepository.findAll();
    }

    public Perfil obterPerfilLogado(){
        return userService.getCurrentUser().getPerfil();
    }


}
