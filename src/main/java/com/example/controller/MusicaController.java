package com.example.controller;

import com.example.model.Musica;
import com.example.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Musica>> list(){
        try {
            List<Musica> result = musicaService.list();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save( @RequestBody Musica musica) {

        try {
            musicaService.save(musica);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Void> update( @RequestBody Musica musica) {

        try {
            musicaService.save(musica);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch(Exception e ) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

        try {
            musicaService.delete(id);
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.OK);
        } catch (Exception e) {
            return (ResponseEntity<Void>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }
}
