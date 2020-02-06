package com.hucs.negocio.perfil;

import com.hucs.security.user.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PerfilController {

    //TODO: substituir pela forma correta de salvar no resource
    private static String UPLOADED_FOLDER = "";

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public ResponseEntity<PerfilVO> getPerfil() {
       Perfil perfil = userService.getCurrentUser().getPerfil();
        return ResponseEntity.ok().body(mapper.map(perfil,PerfilVO.class));
    }

    /*    @RequestMapping(value = "/salvaimagem", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody String imagem) {
        Perfil perfil = userService.getCurrentUser().getPerfil();
        perfil.setImagem(imagem);
        return ResponseEntity.ok().build();
    }*/

    @RequestMapping(value = "/salvaimagem", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody MultipartFile file) {
        file.isEmpty();

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(ResourceUtils.CLASSPATH_URL_PREFIX+UPLOADED_FOLDER);
            //Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }

}
