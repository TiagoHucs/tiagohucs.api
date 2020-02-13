package com.hucs.negocio.grupo;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<GrupoVO>> listar() {
        List<Grupo> list = grupoService.listar();
        return ResponseEntity.ok().body(mapper.mapAsList(list,GrupoVO.class));
    }
}
