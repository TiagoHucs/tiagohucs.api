package com.hucs.negocio.publicacao;

import com.hucs.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository repository;

    @Autowired
    private UserService userService;

    public Publicacao criar(Publicacao publicacao){
        publicacao.setPerfil(userService.getCurrentUser().getPerfil());
        publicacao.setData(LocalDateTime.now());
        return repository.save(publicacao);
    }

    public List<Publicacao> listar(){
        return repository.findAll();
    }

}
