package com.hucs.user;

import com.hucs.config.NegocioException;
import com.hucs.negocio.email.EmailService;
import com.hucs.security.entity.User;
import com.hucs.security.enums.ProfileEnum;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrar(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setProfile(ProfileEnum.ROLE_USUARIO);

        User usuario = userService.findByEmail(user.getEmail());
        if(usuario != null)
            throw new NegocioException("Usuario já existe");

            userService.createOrUpdate(user);
        //emailService.sendEmail("App - Novo cadastro", "usuario cadastrado: " + user.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}
