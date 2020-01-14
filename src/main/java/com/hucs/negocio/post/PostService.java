package com.hucs.negocio.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post publicar(Post post){
        return repository.save(post);
    }

}
