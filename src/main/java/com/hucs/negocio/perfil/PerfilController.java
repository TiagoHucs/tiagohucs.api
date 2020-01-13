package com.hucs.negocio.perfil;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ResponseEntity<PerfilVO> getPerfil() {
        Object o = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(mapper.map(o,PerfilVO.class));
    }
}
