package com.hucs.negocio.grupo;

import com.hucs.negocio.perfil.Perfil;
import com.hucs.security.user.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UserService userService;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<GrupoVO>> listar() {
        List<Grupo> list = grupoService.listar();
        return ResponseEntity.ok().body(mapper.mapAsList(list,GrupoVO.class));
    }

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity<GrupoVO> save(@RequestBody GrupoVO vo) {
        Perfil perfil = userService.getCurrentUser().getPerfil();
        Grupo grupo = grupoService.criarNovo(vo);
        return ResponseEntity.ok().body(mapper.map(grupo,GrupoVO.class));
    }

    @RequestMapping(value = "/solicitaracesso", method = RequestMethod.POST)
    public ResponseEntity<Void> solicitarAcesso(@RequestBody Long id) {
        grupoService.solicitarAcesso(id);
        return ResponseEntity.ok().build();
    }

}
