package com.hucs.negocio.publicacao;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    @Autowired
    private PublicacaoService service;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody Publicacao publicacao) {
        service.criar(publicacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PublicacaoVO>> listar() {
        List<PublicacaoVO> list = mapper.mapAsList(service.listar(),PublicacaoVO.class);
        return ResponseEntity.ok(list);
    }
}
