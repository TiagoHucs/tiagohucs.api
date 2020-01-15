package com.hucs.negocio.publicacao;

import com.hucs.security.entity.User;
import com.hucs.security.jwt.JwtUser;
import com.hucs.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository repository;

    @Autowired
    private UserService userService;

    public Publicacao criar(Publicacao publicacao){
        JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        publicacao.setPerfil(userService.findById(user.getId()).getPerfil());
        publicacao.setData(LocalDateTime.now());
        return repository.save(publicacao);
    }

    public List<Publicacao> listar(){
        return repository.findAll();
    }

}
