package com.hucs.negocio.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/publicar", method = RequestMethod.POST)
    public ResponseEntity<Void> publicar(@RequestBody Post post) {
        service.publicar(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
