package com.hucs.negocio.grupo;

import com.hucs.negocio.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    public GrupoRepository grupoRepository;

    @Autowired
    private PerfilService perfilService;

    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }

    public Grupo criarNovo(GrupoVO vo){
        Grupo grupo = Grupo.builder()
                .dataHoraCriacao(LocalDateTime.now())
                .dono(perfilService.obterPerfilLogado())
                .nome(vo.getNome())
                .descricao(vo.getDescricao())
                .build();
        return grupoRepository.save(grupo);
    }

    public void solicitarAcesso(Long id){

    }


}
