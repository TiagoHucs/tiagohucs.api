package com.example.service;

import com.example.model.Musica;
import com.example.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    public List<Musica> list(){
        return musicaRepository.findAll();
    }

    public void save(Musica musica){
        musicaRepository.save(musica);
    }

    public void delete(Long id){
        musicaRepository.deleteById(id);
    }
}
