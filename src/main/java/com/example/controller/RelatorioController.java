package com.example.controller;

import com.example.service.MusicaService;
import com.example.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @RequestMapping(value = "/musicas", method = RequestMethod.POST)
    public ResponseEntity<FileOutputStream> list(){
        try {
            FileOutputStream file = relatorioService.criaRelatorio();
            return ResponseEntity.status(HttpStatus.OK).body(file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
