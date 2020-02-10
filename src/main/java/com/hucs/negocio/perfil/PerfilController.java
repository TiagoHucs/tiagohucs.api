package com.hucs.negocio.perfil;

import com.hucs.security.user.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private PerfilService perfilService;

    @Autowired protected
    ServletContext servletContext;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ResponseEntity<PerfilVO> getPerfil() {
       Perfil perfil = userService.getCurrentUser().getPerfil();
        return ResponseEntity.ok().body(mapper.map(perfil,PerfilVO.class));
    }

    @RequestMapping(value = "/perfil/listar", method = RequestMethod.GET)
    public ResponseEntity<List<PerfilVO>> listar() {
        List<Perfil> perfilList = perfilService.listar();
        return ResponseEntity.ok().body(mapper.mapAsList(perfilList,PerfilVO.class));
    }


    @RequestMapping(value = "/salvaimagem", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody String imagem) {
        Perfil perfil = userService.getCurrentUser().getPerfil();
        perfil.setImagem(imagem);
        return ResponseEntity.ok().build();
    }

/*    @RequestMapping(value = "/salvaimagem", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody MultipartFile file) {
        file.isEmpty();

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath("resources/"));
            Files.write(path, bytes);
            System.out.println("path: "+ path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }*/

}
