package com.example.controller;

import com.example.security.entity.User;
import com.example.security.enums.ProfileEnum;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrar(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setProfile(ProfileEnum.ROLE_USUARIO);

        try {
            userService.createOrUpdate(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
