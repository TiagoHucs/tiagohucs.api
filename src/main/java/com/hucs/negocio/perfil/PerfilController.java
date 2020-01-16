package com.hucs.negocio.perfil;

import com.hucs.security.user.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ResponseEntity<PerfilVO> getPerfil() {
       Perfil perfil = userService.getCurrentUser().getPerfil();
        return ResponseEntity.ok().body(mapper.map(perfil,PerfilVO.class));
    }
}
