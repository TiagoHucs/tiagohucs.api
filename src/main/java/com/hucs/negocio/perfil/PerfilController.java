package com.hucs.negocio.perfil;

import com.hucs.negocio.orcamento.OrcamentoVO;
import com.hucs.security.user.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/salvaimagem", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody String imagem) {
        Perfil perfil = userService.getCurrentUser().getPerfil();
        perfil.setImagem(imagem);
        return ResponseEntity.ok().build();
    }

}
