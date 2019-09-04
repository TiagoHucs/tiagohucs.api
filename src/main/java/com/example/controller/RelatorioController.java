package com.example.controller;

import com.example.service.MusicaService;
import com.example.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

/*    @PostMapping(path = "/relatoriolistar")
    public ResponseEntity<byte[]> exportarCreditosExcel(@RequestBody String[] ids) {

        byte[] relatorio = relatorioService.criarArquivoRelatorio();

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/vnd.ms-excel")
                .body(relatorio);
    }*/

    @GetMapping (path = "/musicas")
    public ResponseEntity<byte[]> exportarRelatorioExcel() {

        byte[] relatorio = relatorioService.criarArquivoRelatorio();

        return ResponseEntity
                .ok()
                .header("Content-Type", "application/vnd.ms-excel")
                .body(relatorio);
    }
}
