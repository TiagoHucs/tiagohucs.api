package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping("/musicas")
    public List<String> musicas(){
        List<String> musicas = new ArrayList<String>();
        musicas.add("The killers");
        musicas.add("Tears for fears");
        musicas.add("Cramberries");
        return musicas;
    }
}
